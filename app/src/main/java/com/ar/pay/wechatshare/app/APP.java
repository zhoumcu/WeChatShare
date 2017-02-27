package com.ar.pay.wechatshare.app;

import android.app.Application;

import com.jude.beam.Beam;
import com.jude.utils.JUtils;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class APP extends Application {
    private static final String APP_ID = "3ba5e6cef24759098399d41a58d89e3d";
    private static final String TAG = APP.class.getSimpleName();
    private static APP instances;
    public IWXAPI api;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        JUtils.initialize(this);
        JUtils.setDebug(true, "JoyLog");
        Beam.init(this);
//        regToWx();
        ShareSDK.initSDK(this);
    }

    public static APP getInstances(){
        return instances;
    }
    private void regToWx(){
        api = WXAPIFactory.createWXAPI(this,APP_ID,true);
        api.registerApp(APP_ID);
    }
    private void addActivity(Class<?> c){
        List<Class> list = new ArrayList<>();
        list.add(c);
    }
}
