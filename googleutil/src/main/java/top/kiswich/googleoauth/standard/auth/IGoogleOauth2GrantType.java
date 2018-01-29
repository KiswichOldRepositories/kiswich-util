package top.kiswich.googleoauth.standard.auth;

/**
 * 定义常量的一个接口
 * 关于获取token时的grant_type的值，一般是固定的authorization_code
 */
public interface IGoogleOauth2GrantType {
    /**
     * 既然用了oauth2 ，那就是这个值
     */
    public String GRANT_TYPE_AUTHORIZATION = "authorization_code";
}
