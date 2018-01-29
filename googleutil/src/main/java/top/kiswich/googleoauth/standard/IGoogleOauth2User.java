package top.kiswich.googleoauth.standard;

/**
 * 对于这个接口而言，只需要从code直接获取userId(Oauth2服务商用户下的id)
 */
public interface IGoogleOauth2User extends IGoogleOauth2{
    /**
     * 高度封装，传入code，直接获取userId
     * @param code google重定向传入的code
     * @return 用户的userId
     */
    public String getUserId(String code);
}
