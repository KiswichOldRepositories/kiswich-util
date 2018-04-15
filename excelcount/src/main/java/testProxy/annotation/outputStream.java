package testProxy.annotation;

import java.lang.annotation.*;

/**
 * 标注参数是参入的输出流
 *
 * @see ToOutputStream
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface outputStream {
}
