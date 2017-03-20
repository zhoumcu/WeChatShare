package com.ar.pay.wechatshare.entity;

import com.google.gson.Gson;

/**
 * author：Administrator on 2017/3/1 15:19
 * company: xxxx
 * email：1032324589@qq.com
 */

public class Result {

    /**
     * data : admin3
     */

    private String data;
    /**
     * code : ok
     * msg : 成功
     */

    private String code;
    private String msg;

    public static Result objectFromData(String str) {

        return new Gson().fromJson(str, Result.class);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
