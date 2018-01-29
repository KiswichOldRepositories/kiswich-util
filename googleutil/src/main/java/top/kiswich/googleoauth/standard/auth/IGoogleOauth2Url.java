package top.kiswich.googleoauth.standard.auth;

import top.kiswich.googleoauth.standard.api.IGoogleOauth2Field;

/**
 * 获取能访问到Oauth2的链接，
 * 这个链接用于登陆，
 * 前台请求链接，并绑定到某个dom上即可
 */
public interface IGoogleOauth2Url extends IGoogleOauthHost,IGoogleOauth2Scope ,IGoogleOauth2AccessType,IGoogleOauth2GrantType ,IGoogleOauth2Field,IGoogleOauth2ResponseType{

    /**
     * 获取到前台能够登录的url
     * 该url需要有google oauth2 的clientId，sceret，自定义的scope（获取到的token权限）
     * @return
     */
    public String getURL();
}
