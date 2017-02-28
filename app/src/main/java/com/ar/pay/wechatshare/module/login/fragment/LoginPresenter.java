package com.ar.pay.wechatshare.module.login.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ar.pay.wechatshare.entity.UserBean;
import com.ar.pay.wechatshare.module.main.fragment.MineFragment;
import com.ar.pay.wechatshare.server.DaggerServiceModelComponent;
import com.ar.pay.wechatshare.server.ServiceAPI;
import com.jude.beam.bijection.Presenter;
import com.jude.utils.JUtils;

import org.greenrobot.eventbus.EventBus;

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
        EventBus.getDefault().post(new MineFragment());
    }
    public void findPwd() {
        EventBus.getDefault().post(new FindPwdActivity());
    }
    public void findCount() {
        EventBus.getDefault().post(new FindAccountActivity());
    }
    public void register() {
        EventBus.getDefault().post(new RegisterActivity());
    }

    Subscriber<UserBean> getLoginSubscriber = new Subscriber<UserBean>() {

        @Override
        public void onCompleted() {

        }
        @Override
        public void onError(Throwable e) {

        }
        @Override
        public void onNext(UserBean user) {

        }
    };

}

