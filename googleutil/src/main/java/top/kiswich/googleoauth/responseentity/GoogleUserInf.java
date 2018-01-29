package top.kiswich.googleoauth.responseentity;

/**
 * 根据token调用获得的用户信息
 */
public class GoogleUserInf {
    //google用户ID(唯一)
    private String user_id;
    //google用户email(唯一)
    private String email;

    public GoogleUserInf() {
    }

    public GoogleUserInf(String user_id, String email) {
        this.user_id = user_id;
        this.email = email;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "GoogleUserInf{" +
                "user_id='" + user_id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
