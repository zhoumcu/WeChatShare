package com.ar.pay.wechatshare.module.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.module.login.fragment.LoginActivity;
import com.ar.pay.wechatshare.module.onChangeFragment;
import com.ar.pay.wechatshare.utils.Constants;
import com.ar.pay.wechatshare.utils.SharedPreferences;
import com.jude.beam.bijection.BeamFragment;

import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/8 11:44
 * company: xxxx
 * email：1032324589@qq.com
 */
public class CommonFragment extends BeamFragment implements onChangeFragment {


    private View rootView;
    private Fragment fragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView ==null)
            rootView = inflater.inflate(R.layout.frg_common, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(SharedPreferences.getInstance().getBoolean(Constants.IS_LOGIN,false)){
            fragment = new MineFragment();
        }else{
            fragment = new LoginActivity();
            ((LoginActivity)fragment).setOnChangeFragment(this);
        }
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
    }

    @Override
    public void onChangeFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }
}
