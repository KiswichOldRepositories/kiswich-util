package top.kiswich.googleoauth.standard.auth;

/**
 * 用于访问google oauth2的固定host
 */
public interface IGoogleOauthHost {

    /**
     * 用于验证登录的地址
     */
    public String ACCOUNTS_HOST="https://accounts.google.com/o/oauth2/v2/auth";

    /**
     * 调用google api的地址
     */
    public String GOOGLE_API_HOST = "https://www.googleapis.com";
}
