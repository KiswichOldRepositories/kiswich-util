package testProxy.annotation;

import java.lang.annotation.*;

/**
 * <p>标注方法是把excel输出搭配httpResponse</p>
 * <p>
 * <pre>
 *      interface FooExport{
 *          ......
 *          @ToHttpResponse
 *          public Workbook getWorkbook(@Collection java.util.Collection<Foo> foos,
 *              @Response HttpServletResponse response,
 *              @FileName String fileName);
 *          ......
 *      }
 * </pre>
 *
 * @see Collection
 * @see Response
 * @see FileName
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ToHttpResponse {
}
