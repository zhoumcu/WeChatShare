package com.ar.pay.wechatshare.module.other;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ar.pay.wechatshare.entity.ArticleBean;
import com.ar.pay.wechatshare.entity.ContentBean;
import com.ar.pay.wechatshare.entity.UserBean;
import com.ar.pay.wechatshare.module.main.ArticlesDetail;
import com.ar.pay.wechatshare.server.SchedulerTransform;
import com.ar.pay.wechatshare.server.okhttp.HttpHelper;
import com.ar.pay.wechatshare.utils.SharedPreferences;
import com.jude.beam.expansion.list.BeamListActivityPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * author：Administrator on 2017/2/24 09:49
 * company: xxxx
 * email：1032324589@qq.com
 */
public class MineSharePresenter extends BeamListActivityPresenter<MineShareActivity,ContentBean>{

    @Override
    protected void onCreate(@NonNull MineShareActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        EventBus.getDefault().register(this);
        onRefresh();
    }
    @Override
    protected void onCreateView(@NonNull MineShareActivity view) {
        super.onCreateView(view);
        getAdapter().setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getView(),ArticlesDetail.class);
                Bundle extras = new Bundle();
                extras.putSerializable("DETAIL",(ContentBean)getAdapter().getItem(position));
                intent.putExtras(extras);
                getView().startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Override
    public void onRefresh() {
        super.onRefresh();
        HttpHelper.getInstance().getPackage(10);
    }
    @Subscribe
    public void onEventMainThread(ArticleBean bean) {

        Observable<List<ContentBean>> observable = Observable.just(fillter(bean));
        observable.compose(new SchedulerTransform<>())
                .unsafeSubscribe(getRefreshSubscriber());
    }

    private List<ContentBean> fillter(ArticleBean bean){
        List<ContentBean> ls = new ArrayList<>();
        UserBean userBean = SharedPreferences.getInstance().getUserInfo();
        for (ContentBean contentBean: bean.getContent()){
            if(contentBean.getUser().getName().equals(userBean.getUsername())){
                ls.add(contentBean);
            }
        }
        return ls;
    }
}
