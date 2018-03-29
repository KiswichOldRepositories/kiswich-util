package excelutil;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableName {
    //表名（即最上方的标题名）
    String value();

    //生成的表格类型 分为xls和xlsx
    String type() default "xls";
}
