package com.ar.pay.wechatshare.module.other;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ar.pay.wechatshare.entity.ShareBean;
import com.ar.pay.wechatshare.entity.UserBean;
import com.ar.pay.wechatshare.server.SchedulerTransform;
import com.ar.pay.wechatshare.server.okhttp.HttpHelper;
import com.ar.pay.wechatshare.utils.SharedPreferences;
import com.jude.beam.expansion.list.BeamListActivityPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import rx.Observable;

/**
 * author：Administrator on 2017/2/24 09:49
 * company: xxxx
 * email：1032324589@qq.com
 */
public class MineSharePresenter extends BeamListActivityPresenter<MineShareActivity,ShareBean.DataEntity>{

    private UserBean userBean;

    @Override
    protected void onCreate(@NonNull MineShareActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        EventBus.getDefault().register(this);
        userBean = SharedPreferences.getInstance().getUserInfo();
        onRefresh();
    }
    @Override
    protected void onCreateView(@NonNull MineShareActivity view) {
        super.onCreateView(view);
//        getAdapter().setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                Intent intent = new Intent(getView(),ArticlesDetail.class);
//                Bundle extras = new Bundle();
//                extras.putSerializable("DETAIL", (Serializable) getAdapter().getItem(position));
//                intent.putExtras(extras);
//                getView().startActivity(intent);
//            }
//        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Override
    public void onRefresh() {
        super.onRefresh();
        HttpHelper.getInstance().getMyShare(10,userBean.getId());
    }
    @Subscribe
    public void onEventMainThread(ShareBean bean) {
        Observable<List<ShareBean.DataEntity>> observable = Observable.just(bean.getData());
        observable.compose(new SchedulerTransform<>())
                .unsafeSubscribe(getRefreshSubscriber());
    }

}
