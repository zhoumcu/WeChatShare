package com.ar.pay.wechatshare.module.other;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.ar.pay.wechatshare.entity.ArticleBean;
import com.ar.pay.wechatshare.module.other.vholder.MineArticleViewHolder;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListActivity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * author：Administrator on 2017/2/24 09:44
 * company: xxxx
 * email：1032324589@qq.com
 */
@RequiresPresenter(MineArticlePresenter.class)
public class MineArticlesActivity extends BeamListActivity<MineArticlePresenter,ArticleBean>{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new MineArticleViewHolder(parent);
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
