package com.ar.pay.wechatshare.module.base;

import com.ar.pay.wechatshare.module.onChangeFragment;
import com.jude.beam.bijection.BeamFragment;
import com.jude.beam.bijection.Presenter;


/**
 * author：Administrator on 2017/2/18 16:12
 * company: xxxx
 * email：1032324589@qq.com
 */

public abstract class BeenFragment<T extends Presenter> extends BeamFragment<T> {
    public onChangeFragment changeFragment;

    public void setOnChangeFragment(onChangeFragment changeFragment){
        this.changeFragment = changeFragment;
    }
}
