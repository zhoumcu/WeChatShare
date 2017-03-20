package com.ar.pay.wechatshare.module.main.fragment;

import android.content.Context;
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
import com.ar.pay.wechatshare.entity.Category;
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
    public List<Fragment> flist = new ArrayList<>();
    public List<String> listStr = new ArrayList<>();
    public myPagerAdapter adapter;
    private Category category;

    public static HomeFragment getFragment(Category category){
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("category",category);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        adapter = new myPagerAdapter(getChildFragmentManager());
    }
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
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(adapter);
        tabs.setViewPager(viewPager);
    }

    public class myPagerAdapter extends FragmentPagerAdapter {

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
            return listStr.get(position);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
