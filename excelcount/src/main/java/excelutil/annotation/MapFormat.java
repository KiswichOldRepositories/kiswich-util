package excelutil.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MapFormat {
    //对象中源数据
    String name();

    //需要映射成的数据
    String value();
}
