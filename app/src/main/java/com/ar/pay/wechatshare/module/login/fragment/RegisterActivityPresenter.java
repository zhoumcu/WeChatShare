package com.ar.pay.wechatshare.module.login.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.ar.pay.wechatshare.entity.Result;
import com.ar.pay.wechatshare.server.DaggerServiceModelComponent;
import com.ar.pay.wechatshare.server.SchedulerTransform;
import com.ar.pay.wechatshare.server.ServiceAPI;
import com.ar.pay.wechatshare.utils.MD5Util;
import com.jude.beam.bijection.Presenter;
import com.jude.utils.JUtils;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * author：Administrator on 2016/12/12 14:17
 * company: xxxx
 * email：1032324589@qq.com
 */
public class RegisterActivityPresenter extends Presenter<RegisterActivity> {
    @Inject
    ServiceAPI serviceAPI;
    private int numcode;

    @Override
    protected void onCreate(@NonNull RegisterActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        DaggerServiceModelComponent.builder().build().inject(this);
    }

    public void sendCode() {
        if (getView().edPhone.length() != 11) {
            getView().edPhone.setError("手机号格式错误");
            return;
        }
        numcode = (int) ((Math.random() * 9 + 1) * 100000);
    }
    private void close(){
        /**隐藏软键盘**/
        View view = getView().getActivity().getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getView().getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public void register() {
        close();
        String edPhone = getView().edPhone.getText().toString();
        if (getView().edAccount.length() <3 || getView().edAccount.length() > 12) {
            getView().edAccount.setError("帐号长度不对，请输入3-12个字符");
            return;
        }
        if(!getView().edPwd.getText().toString().equals(getView().edRepwd.getText().toString())) {
            getView().edRepwd.setError("两次密码输入不对应");
            return;
        }
        if (getView().edPwd.length() < 6 || getView().edPwd.length() > 12) {
            getView().edPwd.setError("密码应为6-12位");
            return;
        }
//        if(!TextUtils.isEmpty(edPhone)){
//            if (getView().edPhone.length() != 11) {
//                getView().edPhone.setError("手机号格式错误");
//                return;
//            }
//            edPhone = null;
//        }
//        if(!String.valueOf(numcode).equals(getView().edCode.toString())){
//            JUtils.Toast("验证码不对，请重新输入");
//            return;
//        }
        serviceAPI.register(getView().edAccount.getText().toString(), MD5Util.md5Code(getView().edPwd.getText().toString()))
                .compose(new SchedulerTransform<>())
                .unsafeSubscribe(getRegisterSubscriber);
    }
    Subscriber<Result> getSendCodeSubscriber = new Subscriber<Result>() {
        @Override
        public void onCompleted() {

        }
        @Override
        public void onError(Throwable e) {
            JUtils.Toast("发送失败！");
        }
        @Override
        public void onNext(Result result) {
            JUtils.Toast("发送成功！");
        }
    };
    Subscriber<String> getRegisterSubscriber = new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }
        @Override
        public void onError(Throwable e) {
            JUtils.Toast("注册失败！"+e.getMessage());
        }
        @Override
        public void onNext(String result) {
            JUtils.Toast("注册成功！");
            getView().finish();
        }
    };
}
