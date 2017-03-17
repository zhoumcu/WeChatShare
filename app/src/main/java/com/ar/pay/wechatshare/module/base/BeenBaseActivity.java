package com.ar.pay.wechatshare.module.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;

import com.ar.pay.wechatshare.R;
import com.jude.beam.bijection.Presenter;
import com.jude.beam.expansion.BeamBaseActivity;


/**
 * author：Administrator on 2017/2/18 16:12
 * company: xxxx
 * email：1032324589@qq.com
 */

public abstract class BeenBaseActivity<T extends Presenter> extends BeamBaseActivity<T> {
    private ViewStub importPanel;
    private ProgressBar loadPressBar;
    public abstract int onCreateView();
    public abstract void onDelayCreate(ViewStub viewStub);

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if(msg.what==0x123) {
                loadPressBar.setVisibility(View.GONE);
                onDelayCreate(importPanel);
            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onCreateView());
        importPanel  = ((ViewStub) findViewById(R.id.viewStub));
        loadPressBar  = ((ProgressBar) findViewById(R.id.load_progress));
        Message msg = new Message();
        msg.what=0x123;
        handler.sendMessageDelayed(msg,1);
    }
}
