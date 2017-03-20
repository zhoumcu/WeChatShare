package com.ar.pay.wechatshare.module.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ar.pay.wechatshare.entity.Result;
import com.ar.pay.wechatshare.entity.UserBean;
import com.ar.pay.wechatshare.server.okhttp.HttpHelper;
import com.ar.pay.wechatshare.server.okhttp.RequestHandler;
import com.ar.pay.wechatshare.utils.SharedPreferences;
import com.jude.beam.bijection.Presenter;

/**
 * author：Administrator on 2016/12/13 15:10
 * company: xxxx
 * email：1032324589@qq.com
 */
public class MineFragmentPresenter extends Presenter<MineFragment> {
    private UserBean user;

    @Override
    protected void onCreate(@NonNull MineFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        UserBean userBean = SharedPreferences.getInstance().getUserInfo();
        HttpHelper.getInstance().getShareNum(userBean.getId(), new RequestHandler<Result>() {
            @Override
            public void onHandlerSucess(Result result) {
                getView().tvSharecount.setText(result.getData());
            }

            @Override
            public void onHandlerError() {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
