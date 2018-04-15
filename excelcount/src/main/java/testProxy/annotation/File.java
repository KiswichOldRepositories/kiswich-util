package testProxy.annotation;

import java.lang.annotation.*;

/**
 * 标注参数是文件
 *
 * @see ToFile
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface File {
}
