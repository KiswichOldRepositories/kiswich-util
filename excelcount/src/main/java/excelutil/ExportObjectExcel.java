package excelutil;


import excelutil.Entity.ColumnParam;
import excelutil.annotation.*;
import excelutil.constant.DateFormatType;
import excelutil.constant.ExcelType;
import excelutil.exception.TypeErrorException;
import excelutil.util.MapUtil;
import excelutil.util.PoiStyleUtil;
import excelutil.util.StringUtil;
import excelutil.util.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sun.security.util.Length;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 简化了部分操作的数据库导出工具
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
    //和下面的行高适配和列宽适配略有耦合
    private final static float DATA_FONT_SIZE = 10;
    private final static float TITLE_FONT_SIZE = 14;
    private final static float TABLE_FONT_SIZE = 20;
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
    private boolean isAutoHeight = false;
    private ExcelType excelType;

    public ExportObjectExcel(Class<T> objectType) throws TypeErrorException {
        this.objectType = objectType;
        this.columnParams = new ArrayList<>();
        this.methods = new ArrayList<>();
        TableName tableName = objectType.getAnnotation(TableName.class);
        AutoWidth isAutoWidth = objectType.getAnnotation(AutoWidth.class);
        AutoHeight autoHeight = objectType.getAnnotation(AutoHeight.class);
        this.tableHead = tableName.value();
        this.excelType = tableName.type();
        if (isAutoWidth != null && isAutoWidth.value()) this.isAutoWidth = true;
        if (autoHeight != null && autoHeight.value()) this.isAutoHeight = true;

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
    private void addMethodInOrder(Method method, ColumnName columnName) throws TypeErrorException {
        int width = columnName.width();
        int order = columnName.order();
        String headName = columnName.value();
        for (int i = 0; i < columnParams.size(); i++) {
            ColumnParam columnParam = columnParams.get(i);
            if (columnParam.getOrder() > order) {
                this.columnParams.add(i, checkAndSetParam(method).setHeadName(headName).setWidth(width).setOrder(order));
                methods.add(i, method);
                return;
            }
        }
        this.columnParams.add(checkAndSetParam(method).setHeadName(headName).setWidth(width).setOrder(order));
        methods.add(method);
    }

    /**
     * 检查参数映射，并构造参数实体类
     */
    private ColumnParam checkAndSetParam(Method method) throws TypeErrorException {
        //确定参数类型
        Class<?> returnType = method.getReturnType();
        if (StringUtil.isStringType(returnType)) {
            ColumnParam<String> stringColumnParam = new ColumnParam<>();
            //处理映射
            stringColumnParam.setMap(MapUtil.parseMap(method.getAnnotation(MapFormats.class)));
            stringColumnParam.setCellType(excelutil.constant.CellType.STRING);
            return stringColumnParam;
        }
        if (StringUtil.isIntType(returnType)) {
            ColumnParam<Integer> integerColumnParam = new ColumnParam<>();
            integerColumnParam.setMap(MapUtil.parseMap(method.getAnnotation(MapFormats.class)));
            integerColumnParam.setCellType(excelutil.constant.CellType.INT);
            return integerColumnParam;
        }
        if (TimeUtil.isDateType(returnType)) {
            ColumnParam dateColumnParam = new ColumnParam();
            DateFormat dateFormat = method.getAnnotation(DateFormat.class);
            if (dateFormat == null) {
                dateColumnParam.setDateFormat(DateFormatType.YAER_DATE_TIME.getDateFormatString());
            } else {
                dateColumnParam.setDateFormat(
                        dateFormat.customFormatType().equals("") ? dateFormat.DATE_FORMAT_TYPE().getDateFormatString() : dateFormat.customFormatType());
            }
            dateColumnParam.setCellType(excelutil.constant.CellType.DATE);
            return dateColumnParam;
        }
        throw new TypeErrorException("暂不支持 " + returnType.toString() + " 类型");
    }

    public Workbook getWorkbook(Collection<T> ts) throws TypeErrorException, InvocationTargetException, IllegalAccessException {
//        Date date = new Date();
        //1.创建对象
        Workbook workbook;
        switch (excelType) {
            case xls:
                workbook = new HSSFWorkbook();
                break;
            case xlsx:
                workbook = new XSSFWorkbook();
                break;
            default:
                throw new TypeErrorException("error type names " + excelType);
        }
        Sheet sheet = workbook.createSheet(this.tableHead);

//        Date date1 = new Date();
        //2.填充表名
        int size = columnParams.size();
        Row row = sheet.createRow(0);
        Cell titleCell = row.createCell(0);
        row.setHeightInPoints(TABLE_TABLE_HEIGHT);

        CellStyle columnTopStyle = PoiStyleUtil.getColumnTopStyle(workbook, (int) TABLE_FONT_SIZE);

        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, size - 1));
        titleCell.setCellStyle(columnTopStyle);
        titleCell.setCellValue(this.tableHead);

//        Date date2 = new Date();
        //3.填充列名
        CellStyle columnTopStyle1 = PoiStyleUtil.getColumnTopStyle(workbook, (int) TITLE_FONT_SIZE);
        Row headRow = sheet.createRow(2);
        headRow.setHeightInPoints(TITLE_TABLE_HEIGHT);
        for (int i = 0; i < columnParams.size(); i++) {
            ColumnParam columnParam = columnParams.get(i);
            Cell headRowCell = headRow.createCell(i);

            headRowCell.setCellType(CellType.STRING);
            headRowCell.setCellValue(columnParam.getHeadName());
            headRowCell.setCellStyle(columnTopStyle1);
        }

        CellStyle style = PoiStyleUtil.getStyle(workbook, (int) DATA_FONT_SIZE);

//        Date date3 = new Date();
        //4.循环填充数据
        Iterator<T> iterator = ts.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            T obj = iterator.next();
            Row sheetRow = sheet.createRow(index + 3);
            sheetRow.setHeightInPoints(DATA_TABLE_HEIGHT);
            //最大行 （用来做行高匹配）
            int rowMaxLine = 1;
            for (int i = 0; i < methods.size(); i++) {
                Method method = methods.get(i);
                ColumnParam columnParam = this.columnParams.get(i);
                Cell cell = sheetRow.createCell(i);

                Object cellCompont = method.invoke(obj);
                String cellText = null;
                cell.setCellStyle(style);

                //写入数据
                switch (columnParam.getCellType()) {
                    case STRING:
                        cellText = (String) cellCompont;
                        if (columnParam.getMap() != null && columnParam.getMap().size() != 0) {
                            cell.setCellValue((String) columnParam.getMap().get(cellCompont));
                        } else {
                            cell.setCellValue((String) cellCompont);
                        }

                        break;
                    case DATE:
                        cellText = TimeUtil.dateToString(cellCompont, columnParam.getDateFormat());
                        cell.setCellValue(cellText);
//                        cell.setCellStyle(PoiStyleUtil.parseDateStyle(workbook,PoiStyleUtil.getStyle(workbook,(int) DATA_FONT_SIZE),columnParam.getDateFormat()));
                        break;
                    case INT:
                        cellText = String.valueOf(cellCompont);
                        if (columnParam.getMap() != null && columnParam.getMap().size() != 0) {
                            cell.setCellValue((String) columnParam.getMap().get(cellText));
                        } else {
                            cell.setCellValue(cellText);
                        }
                        break;
                }

                //行高自适应（即匹配换行符）【想必时间也只有一行的吧23333】
                if (this.isAutoHeight && columnParam.getCellType() == excelutil.constant.CellType.INT || columnParam.getCellType() == excelutil.constant.CellType.STRING) {
                    Pattern compile = Pattern.compile("\n");
                    Matcher matcher = compile.matcher(cellText);
                    int count = 1;
                    while (matcher.find()) {
                        count++;
                    }
                    if (count > rowMaxLine) {//比当前最大的行数还要大
                        float heightInPoints = sheetRow.getHeightInPoints();
                        sheetRow.setHeightInPoints((count + 1) * (DATA_FONT_SIZE));
                        rowMaxLine = count;
                    }
                }
            }
            index++;
        }

//        Date date4 = new Date();
        //5.自适应 (写死以提高性能)
        //与poi自带的宽度自适应相比 速度提高了80倍,,,,,,,
        if (this.isAutoWidth) {
            for (int columnIndex = 0; columnIndex < columnParams.size(); columnIndex++) {
                int columnWidth = sheet.getColumnWidth(columnIndex) / 256;
                //在某些列较短的情况下，可能出现标题被挡住的情况，此时增大标题的权重（简称写死以提高性能）
                Row titleRow = sheet.getRow(2);
                if (titleRow != null) {
                    if (titleRow.getCell(columnIndex) != null) {
                        Cell currentCell = titleRow.getCell(columnIndex);
                        String text = currentCell.toString();
                        int length = text.length() * 2;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }

                for (int rowNum = 3; rowNum < sheet.getLastRowNum() + 1; rowNum++) {
                    Row currentRow = sheet.getRow(rowNum);
                    if (currentRow != null) {
                        if (currentRow.getCell(columnIndex) != null) {
                            Cell currentCell = currentRow.getCell(columnIndex);
                            String texts = currentCell.toString();

                            for (String text : texts.split("\n")) {
                                int length = text.length();
                                if (columnWidth < length) {
                                    columnWidth = length;
                                }
                            }
                        }
                    }
                }
                sheet.setColumnWidth(columnIndex, (columnWidth + 1) * 256);
            }
        }

//        Date date5 = new Date();
//        System.out.println(date1.getTime() - date.getTime());
//        System.out.println(date2.getTime() - date1.getTime());
//        System.out.println(date3.getTime() - date2.getTime());
//        System.out.println(date4.getTime() - date3.getTime());
//        System.out.println(date5.getTime() - date4.getTime());
        return workbook;
    }


    /**
     * 将excel传到response里
     */
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

    /**
     * 将excel传到某个流里,默认是不会关闭流的
     */
    public void putExcelToOutputstream(Collection<T> ts, OutputStream outputStream) throws IOException, TypeErrorException, IllegalAccessException, InvocationTargetException {
        putExcelToOutputstream(ts, outputStream, false);
    }

    public void putExcelToOutputstream(Collection<T> ts, OutputStream outputStream, boolean closeed) throws IOException, TypeErrorException, IllegalAccessException, InvocationTargetException {
        try {
            Workbook workbook = getWorkbook(ts);
            workbook.write(outputStream);
        } finally {
            if (closeed && outputStream != null) outputStream.close();
        }
    }

    /**
     * 将excel写入文件
     */
    public void putExcelToOutputstream(Collection<T> ts, String fileName) throws IOException, TypeErrorException, IllegalAccessException, InvocationTargetException {
        File file = new File(fileName);
        if (!file.exists()) file.createNewFile();

        try (OutputStream outputStream = new FileOutputStream(file)) {
            Workbook workbook = getWorkbook(ts);
            workbook.write(outputStream);
        }
    }
}
