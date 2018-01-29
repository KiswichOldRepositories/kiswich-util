package top.kiswich.googleoauth.responseentity;

public class GoogleToken {
    //令牌token
    private String access_token;
    //token的剩余时间
    private String expires_in;
    //这个值一般为 bearer
    private String token_type;
    //刷新token的token
    private String refresh_token;
    //
    private String id_token;

    public GoogleToken() {
    }

    public GoogleToken(String access_token, String expires_in, String token_type, String refresh_token) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.token_type = token_type;
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }
}
