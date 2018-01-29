package top.kiswich.googleoauth.standard.auth;

/**
 * 定义常量的一个接口
 * 两种方式 online 和 offline
 */
public interface IGoogleOauth2AccessType {
    /**
     * 表示access_token 不能被刷新
     */
    public String TYPE_ONLINE = "online";
    /**
     * 表示access_token 可以被刷新
     */
    public String TYPE_OFFLINE = "offline";
}
