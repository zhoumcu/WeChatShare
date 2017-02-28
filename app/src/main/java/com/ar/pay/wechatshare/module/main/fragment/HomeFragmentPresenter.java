package com.ar.pay.wechatshare.module.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ar.pay.wechatshare.entity.ArticleBean;
import com.ar.pay.wechatshare.entity.ContentBean;
import com.ar.pay.wechatshare.module.main.ArticlesDetail;
import com.ar.pay.wechatshare.server.DaggerServiceModelComponent;
import com.ar.pay.wechatshare.server.SchedulerTransform;
import com.ar.pay.wechatshare.server.ServiceAPI;
import com.ar.pay.wechatshare.server.okhttp.HttpHelper;
import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * author：Administrator on 2016/12/8 11:47
 * company: xxxx
 * email：1032324589@qq.com
 */
public class HomeFragmentPresenter extends BeamListFragmentPresenter<HomeFragment,ContentBean> {
    private static final String TAG = HomeFragmentPresenter.class.getSimpleName();
    @Inject
    ServiceAPI serviceAPI;

    @Override
    protected void onCreate(@NonNull HomeFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        DaggerServiceModelComponent.builder().build().inject(this);
        EventBus.getDefault().register(this);
        onRefresh();
    }

    @Override
    protected void onCreateView(@NonNull HomeFragment view) {
        super.onCreateView(view);
        getAdapter().setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getView().getActivity(),ArticlesDetail.class);
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
//        List<ArticleBean> o = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            o.add(new ArticleBean());
//        }
        Observable<List<ContentBean>> observable = Observable.just(bean.getContent());
        observable.compose(new SchedulerTransform<>())
                .unsafeSubscribe(getRefreshSubscriber());
    }
}
