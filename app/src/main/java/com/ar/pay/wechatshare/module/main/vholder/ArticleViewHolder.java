package com.ar.pay.wechatshare.module.main.vholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.app.APP;
import com.ar.pay.wechatshare.entity.ContentBean;
import com.ar.pay.wechatshare.server.okhttp.HttpHelper;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author：Administrator on 2016/12/8 14:42
 * company: xxxx
 * email：1032324589@qq.com
 */
public class ArticleViewHolder extends BaseViewHolder<ContentBean> {


    private ArticleViewHolder context;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.img_icon)
    ImageView imgIcon;
    @BindView(R.id.tv_read)
    TextView tvRead;
    @BindView(R.id.tv_share)
    TextView tvShare;

    public ArticleViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_article);
        context = this;
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(ContentBean data) {
        super.setData(data);
        Picasso.with(APP.getInstances().getApplicationContext())
                .load(HttpHelper.BaseURL+data.getMainPic())
                .resize(160,80)
                .centerCrop()
                .into(imgIcon);
        title.setText(data.getTitle());
    }
}
