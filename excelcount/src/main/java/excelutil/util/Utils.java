package excelutil.util;

/**
 * 直接工具类
 */
public class Utils {

    /**
     * 传入的必须是一个单接口
     */
    public static <T> void validateServiceInterface(Class<T> service) {
        if (!service.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        if (service.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }
}
