package excelutil.util;

import excelutil.annotation.MapFormat;
import excelutil.annotation.MapFormats;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于整形/字符串型的特殊映射的工具
 */
public class MapHelper {


    /**
     * 将注解的内容抽取到map对象里
     *
     * @param mapFormats
     * @return
     */
    public static Map<String, String> parseMap(MapFormats mapFormats) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (mapFormats != null) {
            MapFormat[] maps = mapFormats.map();
            for (MapFormat map : maps) {
                hashMap.put(map.name(), map.value());
            }
        }
        return hashMap;
    }
}
