package excelutil.constant;

/**
 * 转换的格式
 */
public enum DateFormatType {
    YAER_DATE_TIME("yyyy-MM-dd HH:mm:ss"),
    DATE("yyyy-MM-dd"),
    YEAR("yyyy");

    private String dateFormatString;

    DateFormatType(String format) {
        this.dateFormatString = format;
    }

    public String getDateFormatString() {
        return dateFormatString;
    }

    public void setDateFormatString(String dateFormatString) {
        this.dateFormatString = dateFormatString;
    }
}
