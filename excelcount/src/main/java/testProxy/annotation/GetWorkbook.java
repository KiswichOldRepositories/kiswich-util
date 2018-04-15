package testProxy.annotation;

import java.lang.annotation.*;

/**
 * <p>标注方法的动作是返回生成的workbook（poi）</p>
 * <p>
 * <pre>
 *      interface FooExport{
 *          ......
 *          @GetWorkbook
 *          public Workbook getWorkbook(@Collection java.util.Collection<Foo> foos);
 *          ......
 *      }
 *  </pre>
 *
 * @see Collection
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GetWorkbook {
}
