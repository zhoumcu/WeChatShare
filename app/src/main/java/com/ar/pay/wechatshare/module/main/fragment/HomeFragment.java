package com.ar.pay.wechatshare.module.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ar.pay.wechatshare.R;
import com.jude.beam.bijection.BeamFragment;
import com.jude.beam.bijection.RequiresPresenter;
import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/8 11:39
 * company: xxxx
 * email：1032324589@qq.com
 */
@RequiresPresenter(HomeFragmentPresenter.class)
public class HomeFragment extends BeamFragment<HomeFragmentPresenter> {
    @BindView(R.id.tabs)
    AdvancedPagerSlidingTabStrip tabs;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    String[] title = {"科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技","科技"};
    private List<Fragment> flist = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aty_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(new HomeFragment.myPagerAdapter(getChildFragmentManager()));
        tabs.setViewPager(viewPager);
    }
    private void initData(){
        int lenght = title.length;
        for(int i=0;i<lenght;i++){
            Home1Fragment home = new Home1Fragment();
            flist.add(home);
        }
    }
    private class myPagerAdapter extends FragmentPagerAdapter{

        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return flist.get(position);
        }

        @Override
        public int getCount() {
            return flist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

    }

}
