package excelutil.util;

/**
 * 简单的string功能
 */
public class StringUtil {
    /**
     * 判断是否为空
     * @param charSequence
     * @return
     */
    public static boolean isBlank(CharSequence charSequence){
        return charSequence == null || charSequence.length() == 0;
    }

    /**
     * 判断是否为string类型
     */
    public static boolean isStringType(Class<?> returnType) {
        return returnType.isInstance("");
    }

    public static boolean isIntType(Class<?> returnType) {
        return returnType.isInstance(0) || returnType.isInstance(0L) || returnType.isInstance((short) 0);
    }

}
