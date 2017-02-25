package com.ar.pay.wechatshare.module.main;

import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;

import com.ar.pay.wechatshare.R;
import com.ar.pay.wechatshare.app.APP;
import com.ar.pay.wechatshare.module.base.BeenBaseActivity;
import com.ar.pay.wechatshare.widget.ProgressWebView;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;

/**
 * author：Administrator on 2017/2/22 14:53
 * company: xxxx
 * email：1032324589@qq.com
 */
public class ArticlesDetail extends BeenBaseActivity {
    private ProgressWebView webView;
    private String testUrl = "http://mp.weixin.qq.com/s?__biz=MzA5OTcxNDQwNg==&mid=501457379&idx=2&sn=987268b4b884103ac58421b5914b0953&mpshare=1&scene=1&srcid=0222FME9PXJT94mLQUjZhUBK#rd";
    @Override
    public int onCreateView() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        return R.layout.activity_main_test_2;
    }

    @Override
    public void onDelayCreate(ViewStub viewStub) {
        viewStub.inflate();
        webView = (ProgressWebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(testUrl);
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
                sendText();
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
}
