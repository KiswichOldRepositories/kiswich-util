package top.kiswich.googleoauth.retrofit;


import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import top.kiswich.googleoauth.responseentity.GoogleToken;

import java.util.Map;


public interface GoogleRetrofit {
    /**
     * https://www.googleapis.com/oauth2/v4/token
     *
     * 根据code获取token
     *
     * map需包含以下字段
     * code
     * client_id
     * client_secret
     * redirect_uri
     * grant_type=authorization_code
     */
    @POST("/oauth2/v4/token")
    Call<GoogleToken> getToken(@QueryMap Map<String, String> map);



    /**
     * https://www.googleapis.com/oauth2/v4/token
     *
     * map需包含以下字段
     * refresh_token
     * client_id
     * client_secret
     * grant_type=refresh_token
     */
    @POST("/oauth2/v4/token")
    Call<GoogleToken> refreshToken(@QueryMap Map<String, String> map);


    /**
     *  https://accounts.google.com/o/oauth2/revoke
     *
     *  废除一个token
     *  token可以为refresh_token或access_token
     */
    @POST("/o/oauth2/revoke")
    Call<String> revokeToken(@Query("token") String token);



}
