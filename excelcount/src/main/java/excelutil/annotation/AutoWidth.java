package excelutil.annotation;

import java.lang.annotation.*;

/**
 * 使得列宽自动
 * 此时所有的列宽配置失效
 *
 * @since 0.0.1 现在自动配置此项
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoWidth {
    boolean value() default true;
}
