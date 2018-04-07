package excelutil.constant;

/**
 * excel
 */
public enum ExcelSuffix {
    xls("xls"),
    xlsx("xlsx");

    private String type;

    ExcelSuffix(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
