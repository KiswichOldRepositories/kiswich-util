package top.kiswich.googleoauth.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
    public static Map<String,String> getMap(String code,String clientId,String clientSecret,String RedirectUrl,String grantType){
        HashMap<String, String> map = new HashMap<>();
        map.put("code",code);
        map.put("client_id",clientId);
        map.put("client_secret",clientSecret);
        map.put("redirect_uri",RedirectUrl);
        map.put("grant_type",grantType);
        return map;
    }
}
