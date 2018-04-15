下一步开发：动态代理

    虽然连完美配置和事件机制都还没做完2333

目前使用中的体会就是，每一个excel打印都要有个exporter，还要管理这个单例。
既然如此，我们可以写下如下接口

```java
interface FooExcelExport{
    @ToFile(closed = true)
    public void exportToFile(@Collection(Foo.class) java.util.Collection<Foo> foos,
    @FilePath String filePath,@FileName String fileName);
    
    @ToHttpResponse
    public void exportToHttpResp(@Collection(Foo.class) java.util.Collection<Foo> foos,
    @Response javax.servlet.http.HttpServletResponse httpServletResponse,
    @FileName String fileName);
    
    @ToOutPutStram(closed = true)
    public void exportToHttpResp(@Collection(Foo.class) java.util.Collection<Foo> foos,
    @OutputStream java.io.OutputStream outputStream);
}
```

随后通过
```
//在Add里可以注入一些全局的配置，因为一个工程打印的需求基本相同，因此全局注入应该没什么问题
//如果有特殊需求，也可以写成两个Interface
FooExcelExport fooExcelExport = ProxyExcel.addXXX(xxx)
    .addXXY(xxx)
    .create(FooExcelExport.class)
```
就可以获得此单例了。。
（动态代理会不会多此一举了 这里也可以通过传入 `Collection<Object>` 来实现对不同打印对象的调用。

## 配合spring ioc容器

```java
    @Configuration
    public class Config{
        @Bean
        public FooExcelExport getFooExcelExport(){
            return fooExcelExport = ProxyExcel.addXXX(xxx)
                .addXXY(xxx)
                .create(FooExcelExport.class);
        }
    }

```