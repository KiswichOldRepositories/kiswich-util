package excelutil.constant;

/**
 * excel
 */
public enum ExcelType {
    xls("xls"),
    xlsx("xlsx");

    private String type;

    ExcelType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
