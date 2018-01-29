package top.kiswich.googleoauth.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import top.kiswich.googleoauth.responseentity.GoogleUserInf;

public interface GoogleApiRetrofit {

    /**
     *  https://www.googleapis.com/oauth2/v2/tokeninfo
     *  获取用户信息，（要求前面获得的token有这个权限）
     *  fields参数【有用的】可以包含以下参数（参数间用逗号隔开）
     *  email,user_id
     * @param accessToken
     * @return
     */
    @GET("/oauth2/v2/tokeninfo")
    Call<GoogleUserInf> getFiles(@Query("access_token") String accessToken, @Query("id_token") String idToken, @Query("fields") String fields);
}
