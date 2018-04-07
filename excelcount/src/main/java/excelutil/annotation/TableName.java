package excelutil.annotation;

import excelutil.constant.ExcelSuffix;

import java.lang.annotation.*;

/**
 * @deprecated 使用更贴近语义的 {@link excelutil.annotation.v2.ExcelTable}
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//现在此注解自动加了
@AutoWidth
@AutoHeight
@Deprecated

public @interface TableName {
    //表名（即最上方的标题名）
    String value();

    //生成的表格类型 分为xls和xlsx
    ExcelSuffix type() default ExcelSuffix.xls;

    //字体配置
    float DATA_FONT_SIZE() default 10f;

    float TITLE_FONT_SIZE() default 14f;

    float TABLE_FONT_SIZE() default 20f;

    float DATA_TABLE_HEIGHT() default 20f;

    float TITLE_TABLE_HEIGHT() default 35f;

    float TABLE_TABLE_HEIGHT() default 65f;

}
