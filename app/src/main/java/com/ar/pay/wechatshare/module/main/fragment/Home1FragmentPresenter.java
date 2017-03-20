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
import com.ar.pay.wechatshare.server.okhttp.ResultCode;
import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * author：Administrator on 2016/12/8 11:47
 * company: xxxx
 * email：1032324589@qq.com
 */
public class Home1FragmentPresenter extends BeamListFragmentPresenter<Home1Fragment,ContentBean> {
    private static final String TAG = Home1FragmentPresenter.class.getSimpleName();
    @Inject
    ServiceAPI serviceAPI;
    public int pos;
    private int size = 10;
    private int channelId;

    @Override
    protected void onCreate(@NonNull Home1Fragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        DaggerServiceModelComponent.builder().build().inject(this);
//        EventBus.getDefault().register(this);
        channelId = getView().getArguments().getInt("channelId");
        onRefresh();
    }
    @Override
    protected void onCreateView(@NonNull Home1Fragment view) {
        super.onCreateView(view);
        getAdapter().setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getView().getActivity(),ArticlesDetail.class);
                Bundle extras = new Bundle();
                extras.putSerializable("DETAIL",(ContentBean)getAdapter().getItem(position));
                intent.putExtras(extras);
                getView().startActivity(intent);
                pos = position;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(getAdapter().getCount()>0){
            getAdapter().getItem(pos).setHits(getAdapter().getItem(pos).getHits()+1);
            getAdapter().notifyItemChanged(pos);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        HttpHelper.getInstance(new ResultCode<ArticleBean>() {
            @Override
            public void onSucess(ArticleBean bean) {
                if(bean instanceof ArticleBean){
                    ArticleBean articleBean = (ArticleBean)bean;
                    Observable<List<ContentBean>> observable = Observable.just((articleBean).getContent());
                    observable.compose(new SchedulerTransform<>())
                            .unsafeSubscribe(getRefreshSubscriber());
                }
            }
            @Override
            public void onErro() {

            }
        }).getPackage(size,channelId);
    }

//    @Override
//    public void onLoadMore() {
//        super.onLoadMore();
//        size = size*totalPages;
//        HttpHelper.getInstance().getPackage(size);
//    }
//    @Subscribe
//    public void onEvent(Object bean) {
//        if(bean instanceof ArticleBean){
//            ArticleBean articleBean = (ArticleBean)bean;
//            totalPages = articleBean.getTotalPages();
//            Observable<List<ContentBean>> observable = Observable.just((articleBean).getContent());
//            observable.compose(new SchedulerTransform<>())
//                    .unsafeSubscribe(getRefreshSubscriber());
//        }else if(bean instanceof Boolean){
//            if((Boolean)bean){
//                if(getAdapter().getCount()>0){
//                    getAdapter().getItem(pos).setShare(getAdapter().getItem(pos).getShare()+1);
//                    getAdapter().notifyItemChanged(pos);
//                }
//            }
//        }
//    }
}
