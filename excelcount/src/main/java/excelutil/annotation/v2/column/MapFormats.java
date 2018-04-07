package excelutil.annotation.v2.column;

import java.lang.annotation.*;

/**
 * 对写入excel的值得匹配，
 * 对于复杂的匹配，也可以在{@code Foo} 构造的时候注入
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MapFormats {
    MapFormat[] MAP_FORMATS();
}
