package com.ar.pay.wechatshare.server;

import com.ar.pay.wechatshare.module.login.fragment.FindAccountPresenter;
import com.ar.pay.wechatshare.module.login.fragment.FindPwdPresenter;
import com.ar.pay.wechatshare.module.login.fragment.LoginPresenter;
import com.ar.pay.wechatshare.module.login.fragment.RegisterActivityPresenter;
import com.ar.pay.wechatshare.module.main.fragment.HomeFragmentPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhuchenxi on 16/1/25.
 */
@Singleton
@Component(modules = {ServiceAPIModule.class})
public interface ServiceModelComponent {

    void inject(LoginPresenter loginPresenter);

    void inject(HomeFragmentPresenter homeFragmentPresenter);

    void inject(RegisterActivityPresenter registerActivityPresenter);

    void inject(FindPwdPresenter findPwdPresenter);

    void inject(FindAccountPresenter findAccountPresenter);

}