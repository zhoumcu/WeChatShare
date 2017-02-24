package com.ar.pay.wechatshare.module.other.vholder;

import android.view.ViewGroup;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.entity.ArticleBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/8 14:42
 * company: xxxx
 * email：1032324589@qq.com
 */
public class MineArticleViewHolder extends BaseViewHolder<ArticleBean> {


    public MineArticleViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_article);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(ArticleBean data) {
        super.setData(data);
    }
}
