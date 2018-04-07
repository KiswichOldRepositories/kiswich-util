package excelutil.constant;

/**
 * 自动定宽
 */
public enum AutoWidthType {
    /**
     * 使用POI自带的宽度自适应,因为效率略慢，不太建议,但是支持i18n
     */
    POI,
    /**
     * 提取了Unicode编码的中文部分做的自适应。
     * 如果只存在中文和英文，且为unicode编码的话，建议使用
     * 优化：对时间/map的列，将会直接确定行宽，而不需要进行列的扫描
     */
    Part,
    /**
     * 不使用宽度自适应
     */
    NONE,

}
