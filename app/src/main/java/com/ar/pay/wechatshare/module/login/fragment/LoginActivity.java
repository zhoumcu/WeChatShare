package com.ar.pay.wechatshare.module.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.module.base.BeenFragment;
import com.jude.beam.bijection.RequiresPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/10/28 08:56
 * company: xxxx
 * email：1032324589@qq.com
 */
@RequiresPresenter(LoginPresenter.class)
public class LoginActivity extends BeenFragment<LoginPresenter> {

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.imgCancel)
    ImageView imgCancel;
    @BindView(R.id.tv_find)
    TextView tvFind;
    @BindView(R.id.layoutPhone)
    RelativeLayout layoutPhone;
    @BindView(R.id.btn_pwd)
    TextView btnPwd;
    @BindView(R.id.tv_pwd)
    EditText tvPwd;
    @BindView(R.id.rl_1)
    RelativeLayout rl1;
    @BindView(R.id.btnSure)
    Button btnSure;
    @BindView(R.id.btnClose)
    Button btnClose;
    @BindView(R.id.tv_load)
    TextView tvLoad;
    @BindView(R.id.btnRegister)
    LinearLayout btnRegister;
    private View rootView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //测试数据
//        phone.setText("18279562014");
//        tvPwd.setText("123456");
//        phone.setText("admin1");
//        tvPwd.setText("admin1");
        btnSure.setOnClickListener(view -> getPresenter().login());
        tvFind.setOnClickListener(view -> getPresenter().findCount());
        btnPwd.setOnClickListener(view -> getPresenter().findPwd());
        btnRegister.setOnClickListener(view -> getPresenter().register());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView ==null)
            rootView = inflater.inflate(R.layout.aty_login, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
