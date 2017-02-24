package com.ar.pay.wechatshare.module.other;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ar.pay.wechatshare.entity.ArticleBean;
import com.jude.beam.expansion.list.BeamListActivityPresenter;

/**
 * author：Administrator on 2017/2/24 09:49
 * company: xxxx
 * email：1032324589@qq.com
 */
public class MineArticlePresenter extends BeamListActivityPresenter<MineArticlesActivity,ArticleBean>{
    @Override
    protected void onCreate(@NonNull MineArticlesActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
    }
}
