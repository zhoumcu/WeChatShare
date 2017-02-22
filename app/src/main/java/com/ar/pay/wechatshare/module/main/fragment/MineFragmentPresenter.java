package com.ar.pay.wechatshare.module.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ar.pay.wechatshare.entity.User;
import com.jude.beam.bijection.Presenter;

/**
 * author：Administrator on 2016/12/13 15:10
 * company: xxxx
 * email：1032324589@qq.com
 */
public class MineFragmentPresenter extends Presenter<MineFragment> {
    private User user;

    @Override
    protected void onCreate(@NonNull MineFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
