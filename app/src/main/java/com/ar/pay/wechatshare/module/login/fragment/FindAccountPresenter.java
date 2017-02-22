package com.ar.pay.wechatshare.module.login.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.ar.pay.wechatshare.entity.common.ComResult;
import com.ar.pay.wechatshare.server.DaggerServiceModelComponent;
import com.ar.pay.wechatshare.server.SchedulerTransform;
import com.ar.pay.wechatshare.server.ServiceAPI;
import com.ar.pay.wechatshare.server.param.OBDPARAM;
import com.jude.beam.bijection.Presenter;
import com.jude.utils.JUtils;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * author：Administrator on 2016/10/28 09:03
 * company: xxxx
 * email：1032324589@qq.com
 */
public class FindAccountPresenter extends Presenter<FindAccountActivity> {
    @Inject
    ServiceAPI serviceAPI;

    @Override
    protected void onCreate(@NonNull FindAccountActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        DaggerServiceModelComponent.builder().build().inject(this);
    }


    public void sendCode(){
        String phone = getView().phone.getText().toString();
        if(TextUtils.isEmpty(phone)) return;
    }

    public void findAccount() {
        String phone = getView().phone.getText().toString();
        String code = getView().tvCode.getText().toString();
        if(TextUtils.isEmpty(phone)||TextUtils.isEmpty(code)) return;
        if(!code.equals("452364")) return;
        serviceAPI.findPwd(OBDPARAM.pwd,phone)
                .compose(new SchedulerTransform<>())
                .unsafeSubscribe(getFindPwdSubscriber);
    }
    Subscriber<ComResult> getFindPwdSubscriber = new Subscriber<ComResult>() {
        @Override
        public void onCompleted() {

        }
        @Override
        public void onError(Throwable e) {
            JUtils.Toast("修改失败！"+e.getMessage());
        }
        @Override
        public void onNext(ComResult result) {
            JUtils.Toast("修改成功！");
        }
    };
    Subscriber<ComResult> getSendCodeSubscriber = new Subscriber<ComResult>() {
        @Override
        public void onCompleted() {

        }
        @Override
        public void onError(Throwable e) {
            JUtils.Toast("发送失败！"+e.getMessage());
        }
        @Override
        public void onNext(ComResult result) {
            JUtils.Toast("发送成功！");
        }
    };
}
