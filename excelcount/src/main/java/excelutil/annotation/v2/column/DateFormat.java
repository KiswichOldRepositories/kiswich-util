package excelutil.annotation.v2.column;

import excelutil.constant.DateFormatType;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateFormat {
    DateFormatType DATE_FORMAT_TYPE() default DateFormatType.YAER_DATE_TIME;

    /**
     * 自定义类型，务必符合时间匹配的表达式
     */
    String CUMTOM_DATE_FORMAT() default "";
}
