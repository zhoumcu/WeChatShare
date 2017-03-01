package com.ar.pay.wechatshare.module.login.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.ar.pay.wechatshare.entity.UserBean;
import com.ar.pay.wechatshare.module.main.fragment.MineFragment;
import com.ar.pay.wechatshare.server.DaggerServiceModelComponent;
import com.ar.pay.wechatshare.server.SchedulerTransform;
import com.ar.pay.wechatshare.server.ServiceAPI;
import com.ar.pay.wechatshare.utils.Constants;
import com.ar.pay.wechatshare.utils.MD5Util;
import com.ar.pay.wechatshare.utils.SharedPreferences;
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
    private void close(){
        /**隐藏软键盘**/
        View view = getView().getActivity().getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getView().getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public void login() {
        close();
        phone = getView().phone.getText().toString();
        String mPassword = getView().tvPwd.getText().toString();
//        if (phone.length() != 11) {
//            getView().phone.setError("手机号格式错误");
//            return;
//        }
        if (phone.length() <= 0) {
            getView().phone.setError("手机号格式错误");
            return;
        }
        if (mPassword.length() < 4 || mPassword.length() > 12) {
            getView().tvPwd.setError("密码应为6-12位");
            return;
        }
        serviceAPI.login(phone, MD5Util.md5Code(mPassword))
                .compose(new SchedulerTransform<>())
                .unsafeSubscribe(getLoginSubscriber);

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
            Log.e("test",e.toString());
            JUtils.Toast("登录失败，请重试！"+e.toString());
        }
        @Override
        public void onNext(UserBean user) {
            JUtils.Toast("登录成功！");
            SharedPreferences.getInstance().putBoolean(Constants.IS_LOGIN,true);
            SharedPreferences.getInstance().saveUserInfo(user);
            EventBus.getDefault().post(true);
            EventBus.getDefault().post(new MineFragment());
        }
    };

}

