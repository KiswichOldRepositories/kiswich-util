package excelutil.annotation;

import excelutil.constant.ExcelType;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//现在此注解自动加了
@AutoWidth
@AutoHeight
public @interface TableName {
    //表名（即最上方的标题名）
    String value();

    //生成的表格类型 分为xls和xlsx
    ExcelType type() default ExcelType.xls;
}
