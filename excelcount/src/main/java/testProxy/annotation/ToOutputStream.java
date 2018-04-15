package testProxy.annotation;

import java.lang.annotation.*;

/**
 * <p>标注方法是将excel输出到一个流上</p>
 * <p>
 * <pre>
 *      interface FooExport{
 *          ......
 *          @ToOutputStream
 *          public Workbook getWorkbook(@Collection java.util.Collection<Foo> foos,
 *              @outputStream OutputStream outputStream);
 *          ......
 *      }
 * </pre>
 *
 * @see Collection
 * @see outputStream
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ToOutputStream {
    /**
     * 是否最后将流关闭
     *
     * @return
     */
    boolean closed() default true;
}
