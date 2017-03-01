package com.ar.pay.wechatshare.module.other;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.TextView;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.entity.UserBean;
import com.ar.pay.wechatshare.module.login.fragment.LoginActivity;
import com.ar.pay.wechatshare.utils.Constants;
import com.ar.pay.wechatshare.utils.SharedPreferences;
import com.jude.beam.expansion.BeamBaseActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author：Administrator on 2017/2/24 09:43
 * company: xxxx
 * email：1032324589@qq.com
 */
public class InfoActivity extends BeamBaseActivity {
    @BindView(R.id.tv_account)
    TextView tvAccount;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_info);
        ButterKnife.bind(this);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        UserBean userBean = SharedPreferences.getInstance().getUserInfo();
        tvAccount.setText(userBean.getUsername());
        tvName.setText(userBean.getName());
    }

    @OnClick(R.id.btn_quitAccount)
    public void onClick() {
        finish();
        SharedPreferences.getInstance().putBoolean(Constants.IS_LOGIN,false);
        EventBus.getDefault().post(new LoginActivity());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case android.R.id.home:
                // 处理返回逻辑
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
