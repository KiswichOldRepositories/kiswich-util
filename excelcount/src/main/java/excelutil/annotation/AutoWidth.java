package excelutil.annotation;

import java.lang.annotation.*;

/**
 * 使得列宽自动
 * 此时所有的列宽配置失效
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoWidth {
    boolean value() default true;
}
