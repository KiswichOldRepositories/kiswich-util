package top.kiswich.googleoauth.util;

/**
 * 用来判断string
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     * @param string
     * @return
     */
    public static boolean isBlank(String string) {
        return string == null || string.length() == 0 || string.trim().length() == 0;
    }

}
