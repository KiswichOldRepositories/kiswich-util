package excelutil.annotation;

import excelutil.constant.DateFormatType;

import java.lang.annotation.*;

/**
 * 日期的自定义转换形式
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateFormat {
    DateFormatType DATE_FORMAT_TYPE() default DateFormatType.YAER_DATE_TIME;

    //自定义类型，DATE_FORMAT_TYPE 配置会失效，注意类型配置需要符合SimpleDateFormat的规范
    String customFormatType() default "";
}
