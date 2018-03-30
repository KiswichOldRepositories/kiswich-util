package excelutil.util;

import org.junit.Test;

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

    /**
     * 获取字符串对应的长度
     *
     * @param string
     * @return
     */
    public static int getWidth(String string) {
        int width = 0;
        for (int i = 0; i < string.length(); i++) {
            width += getWidthUnicode(string.codePointAt(i));
        }
        return width;
    }

    /**
     * 获取单个字符的宽度
     * 现在只区分出中文 即不支持i18
     */
    public static int getWidthUnicode(int code) {
        if (code >= 0x4e00 && code <= 0x9fa5) return 2;
        else return 1;
    }


}
