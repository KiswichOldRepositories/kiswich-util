package excelutil.annotation.v2;

import java.lang.annotation.*;

/**
 * TODO 支持自定义属性的配置
 * 这个注解请假在get方法上，用来获取bean的属性
 * 其次会根据get方法返回的类型，决定是date属性或者string\int
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {
    //显示的列名
    String value();

    //序号 决定excel列的顺序
    int order() default Integer.MAX_VALUE;

    //列宽
    int width() default 0;


}
