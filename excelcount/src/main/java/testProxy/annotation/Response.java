package testProxy.annotation;

import java.lang.annotation.*;

/**
 * 标注参数是输出的response
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Response {
}
