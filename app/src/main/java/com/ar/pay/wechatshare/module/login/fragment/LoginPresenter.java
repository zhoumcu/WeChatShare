package com.ar.pay.wechatshare.module.login.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ar.pay.wechatshare.entity.User;
import com.ar.pay.wechatshare.module.main.fragment.MineFragment;
import com.ar.pay.wechatshare.server.DaggerServiceModelComponent;
import com.ar.pay.wechatshare.server.ServiceAPI;
import com.jude.beam.bijection.Presenter;
import com.jude.utils.JUtils;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * author：Administrator on 2016/10/28 09:03
 * company: xxxx
 * email：1032324589@qq.com
 */

public class LoginPresenter extends Presenter<LoginActivity> {

    @Inject
    ServiceAPI serviceAPI;
    private String phone;

    @Override
    protected void onCreate(@NonNull LoginActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        DaggerServiceModelComponent.builder().build().inject(this);
    }

    public void login() {
        phone = getView().phone.getText().toString();
        String mPassword = getView().tvPwd.getText().toString();
        if (phone.length() != 11) {
            getView().phone.setError("手机号格式错误");
            return;
        }
        if (mPassword.length() < 6 || mPassword.length() > 12) {
            getView().tvPwd.setError("密码应为6-12位");
            return;
        }
//        serviceAPI.login(phone,mPassword,null)
//                .compose(new SchedulerTransform<>())
//                .unsafeSubscribe(getLoginSubscriber);
        JUtils.Toast("登录成功！");
        getView().changeFragment.onChangeFragment(new MineFragment());
    }
    public void findPwd() {
        getView().changeFragment.onChangeFragment(new FindPwdActivity());
    }
    public void findCount() {
        getView().changeFragment.onChangeFragment(new FindAccountActivity());
    }
    public void register() {
        getView().changeFragment.onChangeFragment(new RegisterActivity());
    }

    Subscriber<User> getLoginSubscriber = new Subscriber<User>() {

        @Override
        public void onCompleted() {

        }
        @Override
        public void onError(Throwable e) {

        }
        @Override
        public void onNext(User user) {

        }
    };

}

