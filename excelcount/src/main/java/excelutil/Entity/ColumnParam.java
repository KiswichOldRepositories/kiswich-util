package excelutil.Entity;

/**
 * 列初始化的参数封装
 */
public class ColumnParam {
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