## excel的生成工具

    面向的是清单的打印，这类清单往往是由一个标题/一行表头/一块数据组成的。
    通过在javabean的class和get方法上添加相应的注解，在通过构造器注入到方
    法类里面作为一个单实例使用。
   
   
### QUICk START 
引入构建

maven
```xml
<dependency>
    <groupId>top.kiswich</groupId>
    <artifactId>excel-count</artifactId>
    <version>1.0.0-RELEASE</version>
</dependency>
```
    
gradle
```
dependencies {
    compile 'top.kiswich:excel-count:1.0.0-RELEASE'
}
```


初始化

```
//初始化
ExcelExporter<FooJavaBean> excel = new ExcelExporter<>(FooJavaBean.class);
//使用
List<FooJavaBean> beans = ...;
excel.putExcelToHttpResponse(
    beans, httpResponse, "demo.xls"
);
```
  
这样就完成了对http请求者的文件流的输出。

### bean 的配置
```java
//配置了一个表名为“Head”的清单(第一行为Head,同时礼貌性合并第二行)
@TableName("Head")
//现在在@tablename上已经默认开启了自动高度和自动宽度的注解
@AutoWidth
public class TestJavaBean {
    private String data1;
    private Integer data2;
    private Date data3;

    //配置了一个表头为“title1”的列，他的顺序代号是5，越小排的越靠前
    @ColumnName(value = "title1", order = 5)
    public String getData1() {
        return data1;
    }

    public TestJavaBean setData1(String data1) {
        this.data1 = data1;
        return this;
    }
    
    //配置了一个自动映射的列，当值为1时（string也支持映射），写入该列的值为data1
    @ColumnName(value = "case", order = 6)
    @MapFormats(map = {@MapFormat(name = "1", value = "data1"),
              @MapFormat(name = "2", value = "data2")})
    public Integer getData2(){
        return data2;
    }
    
    public TestJavaBean setData2(Integer data2){
        this.data2 = data2;
        return  this;
    }
    
    //这里可以使用标准的时间表达式，也可以用DATE_FORMAT_TYPE 配置这里给出的几种常用表达式 默认为(yyyy-MM-dd HH:mm:ss)
    @ColumnName(value = "date", order = 10)
    @DateFormat(customFormatType = "yyyy-MM-dd")
    public Date getData3(){
        return this.data3;
    }
    
    public TestJavaBean setData3(Date data3){
        this.data3 = data3;
        return this;
    }
}
```   


### NOTE

`@ColumnName` 建议配在get方法上，之后可能做这方面的验证。配在这是为了调用方法
后可以直接取到数据。里面有个`width`的参数，是没用的。order的灵感来自于spring的
ioc 2333
`@AutoWidth` 注解能让宽度适配，匹配每列的最大长度，作为宽度。
`@AutoHeight` 让高度适配。他会匹配字符串中的"\n",作为新的一行

这两个注解都通过了一定程度的优化（写死）提高了部分性能，现在是初始化占了比较大的时间。

实际使用中，往往会把复杂数据类型的转换都写到这个bean的构造器里面。

为了兼容一些老项目，没有使用java7以上的特有语法。

### ADVANCE(待)

1.实际使用中，有一种情况是数据库中存有特殊意义的字段，如 "{1:方的,2:圆的"，下一
布是通过bean中的注解完成这一步。
2.excel的字体/字体大小/行高，都应该通过带有默认配置的注解完成。

### UPDATE

---
18-03-31

修正了字符串宽度的算法，使得在中文的情况下不会出现行宽计算错误的情况。且速度依然
远大于原生的POI自动列宽的算法(代价不支持i18n和不能自定义行高和字体大小)

