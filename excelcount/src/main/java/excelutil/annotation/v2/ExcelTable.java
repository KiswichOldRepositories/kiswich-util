package excelutil.annotation.v2;

import excelutil.constant.ExcelSuffix;
import excelutil.constant.ExcelType;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented

@AutoHeight
@AutoWidth
public @interface ExcelTable {
    //表名 当value为空时，第一行的标题省略
    String value() default "";

    ExcelSuffix EXCEL_SUFFIX() default ExcelSuffix.xls;

    //表的类型
    ExcelType EXCEL_TYPE() default ExcelType.normal;

}
