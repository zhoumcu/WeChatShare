package com.ar.pay.wechatshare.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.app.APP;
import com.ar.pay.wechatshare.entity.ArticleBean;
import com.ar.pay.wechatshare.entity.UserBean;
import com.ar.pay.wechatshare.module.login.fragment.Login;
import com.ar.pay.wechatshare.server.okhttp.HttpHelper;
import com.ar.pay.wechatshare.utils.Constants;
import com.ar.pay.wechatshare.utils.SharedPreferences;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.smtt.sdk.WebView;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * author：Administrator on 2017/2/22 14:53
 * company: xxxx
 * email：1032324589@qq.com
 */
public class ArticlesDetail extends AppCompatActivity {
    public static final String MY_TAG = "ArticlesDetail";
    private WebView webView;
    private String testUrl = "http://mp.weixin.qq.com/s?__biz=MzA5OTcxNDQwNg==&mid=501457379&idx=2&sn=987268b4b884103ac58421b5914b0953&mpshare=1&scene=1&srcid=0222FME9PXJT94mLQUjZhUBK#rd";
    private String articlesUrl;
    private ArticleBean article;
    private UserBean userBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test_1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        article = (ArticleBean) getIntent().getSerializableExtra("DETAIL");
        userBean = SharedPreferences.getInstance().getUserInfo();
        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        articlesUrl = HttpHelper.BaseURL+"api/page/"+article.getId();
        webView.loadUrl(articlesUrl);
        Log.e(MY_TAG,articlesUrl);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case android.R.id.home:
                // 处理返回逻辑
                finish();
                return true;
            case R.id.menu_share:
//                sendText();
                showShare();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //调用inflate()方法创建菜单
        getMenuInflater().inflate(R.menu.share_menu,menu);
        //如果返回false，创建的菜单无法显示
        return true;
    }
    @Override
    // 设置回退
    // 覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
    private void sendUrl(){
        WXWebpageObject webpageObject = new WXWebpageObject();
        webpageObject.webpageUrl = testUrl;

        WXMediaMessage mediaMessage = new WXMediaMessage(webpageObject);
        mediaMessage.title = "test";
        mediaMessage.description = "sdfsdfsd";
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test);
//        mediaMessage.thumbData  = Util.bmpToArray(bitmap,true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = mediaMessage;
        //分享到朋友圈（微信版本4.2之前不支持分享到朋友圈）
//        req.scene = SendMessageToWX.Req.WXSceneTimeline ;
        //分享给好友
        req.scene = SendMessageToWX.Req.WXSceneSession;
        APP.getInstances().api.sendReq(req);
    }
    private void sendText(){
        WXTextObject webpageObject = new WXTextObject();
        webpageObject.text = testUrl;

        WXMediaMessage mediaMessage = new WXMediaMessage(webpageObject);
        mediaMessage.description = "sdfsdfsd";
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test);
//        mediaMessage.thumbData  = Util.bmpToArray(bitmap,true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = mediaMessage;
        //分享到朋友圈（微信版本4.2之前不支持分享到朋友圈）
//        req.scene = SendMessageToWX.Req.WXSceneTimeline ;
        //分享给好友
        req.scene = SendMessageToWX.Req.WXSceneSession;
        APP.getInstances().api.sendReq(req);
    }
    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }

    private void showShare() {
        if(!SharedPreferences.getInstance().getBoolean(Constants.IS_LOGIN,false)){
            startActivity(new Intent(this, Login.class));
            return;
        }
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle(article.getTitle());
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
//        oks.setTitleUrl(articlesUrl);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(article.getDescription());
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl(HttpHelper.BaseURL+article.getMain_pic());
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(articlesUrl);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("");
        // site是分享此内容的网站名称，仅在QQ空间使用
//        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://sharesdk.cn");
        // 设置自定义的外部回调
        oks.setCallback(new OneKeyShareCallback());
        // 启动分享GUI
        oks.show(this);
    }

    private class OneKeyShareCallback implements PlatformActionListener {
        @Override
        public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
            Log.w("ArticlesDetail","sdfsadfsa");
            EventBus.getDefault().post(true);
            HttpHelper.getInstance().postShare(article.getId(),userBean.getId());
        }

        @Override
        public void onError(Platform platform, int i, Throwable throwable) {

        }

        @Override
        public void onCancel(Platform platform, int i) {

        }
    }
}
