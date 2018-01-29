package top.kiswich.googleoauth.service;



/**
 * 各类service的实现，是个bean
 */

public class GoogleService {

    /**
     * 根据code获取token ! hury !! hury !!!
     */

    public String getToken(String code){
        return  "go in getToken";
    }


    /**
     * 根据access_token和id_token 获取user_id 和 user_email
     */

    public void getUserId(){

    }


    /**
     *  废除某一个refresh_token
     */

    public void revokeToken(){

    }




}
