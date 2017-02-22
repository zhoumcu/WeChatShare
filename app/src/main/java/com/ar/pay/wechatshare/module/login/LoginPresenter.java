package com.ar.pay.wechatshare.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ar.pay.wechatshare.entity.User;
import com.ar.pay.wechatshare.server.SchedulerTransform;
import com.ar.pay.wechatshare.server.ServiceAPI;
import com.jude.beam.bijection.Presenter;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * author：Administrator on 2016/10/28 09:03
 * company: xxxx
 * email：1032324589@qq.com
 */
@Deprecated
public class LoginPresenter extends Presenter<LoginActivity> {

    @Inject
    ServiceAPI serviceAPI;
    private String phone;

    @Override
    protected void onCreate(@NonNull LoginActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
//        DaggerServiceModelComponent.builder().build().inject(this);
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
        serviceAPI.login(phone,mPassword,null)
                .compose(new SchedulerTransform<>())
                .unsafeSubscribe(getLoginSubscriber);

    }
    public void findPwd() {
        this.getView().startActivity(new Intent(this.getView(), FindPwdActivity.class));
    }
    public void findCount() {
        this.getView().startActivity(new Intent(this.getView(), FindAccountActivity.class));
    }
    public void register() {
        this.getView().startActivity(new Intent(this.getView(), RegisterActivity.class));
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

