package excelutil;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ColumnName {
    //列名
    String value();

    //列宽
    int width() default 80;

    //列的顺序 按从小到大排序
    int order() default Integer.MAX_VALUE;
}
