package excelutil.annotation;

import java.lang.annotation.*;

/**
 * 自动行高配置 默认开启
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoHeight {
    boolean value() default true;
}
