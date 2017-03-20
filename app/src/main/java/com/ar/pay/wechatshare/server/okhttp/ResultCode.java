package com.ar.pay.wechatshare.server.okhttp;

/**
 * author：Administrator on 2017/3/10 17:17
 * company: xxxx
 * email：1032324589@qq.com
 */

public interface ResultCode<T> {
    void onSucess(T result);
    void onErro();
}
