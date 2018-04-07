package excelutil.annotation.v2;

import excelutil.constant.AutoHeightType;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoHeight {
    AutoHeightType AUTO_HEIGHT_TYPE() default AutoHeightType.COMMON;
}
