package top.kiswich.googleoauth.standard.auth;

/**
 * 定义了常用的scope，用于生成url链接，
 * scope：即获取的的token所具有的的权限
 * 注意：添加到URl时需要urlEncode转换编码（utf-8）
 */
public interface IGoogleOauth2Scope {
    /**
     * 用于获取email_address,同时也可以获取到user_id
     */
    public String GOOGLE_SCOPE_EMAIL  = "https://www.googleapis.com/auth/userinfo.email";

}
