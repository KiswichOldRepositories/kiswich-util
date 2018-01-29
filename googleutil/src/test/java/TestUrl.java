import org.junit.Test;
import top.kiswich.googleoauth.init.GoogleOauth2;

public class TestUrl {
    @Test
    public void testGetUrl(){
        GoogleOauth2 build = new GoogleOauth2.Builder()
                .addClientId("24581740619-6rh3elfl7mjbt2bjf8a7a9l5vd1o8g76.apps.googleusercontent.com")
                .addSecret("9i4sCqoS9yeBxhKV8DNgkUAP")
                .addRedictUri("http://localhost:8080/user/login")
                .build();
        String url = build.getURL();
        System.out.println(url);

    }
}
