package com.ar.pay.wechatshare.module.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
@RequiresPresenter(FindPwdPresenter.class)
public class FindPwdActivity extends BeenFragment<FindPwdPresenter> {

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.btn_sendcode)
    TextView btnSendcode;
    @BindView(R.id.tv_code)
    EditText tvCode;
    @BindView(R.id.btnSummit)
    Button btnSummit;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.btnClose)
    Button btnClose;
    @BindView(R.id.tv_load)
    TextView tvLoad;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null)
            rootView = inflater.inflate(R.layout.aty_findpwd, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnSendcode.setOnClickListener(view -> getPresenter().sendCode());
        btnSummit.setOnClickListener(view -> getPresenter().findPwd());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

}
