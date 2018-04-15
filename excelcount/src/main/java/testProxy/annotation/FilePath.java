package testProxy.annotation;

import java.lang.annotation.*;

/**
 * 标注文件路径的变量
 *
 * @see ToFile
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FilePath {
}
