package com.ar.pay.wechatshare.module.other;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.app.APP;
import com.bm.library.PhotoView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ymn on 2017/3/20.
 */
public class PhotoActivity extends AppCompatActivity {
    @BindView(R.id.img_logo)
    PhotoView imgLogo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_photo);
        ButterKnife.bind(this);
        // 启用图片缩放功能
        imgLogo.enable();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        String imageurl = getIntent().getStringExtra("imageurl");
        Picasso.with(APP.getInstances().getApplicationContext())
                .load(imageurl)
                .into(imgLogo);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case android.R.id.home:
                // 处理返回逻辑
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
