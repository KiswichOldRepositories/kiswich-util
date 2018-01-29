package top.kiswich.googleoauth.init;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import top.kiswich.googleoauth.exception.BuildErrorException;
import top.kiswich.googleoauth.exception.CodeErrorException;
import top.kiswich.googleoauth.responseentity.GoogleToken;
import top.kiswich.googleoauth.responseentity.GoogleUserInf;
import top.kiswich.googleoauth.retrofit.GoogleApiRetrofit;
import top.kiswich.googleoauth.retrofit.GoogleRetrofit;
import top.kiswich.googleoauth.service.GoogleService;
import top.kiswich.googleoauth.standard.abstractclass.AbstractGoogleOauth2Auth;
import top.kiswich.googleoauth.standard.auth.IGoogleOauth2AccessType;
import top.kiswich.googleoauth.standard.auth.IGoogleOauth2Scope;
import top.kiswich.googleoauth.standard.IGoogleOauth2User;
import top.kiswich.googleoauth.util.StringUtil;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.HashMap;


/**
 * 保存google oauth2初始化的一些数据
 * 同时也是对外开放的唯一接口
 */
public class GoogleOauth2 extends AbstractGoogleOauth2Auth implements IGoogleOauth2User {

    private String googleClientId;
    private String googleSecret;
    //重定向uri
    private String redirectUri;
    //token所具有的权限
    private String scope;
    //token能否被刷新的问题 [online,offline]
    private String accessType;
    //重定向后的参数传递(使用jackson转义)
    private Object state;

    //保存本身(单实例)
    private static GoogleOauth2 googleOauth2;


    //对信息的操作
    public GoogleService googleService;
    //存储了登录获取的token(不能存)
    public GoogleToken googleToken;
    //初始化标志
    private boolean isInit = false;

    /**
     * 私有化无参构造器
     */
    private GoogleOauth2() {
    }

    private GoogleOauth2(String googleClientId, String googleSecret, String redirectUri, String scope, String accessType, Object state) {
        this.googleClientId = googleClientId;
        this.googleSecret = googleSecret;
        this.redirectUri = redirectUri;
        this.scope = scope;
        this.accessType = accessType;
        this.state = state;
    }

    /**
     * 返回一个build完成的实例
     *
     * @return
     */
    public static GoogleOauth2 getInstance() {
        synchronized (googleOauth2) {
            if (googleOauth2 == null) throw new BuildErrorException("please bliud the class first");
            return googleOauth2;
        }
    }

    /**
     * 高度封装，传入code，直接获取userId
     *
     * @param code google重定向传入的code
     * @return 用户的userId
     */
    @Override
    public String getUserId(String code) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GOOGLE_API_HOST)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        googleToken = getAccessToken(code);

        GoogleApiRetrofit googleApiRetrofit = retrofit.create(GoogleApiRetrofit.class);
        Call<GoogleUserInf> userInfo = googleApiRetrofit.getFiles(googleToken.getAccess_token(), googleToken.getId_token(), FIELD_USERINFO_EMAIL);
        GoogleUserInf googleUserInf = null;
        try {
            googleUserInf = userInfo.execute().body();
        } catch (IOException e) {
            throw new CodeErrorException("???ba ga na");
        }
        if (StringUtil.isBlank(googleUserInf.getUser_id())) throw new CodeErrorException("can't get user info");
        return googleUserInf.getUser_id();
    }

    /**
     * 指定code ，获取access_token
     * 注意 ，code如果错误或者过期，将抛出 CodeErrorException
     *
     * @param code oauth2服务商回调的code
     * @return 返回access_token
     * @throws CodeErrorException
     */
    @Override
    public GoogleToken getAccessToken(String code) throws CodeErrorException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GOOGLE_API_HOST)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        GoogleRetrofit googleRetrofit = retrofit.create(GoogleRetrofit.class);
        //准备参数
        HashMap<String, String> map = new HashMap<String, String>() {{
            put(S_CODE, code);
            put(S_CLIENT_ID, googleClientId);
            put(S_SECRET, googleSecret);
            put(S_REDIRECT_URI, redirectUri);
            put(S_GRANT_TYPE, GRANT_TYPE_AUTHORIZATION);
        }};
        //获取结果 access_token 和 id_token
        Call<GoogleToken> token = googleRetrofit.getToken(map);
        try {
            return token.execute().body();
        } catch (IOException e) {
            throw new CodeErrorException("error client_id or secret or code");
        }
    }

    /**
     * 获取到前台能够登录的url
     * 该url需要有google oauth2 的clientId，sceret，自定义的scope（获取到的token权限）
     *
     * @return
     */
    @Override
    public String getURL() {
        if (!isInit) throw new BuildErrorException("not init the instance");
        StringBuffer url = new StringBuffer();
        String stateJson = null;
        try {
            if (state != null) stateJson = new ObjectMapper().writeValueAsString(state);
        } catch (JsonProcessingException e) {
            throw new BuildErrorException("can't resolve state object");
        }

        url.append(ACCOUNTS_HOST).append("?")
                .append(S_SCOPE).append("=").append(URLEncoder.encode(scope)).append("&")
                .append(S_ACCESS_TYPE).append("=").append(accessType).append("&")
                .append(S_REDIRECT_URI).append("=").append(redirectUri).append("&")
                .append(S_CLIENT_ID).append("=").append(googleClientId).append("&")
                .append(S_RESPONSE_TYPE).append("=").append(RESPONSE_TYPE_CODE);
        if (state != null) url.append("&").append(S_STATE).append("=").append(URLEncoder.encode(stateJson));

        return url.toString();
    }

    /**
     * 创建google的builder
     */
    public static final class Builder {

        private static String googleClientId;
        private static String googleSecret;
        private static String redirectUri;
        private static String scope = GOOGLE_SCOPE_EMAIL;
        private static String accessType = TYPE_OFFLINE;
        private static Object state;


        /**
         * 默认构造器
         */
        public Builder() {
        }

        /**
         * 传入应用id
         *
         * @param clientId
         * @return
         */
        public Builder addClientId(String clientId) {
            if (StringUtil.isBlank(clientId)) throw new BuildErrorException("clientId not been null or empty");
            googleClientId = clientId;
            return this;
        }

        /**
         * 传入应用密码
         *
         * @param secret
         * @return
         */
        public Builder addSecret(String secret) {
            if (StringUtil.isBlank(secret)) throw new BuildErrorException("secret not been null or empty");
            googleSecret = secret;
            return this;
        }

        /**
         * 传入重定向uri
         *
         * @param uri
         * @return
         */
        public Builder addRedictUri(String uri) {
            if (StringUtil.isBlank(uri)) throw new BuildErrorException("uri not been null or empty");
            redirectUri = uri;
            return this;
        }

        /**
         * 传入作用域
         *
         * @param scope
         * @return
         */
        public Builder addscope(String scope) {
            //保证传入的scope必须是合法的
            for (Field field : IGoogleOauth2Scope.class.getFields()) {
                try {
                    if (scope.equals(field.get(null))) {

                        Builder.scope = scope;
                        return this;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            throw new BuildErrorException("no scope matched");
        }

        /**
         * 传入access_type
         */
        public Builder addAccessType(String accessType) {
            //保证传入的accessType必须是合法的
            for (Field field : IGoogleOauth2AccessType.class.getFields()) {
                try {
                    if (accessType.equals(field.get(null))) {
                        Builder.accessType = accessType;
                        return this;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            throw new BuildErrorException("no accessType matched");
        }

        /**
         * 传入state
         */
        public Builder addState(Object state) {
            if (state != null) Builder.state = state;
            return this;
        }

        /**
         * 构造
         */
        public GoogleOauth2 build() {
            //创建对象时必须保证已经注入id和secret
            if (googleClientId == null || googleSecret == null) {
                throw new BuildErrorException();
            }
            GoogleOauth2.googleOauth2 = new GoogleOauth2(googleClientId, googleSecret, redirectUri, scope, accessType, state);
            googleOauth2.isInit = true;
            return GoogleOauth2.googleOauth2;
        }
    }
}
