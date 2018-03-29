package excelutil;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 参考 {@link ExportExcel} ,简化了部分操作的数据库导出工具
 * <p>
 * 原则上，只需要 T tableName tableHead [fileName] ，就可以新建一个excel表
 * <p>
 * 对象应为基本的javaBean，列名和列宽通过注解加入到poi中，
 * 基本的表格配置可通过注解 注入到poi
 * <p>
 * <p>
 * 想支持两种excel格式，但是poi提供的统一接口有一些特有的特征不能统一，暂时先支持xls
 * <p>
 * 新功能预订：1.支持整型/时间格式的输出
 * 2.支持boolean格式的输出，并且支持注解配置对应输出的字符串
 * 3.不确定生成的对象是否为线程安全
 * 4.优化代码结构 功能分类 打包 上传maven..23333
 */
public class ExportObjectExcel<T> {
    private final static float DATA_FRONT_SIZE = 10;
    private final static float TITLE_FRONT_SIZE = 14;
    private final static float TABLE_FRONT_SIZE = 20;
    private final static float DATA_TABLE_HEIGHT = 20;
    private final static float TITLE_TABLE_HEIGHT = 35;
    private final static float TABLE_TABLE_HEIGHT = 65;

    private final Class<T> objectType;
    //第一行的表名
    private String tableHead;
    //第二行的列名和列宽
    private List<ColumnParam> columnParams;
    //这里包含了需要调用的方法
    private List<Method> methods;

    private boolean isAutoWidth = false;
    private String excelType;

    public ExportObjectExcel(Class<T> objectType) {
        this.objectType = objectType;
        this.columnParams = new ArrayList<>();
        this.methods = new ArrayList<>();
        TableName tableName = objectType.getAnnotation(TableName.class);
        AutoWidth isAutoWidth = objectType.getAnnotation(AutoWidth.class);
        this.tableHead = tableName.value();
        this.excelType = tableName.type();
        if (isAutoWidth != null && isAutoWidth.value()) this.isAutoWidth = true;

        for (Method method : objectType.getMethods()) {
            ColumnName columnName = method.getAnnotation(ColumnName.class);
            if (columnName != null) {
                addMethodInOrder(method, columnName);
            }
        }
    }

    /**
     * 按method注解中的 {@link ColumnName} 的 order值，从小到大进行插入排序，如果有相等的，就放在后面
     *
     * @param method
     */
    private void addMethodInOrder(Method method, ColumnName columnName) {
        int width = columnName.width();
        int order = columnName.order();
        String headName = columnName.value();
        for (int i = 0; i < columnParams.size(); i++) {
            ColumnParam columnParam = columnParams.get(i);
            if (columnParam.getOrder() > order) {
                columnParams.add(i, new ColumnParam(headName, width, order));
                methods.add(i, method);
                return;
            }
        }
        columnParams.add(new ColumnParam(headName, width, order));
        methods.add(method);
    }

    public Workbook getWorkbook(Collection<T> ts) throws TypeErrorException, InvocationTargetException, IllegalAccessException {
        //1.创建对象
        Workbook workbook;
        switch (excelType) {
            case "xls":
                workbook = new HSSFWorkbook();
                break;
            case "xlsx":
                workbook = new XSSFWorkbook();
                break;
            default:
                throw new TypeErrorException("error type names " + excelType);
        }
        Sheet sheet = workbook.createSheet(this.tableHead);

        //2.填充表名
        int size = columnParams.size();
        Row row = sheet.createRow(0);
        Cell titleCell = row.createCell(0);
        row.setHeightInPoints(TABLE_TABLE_HEIGHT);

        CellStyle columnTopStyle = this.getColumnTopStyle(workbook, (int) TABLE_FRONT_SIZE);
        CellStyle style = this.getStyle(workbook);

        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, size - 1));
        titleCell.setCellStyle(columnTopStyle);
        titleCell.setCellValue(this.tableHead);

        //3.填充列名
        CellStyle columnTopStyle1 = this.getColumnTopStyle(workbook, (int) TITLE_FRONT_SIZE);
        Row headRow = sheet.createRow(2);
        headRow.setHeightInPoints(TITLE_TABLE_HEIGHT);
        for (int i = 0; i < columnParams.size(); i++) {
            ColumnParam columnParam = columnParams.get(i);
            Cell headRowCell = headRow.createCell(i);
            headRowCell.setCellType(Cell.CELL_TYPE_STRING);
            headRowCell.setCellValue(columnParam.getHeadName());
            headRowCell.setCellStyle(columnTopStyle1);
        }

        //4.循环填充数据
        Iterator<T> iterator = ts.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            T obj = iterator.next();
            Row sheetRow = sheet.createRow(index + 3);
            sheetRow.setHeightInPoints(DATA_TABLE_HEIGHT);

            int rowMaxLine = 1;
            for (int i = 0; i < methods.size(); i++) {
                Method method = methods.get(i);
                Cell cell = sheetRow.createCell(i);
                String cellText = (String) method.invoke(obj);

                //行高自适应（即匹配换行符）
                if (this.isAutoWidth && StringUtils.isNotBlank(cellText)) {
                    Pattern compile = Pattern.compile("\n");
                    Matcher matcher = compile.matcher(cellText);
                    int count = 1;
                    while (matcher.find()) {
                        count++;
                    }
                    if (count > rowMaxLine) {//比当前最大的行数还要大
                        float heightInPoints = sheetRow.getHeightInPoints();
                        sheetRow.setHeightInPoints((count + 1) * (DATA_FRONT_SIZE));
                        rowMaxLine = count;
                    }
                }

                //写入数据
                cell.setCellValue(StringUtils.isNotBlank(cellText) ?
                        cellText : "");
                cell.setCellStyle(style);
            }
            index++;
        }

        //5.自适应
        if (this.isAutoWidth) {
            for (int columnIndex = 0; columnIndex < columnParams.size(); columnIndex++) {
                sheet.autoSizeColumn(columnIndex);
            }
        }

        return workbook;
    }

    public void putExcelToHttpResponse(Collection<T> ts, HttpServletResponse response, String fileName) throws TypeErrorException, IllegalAccessException, InvocationTargetException {

        Workbook workbook = getWorkbook(ts);
        response.setContentType("multipart/form-data");
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(outputStream);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 列头单元格样式
     */
    public CellStyle getColumnTopStyle(Workbook workbook, int i) {

        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) i);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("宋体");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(CellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(CellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(CellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(CellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(CellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        return style;

    }

    /*
     * 列数据信息单元格样式
     */
    public CellStyle getStyle(Workbook workbook) {
        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) DATA_FRONT_SIZE);
        //字体加粗
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("宋体");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(CellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(CellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(CellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(CellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(true);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(CellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        return style;

    }

    /**
     * 保存
     */
    private class ColumnParam {
        private String headName;
        private int width;
        //这个order只在初始化的时候有用
        private Integer order;

        public ColumnParam() {
        }

        public ColumnParam(String headName, int width) {
            this.headName = headName;
            this.width = width;
        }

        public ColumnParam(String headName, int width, Integer order) {
            this.headName = headName;
            this.width = width;
            this.order = order;
        }

        public String getHeadName() {
            return headName;
        }

        public void setHeadName(String headName) {
            this.headName = headName;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }
    }

    //用于测试
    public static void main(String[] a) {
        ExportObjectExcel<TestDemo> excel = new ExportObjectExcel<>(TestDemo.class);
        TestDemo testDemo = new TestDemo();
        testDemo.setAge("aaa");
        testDemo.setName("wwdddddddddddddddddd\nddddddddddw");
        ArrayList<TestDemo> testDemos = new ArrayList<>();
        testDemos.add(testDemo);
        try {

            Workbook workbook = excel.getWorkbook(testDemos);
            File file = new File("E://newtext.xls");
            if (!file.exists()) {
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);


        } catch (TypeErrorException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
