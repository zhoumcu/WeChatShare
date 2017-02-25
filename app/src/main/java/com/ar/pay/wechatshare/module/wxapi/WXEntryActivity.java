package com.ar.pay.wechatshare.module.wxapi;

import android.app.Activity;
import android.util.Log;

import com.ar.pay.wechatshare.app.APP;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * author：Administrator on 2017/2/25 16:25
 * company: xxxx
 * email：1032324589@qq.com
 */

public class WXEntryActivity extends Activity implements IWXAPIEventHandler{
    @Override
    public void onReq(BaseReq baseReq) {
        Log.e("WXEntryActivity","recv msg!");
        APP.getInstances().api.handleIntent(getIntent(),this);
    }

    @Override
    public void onResp(BaseResp baseResp) {

    }
}
