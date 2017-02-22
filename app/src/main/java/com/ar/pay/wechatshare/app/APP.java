package com.ar.pay.wechatshare.app;

import android.app.Application;

import com.jude.beam.Beam;
import com.jude.utils.JUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class APP extends Application {

    private static final String TAG = APP.class.getSimpleName();
    private static APP instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        JUtils.initialize(this);
        JUtils.setDebug(true, "JoyLog");
        Beam.init(this);
    }

    public static APP getInstances(){
        return instances;
    }

    private void addActivity(Class<?> c){
        List<Class> list = new ArrayList<>();
        list.add(c);
    }
}
