package excelutil.constant;

/**
 * 自动定高
 */
public enum AutoHeightType {
    /**
     * 一般的模式，遇到 \n 换行
     */
    COMMON,
    /**
     * 当宽度自适应开启时有效，会根据宽度计算所需行高，并自适应（包括\n）
     * 但是会花费更多的时间
     */
    FIXED,
    /**
     * 不换行
     */
    NONE
}
