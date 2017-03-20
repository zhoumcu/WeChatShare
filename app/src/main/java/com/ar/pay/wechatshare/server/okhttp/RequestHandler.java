package com.ar.pay.wechatshare.server.okhttp;

import android.os.Handler;
import android.os.Message;

/**
 * author：Administrator on 2017/3/20 09:11
 * company: xxxx
 * email：1032324589@qq.com
 */

public abstract class RequestHandler<T> implements ResultCode<T>{
    public abstract void onHandlerSucess(T result);
    public abstract void onHandlerError();
    private static final int SUCESS = 0;
    private static final int ERROR = 1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case SUCESS:
                    onHandlerSucess((T)msg.obj);
                    break;
                case ERROR:
                    onHandlerError();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onSucess(T result) {
        Message msg = new Message();
        msg.what = SUCESS;
        msg.obj = result;
        handler.sendMessage(msg);
    }

    @Override
    public void onErro() {
        Message msg = new Message();
        msg.what = ERROR;
        handler.sendMessage(msg);
    }
}
