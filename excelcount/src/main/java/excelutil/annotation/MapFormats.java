package excelutil.annotation;

import java.lang.annotation.*;
import java.util.Map;

/**
 * 开启映射的转换
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Deprecated

public @interface MapFormats {
    String defaultValue() default "";

    //映射
    MapFormat[] map();
}
