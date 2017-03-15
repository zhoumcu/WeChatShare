package com.ar.pay.wechatshare.module.main.fragment;

import android.view.ViewGroup;

import com.ar.pay.wechatshare.entity.ContentBean;
import com.ar.pay.wechatshare.module.main.vholder.ArticleViewHolder;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * author：Administrator on 2016/12/8 11:39
 * company: xxxx
 * email：1032324589@qq.com
 */
@RequiresPresenter(Home1FragmentPresenter.class)
public class Home1Fragment extends BeamListFragment<Home1FragmentPresenter,ContentBean> {

    @Override
    public BaseViewHolder<ContentBean> getViewHolder(ViewGroup parent, int viewType) {
        return new ArticleViewHolder(parent);
    }

    @Override
    public ListConfig getConfig() {
        return super.getConfig()
                .setLoadmoreAble(false)
                .setRefreshAble(true)
                .setNoMoreAble(true)
                .setErrorAble(true)
                .setErrorTouchToResumeAble(true);
    }
}
