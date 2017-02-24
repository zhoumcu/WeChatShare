package com.ar.pay.wechatshare.module.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.module.base.BeenFragment;
import com.ar.pay.wechatshare.module.other.InfoActivity;
import com.ar.pay.wechatshare.module.other.MineArticlesActivity;
import com.ar.pay.wechatshare.widget.CustomTitleBar;
import com.jude.beam.bijection.RequiresPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author：Administrator on 2016/12/8 11:44
 * company: xxxx
 * email：1032324589@qq.com
 */
@RequiresPresenter(MineFragmentPresenter.class)
public class MineFragment extends BeenFragment<MineFragmentPresenter> {


    @BindView(R.id.titleBar)
    CustomTitleBar titleBar;
    @BindView(R.id.btn_info)
    TextView btnInfo;
    @BindView(R.id.btn_minearticle)
    TextView btnMinearticle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frg_mine, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick({R.id.btn_info, R.id.btn_minearticle})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_info:
                startActivity(new Intent(getContext(),InfoActivity.class));
                break;
            case R.id.btn_minearticle:
                startActivity(new Intent(getContext(),MineArticlesActivity.class));
                break;
        }
    }
}
