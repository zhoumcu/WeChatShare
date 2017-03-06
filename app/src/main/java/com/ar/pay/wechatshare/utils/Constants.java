package com.ar.pay.wechatshare.utils;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

/**
 * author：Administrator on 2017/2/22 16:10
 * company: xxxx
 * email：1032324589@qq.com
 */
public class Constants {

    public static final String IS_LOGIN = "is_login";

    public static SpannableStringBuilder setTextColor(String content){
        SpannableStringBuilder builder = new SpannableStringBuilder(content);
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.parseColor("#de6719"));
        builder.setSpan(redSpan, 3, content.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return builder;
    }
}
