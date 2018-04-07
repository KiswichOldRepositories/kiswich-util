package excelutil.util;


import excelutil.constant.CellType;
import excelutil.constant.DateFormatType;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;


/**
 * 对excel的样式的封装
 */
public class PoiStyleHelper {
    /**
     * 列头单元格样式
     * @param workbook
     * @param i
     * @return
     */
    public static CellStyle getColumnTopStyle(Workbook workbook, int i) {
        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) i);
        //字体加粗
        font.setBold(true);
        //设置字体名字
        font.setFontName("宋体");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        //设置底边框颜色;

        style.setBottomBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());

        //设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HorizontalAlignment.CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        return style;
    }

    /**
     * 列数据信息单元格样式
     * @param workbook
     * @param i
     * @return
     */
    public static CellStyle getStyle(Workbook workbook, int i) {
        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) i);
        //字体加粗取消
        font.setBold(false);
        //设置字体名字
        font.setFontName("宋体");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(true);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HorizontalAlignment.CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        return style;
    }

    /**
     * 获取对应解析方式的时间样式对象
     * @param workbook
     * @param format
     * @return
     */
    public static CellStyle getDateStyle(Workbook workbook, String format) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat(format));
        return cellStyle;
    }

    /**
     * 获取时间样式对象
     * @param workbook
     * @param dateFormatType
     * @return
     */
    public static CellStyle getDateStyle(Workbook workbook, DateFormatType dateFormatType) {
        return getDateStyle(workbook, dateFormatType.getDateFormatString());
    }

    /**
     * 对象转换
     * @param workbook
     * @param cellStyle
     * @param format
     * @return
     */
    public static CellStyle parseDateStyle(Workbook workbook, CellStyle cellStyle, String format) {
        cellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat(format));
        return cellStyle;
    }

    public static CellStyle parseDateStyle(Workbook workbook, CellStyle cellStyle, DateFormatType dateFormatType) {
        return parseDateStyle(workbook, cellStyle, dateFormatType.getDateFormatString());
    }
}
