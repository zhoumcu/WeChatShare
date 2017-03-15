package com.ar.pay.wechatshare.app;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.jude.beam.Beam;
import com.jude.utils.JUtils;
import com.pgyersdk.crash.PgyCrashManager;
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
        PgyCrashManager.register(this);
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
    public  String getVersionName() {
        // 获取packagemanager的实例
        PackageManager packageManager = getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(getPackageName(),0);
            String version = packInfo.versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
