package testProxy.annotation;

import java.lang.annotation.*;

/**
 * 标注参数是文件名
 *
 * @see ToFile
 * @see ToHttpResponse
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FileName {
}
