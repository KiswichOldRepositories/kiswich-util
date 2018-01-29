package top.kiswich.googleoauth.standard;


import top.kiswich.googleoauth.exception.CodeErrorException;
import top.kiswich.googleoauth.responseentity.GoogleToken;

/**
 * 这个借口用于用户的操作 ， 暴露给外部。
 * 用户的操作实际上就是在指定的网页登陆后，Oauth2服务商回调你配置的redirect url,
 * 并附上code ， 因此对于服务器而言，只需要从code调出token(access||refresh)即可。
 *
 */
public interface IGoogleOauth2 {
    /**
     * 指定code ，获取access_token
     * 注意 ，code如果错误或者过期，将抛出 CodeErrorException
     * @param code oauth2服务商回调的code
     * @return 返回access_token
     * @exception CodeErrorException
     */
    public GoogleToken getAccessToken(String code) throws CodeErrorException;
}
