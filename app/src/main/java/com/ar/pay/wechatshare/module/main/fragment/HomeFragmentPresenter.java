package com.ar.pay.wechatshare.module.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ar.pay.wechatshare.server.DaggerServiceModelComponent;
import com.ar.pay.wechatshare.server.ServiceAPI;
import com.jude.beam.bijection.Presenter;

import javax.inject.Inject;

/**
 * author：Administrator on 2016/12/8 11:47
 * company: xxxx
 * email：1032324589@qq.com
 */
public class HomeFragmentPresenter extends Presenter<HomeFragment> {
    private static final String TAG = HomeFragmentPresenter.class.getSimpleName();
    @Inject
    ServiceAPI serviceAPI;

    @Override
    protected void onCreate(@NonNull HomeFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        DaggerServiceModelComponent.builder().build().inject(this);
    }

    @Override
    protected void onCreateView(@NonNull HomeFragment view) {
        super.onCreateView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
