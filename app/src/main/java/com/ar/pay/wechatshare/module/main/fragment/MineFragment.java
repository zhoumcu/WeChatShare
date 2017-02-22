package com.ar.pay.wechatshare.module.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ar.pay.wechatshare.R;
import com.jude.beam.bijection.BeamFragment;
import com.jude.beam.bijection.RequiresPresenter;

import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/8 11:44
 * company: xxxx
 * email：1032324589@qq.com
 */
@RequiresPresenter(MineFragmentPresenter.class)
public class MineFragment extends BeamFragment<MineFragmentPresenter> {


    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView ==null)
            rootView = inflater.inflate(R.layout.frg_mine, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
