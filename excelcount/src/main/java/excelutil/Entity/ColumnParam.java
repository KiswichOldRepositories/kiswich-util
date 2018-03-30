package excelutil.Entity;

import excelutil.constant.CellType;
import org.apache.poi.ss.usermodel.CellStyle;

import java.util.Map;

/**
 * 列初始化的参数封装
 */
public class ColumnParam<T> {
    private String headName;
    private int width;
    //这个order只在初始化的时候有用
    private Integer order;
    //当前单元格的格式
    private CellType cellType;
    //映射
    private Map<String, String> map;
    //时间
    private String dateFormat;
    private CellStyle dateStyle;

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

    public ColumnParam(String headName, int width, Integer order, CellType cellType, Map<String, String> map) {
        this.headName = headName;
        this.width = width;
        this.order = order;
        this.cellType = cellType;
        this.map = map;
    }

    public ColumnParam(String headName, int width, Integer order, CellType cellType, Map<String, String> map, String dateFormat) {
        this.headName = headName;
        this.width = width;
        this.order = order;
        this.cellType = cellType;
        this.map = map;
        this.dateFormat = dateFormat;
    }

    public String getHeadName() {
        return headName;
    }

    public ColumnParam setHeadName(String headName) {
        this.headName = headName;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public ColumnParam setWidth(int width) {
        this.width = width;
        return this;
    }

    public Integer getOrder() {
        return order;
    }

    public ColumnParam setOrder(Integer order) {
        this.order = order;
        return this;
    }

    public CellType getCellType() {
        return cellType;
    }

    public ColumnParam setCellType(CellType cellType) {
        this.cellType = cellType;
        return this;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public ColumnParam setMap(Map<String, String> map) {
        this.map = map;
        return this;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public ColumnParam setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public CellStyle getDateStyle() {
        return dateStyle;
    }

    public void setDateStyle(CellStyle dateStyle) {
        this.dateStyle = dateStyle;
    }
}