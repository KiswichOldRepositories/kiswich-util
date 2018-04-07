package excelutil.annotation.v2;

import excelutil.constant.AutoWidthType;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoWidth {
    AutoWidthType AUTO_WIDTH_TYPE() default AutoWidthType.Part;
}
