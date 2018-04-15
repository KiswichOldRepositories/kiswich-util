package excelutil.Entity;

import com.sun.istack.internal.NotNull;
import excelutil.annotation.v2.ExcelColumn;
import excelutil.annotation.v2.ExcelTable;
import excelutil.annotation.v2.column.DateFormat;
import excelutil.annotation.v2.column.MapFormats;
import excelutil.event.FillEvent;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 参考retrofit设计的方法。。
 */
@Getter
@Setter
public class MethodService {
    //get方法上的注解
    private Annotation[] annotations;
    //get方法
    private Method method;
    @NotNull
    private FillEvent fillEvent;
    private String columnName;
    private Integer columnWidth;
    private String cellText;

    private Integer fontSize;
    private Integer order;

    public MethodService(Builder builder) {
        //TODO 构造方法
    }


    //Builder
    public static class Builder {
        Method method;
        FillEvent fillEvent;

        Annotation[] annotations;
        String columnName;
        Integer columnWidth;
        String cellText;
        Integer fontSize;

        public Builder(Method method, FillEvent fillEvent) {
            this.method = method;
            this.fillEvent = fillEvent;
        }

        public MethodService build() {
            annotations = method.getAnnotations();

            for (Annotation annotation : annotations) {
                parseMethodAnnotation(annotation);
            }

            return new MethodService(this);
        }

        private void parseMethodAnnotation(Annotation annotation) {
            //TODO 解析method注解
            if (annotation instanceof ExcelColumn) {
                parseExcelColumnAnnotation((ExcelColumn) annotation);
            } else if (annotation instanceof MapFormats) {
                parseMapFormatsAnnotation((MapFormats) annotation);
            } else if (annotation instanceof DateFormat) {
                parseDateFormatAnnotation((DateFormat) annotation);
            }
        }

        private void parseExcelColumnAnnotation(ExcelColumn excelColumn) {

        }

        private void parseMapFormatsAnnotation(MapFormats mapFormats) {

        }

        private void parseDateFormatAnnotation(DateFormat dateFormat) {

        }

        static Class<?> boxIfPrimitive(Class<?> type) {
            if (boolean.class == type) return Boolean.class;
            if (byte.class == type) return Byte.class;
            if (char.class == type) return Character.class;
            if (double.class == type) return Double.class;
            if (float.class == type) return Float.class;
            if (int.class == type) return Integer.class;
            if (long.class == type) return Long.class;
            if (short.class == type) return Short.class;
            return type;
        }


    }


}
