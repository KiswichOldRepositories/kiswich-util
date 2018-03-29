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

}
