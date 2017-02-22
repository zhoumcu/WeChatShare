package com.ar.pay.wechatshare.module.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.module.base.BeenFragment;
import com.jude.beam.bijection.RequiresPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/12 14:16
 * company: xxxx
 * email：1032324589@qq.com
 */
@RequiresPresenter(RegisterActivityPresenter.class)
public class RegisterActivity extends BeenFragment<RegisterActivityPresenter> {
    @BindView(R.id.ed_account)
    EditText edAccount;
    @BindView(R.id.ed_pwd)
    EditText edPwd;
    @BindView(R.id.ed_repwd)
    EditText edRepwd;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.btn_sendcode)
    TextView btnSendcode;
    @BindView(R.id.ed_code)
    EditText edCode;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView ==null)
            rootView = inflater.inflate(R.layout.aty_register, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnSendcode.setOnClickListener(view -> getPresenter().sendCode());
        btnRegister.setOnClickListener(view -> getPresenter().register());
    }

}
