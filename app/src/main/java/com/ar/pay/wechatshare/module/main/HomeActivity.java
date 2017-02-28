package com.ar.pay.wechatshare.module.main;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.KeyEvent;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.module.main.fragment.CommonFragment;
import com.ar.pay.wechatshare.module.main.fragment.HomeFragment;
import com.ar.pay.wechatshare.widget.NoScrollViewPager;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.utils.JUtils;
import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;
import com.review.signature.Review;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/8 11:36
 * company: xxxx
 * email：1032324589@qq.com
 */
public class HomeActivity extends BeamBaseActivity {

    @BindView(R.id.viewPager)
    NoScrollViewPager viewPager;
    @BindView(R.id.tabs)
    AdvancedPagerSlidingTabStrip tabs;
    private long mExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Review.MD5Review(this,"com.ar.pay.wechatshare","761a8e3374d49b746beddf9674b9d7e9");
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));
        tabs.setViewPager(viewPager);
    }

    private class myPagerAdapter extends FragmentStatePagerAdapter implements AdvancedPagerSlidingTabStrip.IconTabProvider {
        String[] title = {"分享赚钱", "用户中心"};
        int[] iconNo = {R.mipmap.ico_home, R.mipmap.ico_user};
        int[] iconSelt = {R.mipmap.ico_home_c, R.mipmap.ico_user_c};
        HomeFragment mHomeFragment;
        Fragment mMineFragment;

        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    mHomeFragment = new HomeFragment();
                    return mHomeFragment;
                case 1:
                    mMineFragment = new CommonFragment();
                    return mMineFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public Integer getPageIcon(int position) {
            return iconNo[position];
        }

        @Override
        public Integer getPageSelectIcon(int position) {
            return iconSelt[position];
        }

        @Override
        public Rect getPageIconBounds(int position) {
            return null;
        }

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

}
