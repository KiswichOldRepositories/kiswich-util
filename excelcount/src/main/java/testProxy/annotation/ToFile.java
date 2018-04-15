package testProxy.annotation;

import java.lang.annotation.*;

/**
 * <p>标注方法是把excel输出到文件</p>
 * <p>
 * <pre>
 *      interface FooExport{
 *          ......
 *          @ToFile
 *          public void foosToFile(@Collection java.util.Collection<Foo> foos,
 *              @FileName String fileName,@FilePath String filePath);
 *          ......
 *          @ToFile
 *          public void foosToFile(@Collection java.util.Collection<Foo> foos,
 *              @File File file);
 *          ......
 *      }
 * </pre>
 *
 * @see Collection
 * @see FileName
 * @see FilePath
 * @see File
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ToFile {
}
