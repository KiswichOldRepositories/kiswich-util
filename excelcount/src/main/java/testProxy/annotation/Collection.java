package testProxy.annotation;

import java.lang.annotation.*;

/**
 * 标注变量传入的是要转换的集合
 *
 * @see GetWorkbook
 * @see ToFile
 * @see ToHttpResponse
 * @see ToOutputStream
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Collection {
}
