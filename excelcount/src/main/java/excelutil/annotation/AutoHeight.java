package excelutil.annotation;

import java.lang.annotation.*;

/**
 * 自动行高配置 默认开启
 * @deprecated 更改了配置方式
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Deprecated
public @interface AutoHeight {
    boolean value() default true;
}
