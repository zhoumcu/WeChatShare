package com.ar.pay.wechatshare.module.main;

import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.entity.Category;
import com.ar.pay.wechatshare.module.main.fragment.CommonFragment;
import com.ar.pay.wechatshare.module.main.fragment.Home1Fragment;
import com.ar.pay.wechatshare.module.main.fragment.HomeFragment;
import com.ar.pay.wechatshare.server.okhttp.HttpHelper;
import com.ar.pay.wechatshare.server.okhttp.RequestHandler;
import com.jude.utils.JUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author：Administrator on 2016/12/8 11:36
 * company: xxxx
 * email：1032324589@qq.com
 */
public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.id_content)
    FrameLayout id_content;
    @BindView(R.id.btn_home)
    RadioButton btnHome;
    @BindView(R.id.btn_mine)
    RadioButton btnMine;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    private long mExitTime;
    private Fragment mHomeFragment;
    private Fragment mCommonFragment;
    private Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        switchContent(new HomeFragment());
        showFragment(0);
//        Review.MD5Review(this,"com.ar.pay.wechatshare","761a8e3374d49b746beddf9674b9d7e9");
    }

    public void switchContent(Fragment from, Fragment to) {
        if (mContent != to) {
            mContent = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().setCustomAnimations(
                    android.R.anim.fade_in, android.R.anim.fade_out);
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.hide(from).add(R.id.id_content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }
    public void showFragment(int index) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        // 想要显示一个fragment,先隐藏所有fragment，防止重叠
        hideFragments(ft);
        switch (index) {
            case 0:
                if (mHomeFragment != null)
                    ft.show(mHomeFragment);
                else {
                    mHomeFragment = new HomeFragment();
                    ft.add(R.id.id_content, mHomeFragment);
                }
                ft.commit();
                break;
            case 1:
                if (mCommonFragment != null)
                    ft.show(mCommonFragment);
                else {
                    mCommonFragment = new CommonFragment();
                    ft.add(R.id.id_content, mCommonFragment);
                }
                ft.commit();
                break;
        }
    }

    // 当fragment已被实例化，就隐藏起来
    public void hideFragments(FragmentTransaction ft) {
        if (mCommonFragment != null)
            ft.hide(mCommonFragment);
        if (mHomeFragment != null)
            ft.hide(mHomeFragment);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                JUtils.Toast("再按一次退出程序");
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.btn_home, R.id.btn_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
                showFragment(0);
                break;
            case R.id.btn_mine:
                showFragment(1);
                break;
        }
    }
}
