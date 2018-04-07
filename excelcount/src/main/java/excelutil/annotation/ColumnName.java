package excelutil.annotation;


import excelutil.constant.CellType;

import java.lang.annotation.*;

/**
 * @deprecated 使用更贴近语义的 {@link excelutil.annotation.v2.ExcelColumn}
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Deprecated

public @interface ColumnName {
    //列名
    String value();

    //列宽
    int width() default 0;

    //列的顺序 按从小到大排序
    int order() default Integer.MAX_VALUE;
}
