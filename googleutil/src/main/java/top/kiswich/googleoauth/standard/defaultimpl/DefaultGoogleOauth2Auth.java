package top.kiswich.googleoauth.standard.defaultimpl;

import top.kiswich.googleoauth.standard.abstractclass.AbstractGoogleOauth2Auth;

/**
 * 用于生成url的默认实现，
 */
public class DefaultGoogleOauth2Auth extends AbstractGoogleOauth2Auth {
    /**
     * 获取到前台能够登录的url
     * 该url需要有google oauth2 的clientId，sceret，自定义的scope（获取到的token权限）
     *
     * @return
     */
    @Override
    public String getURL() {
        return null;
    }
}
