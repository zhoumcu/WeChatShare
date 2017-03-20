package com.ar.pay.wechatshare.server;

import com.ar.pay.wechatshare.entity.ArticleBean;
import com.ar.pay.wechatshare.entity.UserBean;
import com.ar.pay.wechatshare.entity.common.ComResult;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface ServiceAPI {

    String BASEURL = "http://139.162.126.145/";
//    String BASEURL = "http://139.162.126.145:5050/";
//    String BASEURL = "http://apis.baidu.com/showapi_open_bus/";

    @POST("api/user/login")
    Observable<UserBean> login(@Query("username") String username, @Query("password") String password);

    @GET("api/clientele/find")
    Observable<ComResult> findPwd(@Query("type") String type, @Query("phone") String phone);

    @GET("api/clientele/find")
    Observable<UserBean> findAccount(@Query("type") String type, @Query("phone") String phone);

    @POST("api/user/register")
    Observable<String> register(@Query("username") String username, @Query("password") String password);

    @GET("api/resource")
    Observable<ArticleBean> getArticle(@Query("userCode") String userCode);
}