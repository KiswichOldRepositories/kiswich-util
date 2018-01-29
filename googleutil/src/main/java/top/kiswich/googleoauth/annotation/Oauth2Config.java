package top.kiswich.googleoauth.annotation;



import top.kiswich.googleoauth.standard.auth.IGoogleOauth2Scope;

import java.lang.annotation.*;

/**
 * 注解了之后 ，该类就为配置类，用于配置以下内容（好想把配置集成到spring-boot里面 :joy:）：
 * googleClientId：google_oauth2应用的id
 * googleSecret：google_oauth2应用的secret
 * scope：token获取的权限配置
 *
 * ps: 对于如何扫描到这个注解是个问题23333
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Oauth2Config {
    String googleClientId() ;
    String googleSecret();

    /**
     * 默认为获取eamil和user_id
     * @return
     */
    String scope() default IGoogleOauth2Scope.GOOGLE_SCOPE_EMAIL;
}
