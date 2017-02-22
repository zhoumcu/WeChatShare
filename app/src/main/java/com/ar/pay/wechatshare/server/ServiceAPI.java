package com.ar.pay.wechatshare.server;

import com.ar.pay.wechatshare.entity.User;
import com.ar.pay.wechatshare.entity.common.ComResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ServiceAPI {

    String BASEURL = "http://api.xiaoan360.com/";
//    String BASEURL = "http://apis.baidu.com/showapi_open_bus/";

    @GET("api/clientele/login")
    Observable<User> login(@Query("userCode") String userCode, @Query("pwd") String pwd, @Query("deviceInfo") String deviceInfo);

    @GET("api/clientele/find")
    Observable<ComResult> findPwd(@Query("type") String type, @Query("phone") String phone);

    @GET("api/clientele/find")
    Observable<User> findAccount(@Query("type") String type, @Query("phone") String phone);

    @GET("api/clientele/register")
    Observable<ComResult> register(@Query("userCode") String userCode, @Query("nickName") String nickName
            , @Query("mobile") String mobile, @Query("pwd") String pwd);

}