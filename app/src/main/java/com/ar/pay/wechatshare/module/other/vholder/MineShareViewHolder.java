package com.ar.pay.wechatshare.module.other.vholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.app.APP;
import com.ar.pay.wechatshare.entity.ShareBean;
import com.ar.pay.wechatshare.server.okhttp.HttpHelper;
import com.ar.pay.wechatshare.utils.Constants;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/8 14:42
 * company: xxxx
 * email：1032324589@qq.com
 */
public class MineShareViewHolder extends BaseViewHolder<ShareBean.DataEntity> {


    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.img_icon)
    ImageView imgIcon;
    @BindView(R.id.tv_read)
    TextView tvRead;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.describer)
    TextView describer;

    public MineShareViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_article);
        ButterKnife.bind(this, itemView);
        String content="[顶]"+"哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈啊哈哈";

    }

    @Override
    public void setData(ShareBean.DataEntity data) {
        super.setData(data);
        Picasso.with(APP.getInstances().getApplicationContext())
                .load(HttpHelper.BaseURL + data.getMain_pic())
                .resize(130, 80)
                .centerCrop()
                .into(imgIcon);
        title.setText(data.getTitle());
        tvRead.setText(Constants.setTextColor("阅读：" + data.getHits()));
        tvShare.setText(Constants.setTextColor("分享：" + data.getNum()));
        describer.setText(data.getDescription());
    }
}
