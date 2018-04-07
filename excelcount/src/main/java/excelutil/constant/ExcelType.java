package excelutil.constant;

/**
 * excel的生成类型
 */
public enum ExcelType {
    normal,
    /**
     * 优化，目前的做法是，超过一定大小的集合注入时，就会放弃自动宽高等样式调整
     * （不然遍历这些数据将会花费大量时间）
     */
    optimization,
}
