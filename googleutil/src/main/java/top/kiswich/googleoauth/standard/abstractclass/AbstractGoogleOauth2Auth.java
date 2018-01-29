package top.kiswich.googleoauth.standard.abstractclass;

import top.kiswich.googleoauth.standard.auth.IGoogleOauth2Url;

/**
 * 简单的添加一些功能
 * 如 生成URL所需要的字符串常量、
 */
public abstract class AbstractGoogleOauth2Auth implements IGoogleOauth2Url {
    /**
     * Required
     * 应用的Client Id
     */
    protected final static String S_CLIENT_ID = "client_id";
    /**
     * Required
     * response type,一般为code
     */
    protected final  static  String S_RESPONSE_TYPE = "response_type";

    /**
     *
     */
    protected final static String S_SECRET = "client_secret";
    /**
     * Required
     * 应用的跳转uri
     */
    protected final static String S_REDIRECT_URI = "redirect_uri";

    /**
     * Required
     * 应用会用到的权限，也就是token的权限
     */
    protected final static String S_SCOPE = "scope";

    /**
     * Recommended
     * 决定是否能刷新access_token ， 默认为online(不能刷新)；一般用作offline（可以刷新），
     */
    protected final static String S_ACCESS_TYPE = "access_type";

    /**
     * Recommended
     * 需要传递的自定义参数
     */
    protected final static String S_STATE = "state";

    /**
     * Optional
     * 详见google doc :joy:
     */
    protected final static String S_INCLUDE_GRANTED_SCOPES = "include_granted_scopes";

    /**
     * Optional
     * 详见google doc :joy:
     */
    protected final static String S_LOGIN_HINT = "login_hint";

    /**
     * Optional
     * 详见google doc :joy:
     */
    protected final static String S_PROMPT = "prompt";

    /**
     * code
     */
    protected final static String S_CODE = "code";

    /**
     * grant_type
     */
    protected  final static String S_GRANT_TYPE = "grant_type";

}
