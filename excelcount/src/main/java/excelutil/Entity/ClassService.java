package excelutil.Entity;

import excelutil.annotation.v2.AutoHeight;
import excelutil.annotation.v2.AutoWidth;
import excelutil.annotation.v2.ExcelTable;
import excelutil.constant.AutoHeightType;
import excelutil.constant.AutoWidthType;
import excelutil.constant.ExcelSuffix;
import excelutil.event.FillEvent;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
public class ClassService<T> {
    private Class<T> aClass;

    private List<MethodService> methodServices;
    private Annotation[] annotations;

    private String tableName;

    private boolean autoWidth;
    private boolean autoHeight;

    private AutoWidthType autoWidthType;
    private AutoHeightType autoHeightType;

    private float DATA_FONT_SIZE;
    private float TITLE_FONT_SIZE;
    private float TABLE_FONT_SIZE;
    //数据栏高一定程度上是和数据字体大小有关的
    private float DATA_TABLE_HEIGHT;
    private float TITLE_TABLE_HEIGHT;
    private float TABLE_TABLE_HEIGHT;

    private ExcelSuffix excelSuffix;


    public ClassService(Builder<T> builder) {
        this.aClass = builder.tClass;
        this.methodServices = builder.methodServices;
        this.annotations = builder.annotations;
        this.tableName = builder.tableName;
        this.autoWidth = builder.autoWidth;
        this.autoHeight = builder.autoHeight;
        this.autoHeightType = builder.autoHeightType;
        this.autoWidthType = builder.autoWidthType;

        this.DATA_FONT_SIZE = builder.DATA_FONT_SIZE;
        this.TITLE_FONT_SIZE = builder.TITLE_FONT_SIZE;
        this.TABLE_FONT_SIZE = builder.TABLE_FONT_SIZE;
        this.DATA_TABLE_HEIGHT = builder.DATA_TABLE_HEIGHT;
        this.TITLE_TABLE_HEIGHT = builder.TITLE_TABLE_HEIGHT;
        this.TABLE_TABLE_HEIGHT = builder.TABLE_TABLE_HEIGHT;

        this.excelSuffix = builder.excelSuffix;
    }


    //Builder
    @Getter
    @Setter
    public static class Builder<T> {
        Class<T> tClass;
        FillEvent<T> fillEvent;

        private List<MethodService> methodServices = new ArrayList<>();
        private Method[] methods;
        private Annotation[] annotations;

        private String tableName;

        private boolean autoWidth = true;
        private boolean autoHeight = true;

        private AutoWidthType autoWidthType = AutoWidthType.Part;
        private AutoHeightType autoHeightType = AutoHeightType.COMMON;

        private float DATA_FONT_SIZE = 10;
        private float TITLE_FONT_SIZE = 14;
        private float TABLE_FONT_SIZE = 20;
        //数据栏高一定程度上是和数据字体大小有关的
        private float DATA_TABLE_HEIGHT = 20;
        private float TITLE_TABLE_HEIGHT = 35;
        private float TABLE_TABLE_HEIGHT = 60;

        private ExcelSuffix excelSuffix = ExcelSuffix.xls;


        public Builder(Class<T> tClass, FillEvent<T> fillEvent) {
            this.tClass = tClass;
            this.fillEvent = fillEvent;
        }

        public ClassService build() {
            annotations = tClass.getAnnotations();
            methods = tClass.getMethods();

            fillEvent.beforeResolveAnnotation();

            //解析class注解
            for (Annotation annotation : annotations) {
                parseClassAnnotation(annotation);
            }
            //解析method
            for (Method method : methods) {
                methodServices.add(new MethodService.Builder(method, fillEvent).build());
            }
            //对method进行排序 （据说很快
            Collections.sort(methodServices, new Comparator<MethodService>() {
                @Override
                public int compare(MethodService o1, MethodService o2) {
                    return o1.getOrder() < o2.getOrder() ? -1 :
                            (o1.getOrder().equals(o2.getOrder()) ? 0 : 1);
                }
            });

            fillEvent.afterResolveAnnotation();
            return new ClassService<>(this);
        }

        private void parseClassAnnotation(Annotation annotation) {
            if (annotation instanceof ExcelTable) {
                parseExcelTableAnnotation((ExcelTable) annotation);
            } else if (annotation instanceof AutoWidth) {
                parseAutoWidthAnnotation((AutoWidth) annotation);
            } else if (annotation instanceof AutoHeight) {
                parseAutoHeightAnnotation((AutoHeight) annotation);
            }
        }

        private void parseExcelTableAnnotation(ExcelTable excelTable) {
            this.tableName = excelTable.value();
            this.excelSuffix = excelTable.EXCEL_SUFFIX();

            this.DATA_FONT_SIZE = excelTable.DATA_FONT_SIZE();
            this.TITLE_FONT_SIZE = excelTable.TITLE_FONT_SIZE();
            this.TABLE_FONT_SIZE = excelTable.TABLE_FONT_SIZE();
            this.DATA_TABLE_HEIGHT = excelTable.DATA_TABLE_HEIGHT();
            this.TITLE_TABLE_HEIGHT = excelTable.TITLE_TABLE_HEIGHT();
            this.TABLE_TABLE_HEIGHT = excelTable.TABLE_TABLE_HEIGHT();
        }

        private void parseAutoWidthAnnotation(AutoWidth autoWidth) {
            switch (autoWidth.AUTO_WIDTH_TYPE()) {
                case Part:
                    this.autoWidth = true;
                    this.autoWidthType = AutoWidthType.Part;
                    break;
                case POI:
                    this.autoWidth = true;
                    this.autoWidthType = AutoWidthType.POI;
                    break;
                case NONE:
                    this.autoWidth = false;
                    this.autoWidthType = AutoWidthType.NONE;
                    break;
            }
        }

        private void parseAutoHeightAnnotation(AutoHeight autoHeight) {
            switch (autoHeight.AUTO_HEIGHT_TYPE()) {
                case COMMON:
                    this.autoHeight = true;
                    this.autoHeightType = AutoHeightType.COMMON;
                    break;
                case NONE:
                    this.autoHeight = false;
                    this.autoHeightType = AutoHeightType.NONE;
                    break;
                case FIXED:
                    this.autoHeight = true;
                    this.autoHeightType = AutoHeightType.FIXED;
                    break;
            }
        }


    }
}
