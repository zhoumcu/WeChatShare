package com.ar.pay.wechatshare.module.main.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.app.APP;
import com.ar.pay.wechatshare.module.base.BeenFragment;
import com.ar.pay.wechatshare.module.other.InfoActivity;
import com.ar.pay.wechatshare.module.other.MineArticlesActivity;
import com.ar.pay.wechatshare.module.other.MineShareActivity;
import com.ar.pay.wechatshare.widget.CustomTitleBar;
import com.jude.beam.bijection.RequiresPresenter;
import com.pgyersdk.javabean.AppBean;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;

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
    @BindView(R.id.btn_update)
    TextView btnUpdate;
    @BindView(R.id.tv_sharecount)
    TextView tvSharecount;

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
        btnUpdate.setText("版本更新                           V" + APP.getInstances().getVersionName());
    }

    @OnClick({R.id.btn_info, R.id.btn_minearticle, R.id.btn_mineashare, R.id.btn_update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_info:
                startActivity(new Intent(getContext(), InfoActivity.class));
                break;
            case R.id.btn_minearticle:
                startActivity(new Intent(getContext(), MineArticlesActivity.class));
                break;
            case R.id.btn_mineashare:
                startActivity(new Intent(getContext(), MineShareActivity.class));
                break;
            case R.id.btn_update:
                update();
                break;
        }
    }

    private void update() {
        PgyUpdateManager.register(getActivity(), "",
                new UpdateManagerListener() {
                    @Override
                    public void onUpdateAvailable(final String result) {
                        // 将新版本信息封装到AppBean中
                        final AppBean appBean = getAppBeanFromString(result);
                        new AlertDialog.Builder(getActivity())
                                .setTitle("更新")
                                .setMessage(appBean.getReleaseNote())
                                .setNegativeButton("确定",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                startDownloadTask(getActivity(), appBean.getDownloadURL());
                                            }
                                        }).show();
                    }

                    @Override
                    public void onNoUpdateAvailable() {
                        Toast.makeText(getContext(), "没有新版本！", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        PgyUpdateManager.unregister();
    }
}
