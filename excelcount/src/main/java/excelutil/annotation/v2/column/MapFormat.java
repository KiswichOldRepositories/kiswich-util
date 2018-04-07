package excelutil.annotation.v2.column;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MapFormat {
    String[] name();

    String[] value();
}
