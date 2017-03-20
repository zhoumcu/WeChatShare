package com.ar.pay.wechatshare.server.okhttp;

import android.util.Log;

import com.ar.pay.wechatshare.entity.ArticleBean;
import com.ar.pay.wechatshare.entity.Result;
import com.ar.pay.wechatshare.entity.ShareBean;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author：Administrator on 2017/2/28 15:05
 * company: xxxx
 * email：1032324589@qq.com
 */
public class HttpHelper {
//    public static String BaseURL = "http://139.162.126.145:5050/";
    public static String BaseURL = "http://139.162.126.145/";

    private static HttpHelper ourInstance = new HttpHelper();
    private ResultCode resultCode;

    public static HttpHelper getInstance(ResultCode resultCode) {
        return new HttpHelper(resultCode);
    }
    public static HttpHelper getInstance() {
        return ourInstance;
    }
    private HttpHelper(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
    private HttpHelper() {

    }
    public void getPackage(int pazeSize,int channelId) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(BaseURL+"api/resource/v2/"+pazeSize+"/"+channelId).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("获取apk列表失败");
                Log.d("GetApkPackage", e.getMessage());
                if(resultCode!=null)
                    resultCode.onErro();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String result = response.body().string();
                    System.out.println(result);
                    Gson gson = new Gson();
                    ArticleBean packlist = gson.fromJson(result,ArticleBean.class);
                    EventBus.getDefault().post(packlist);
                    if(resultCode!=null)
                        resultCode.onSucess(packlist);
                }
            }
        });
    }
    public void getMyShare(int pazeSize,int userId) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        String url = BaseURL+"api/resource/user/share/"+userId+"/"+pazeSize;
        Log.d("GetApkPackage", url);
        final Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("获取apk列表失败");
                Log.d("GetApkPackage", e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    StringBuffer stringBuffer = new StringBuffer();
                    String result = response.body().string();
                    System.out.println(result);
                    stringBuffer.append("{data:");
                    stringBuffer.append(result);
                    stringBuffer.append("}");
                    Gson gson = new Gson();
                    ShareBean packlist = gson.fromJson(stringBuffer.toString(),ShareBean.class);
                    EventBus.getDefault().post(packlist);
                }
            }
        });
    }
    public void postShare(int id,int userId) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        String url = BaseURL+"api/resource/share/"+id+"/"+userId;
        final Request request = new Request.Builder().url(url).build();
        Log.d("GetApkPackage", url);
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("获取apk列表失败");
                Log.d("GetApkPackage", e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String result = response.body().string();
                    System.out.println(result);
                }
            }
        });
    }
    public void postInfo(int id) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(BaseURL+"api/resource/info/"+id).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("获取apk列表失败");
                Log.d("GetApkPackage", e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String result = response.body().string();
                    System.out.println(result);
                }
            }
        });
    }
    public void get(int id) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(BaseURL+"api/resource/info/"+id).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("获取apk列表失败");
                Log.d("GetApkPackage", e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String result = response.body().string();
                    System.out.println(result);
                }
            }
        });
    }
    public void getShareNum(int id,ResultCode resultCode) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(BaseURL+"api/user/share/"+id).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("获取apk列表失败");
                Log.d("GetApkPackage", e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String result = response.body().string();
                    System.out.println(result);
                    resultCode.onSucess(Result.objectFromData(result));
                }
            }
        });
    }
    public void getChannel(ResultCode resultCode) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(BaseURL+"/api/resource/channel").build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("获取apk列表失败");
                Log.d("GetApkPackage", e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String result = response.body().string();
                    System.out.println(result);
                    resultCode.onSucess(Result.objectFromData(result));
                }
            }
        });
    }
}
