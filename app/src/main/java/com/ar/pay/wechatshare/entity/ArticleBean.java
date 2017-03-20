package com.ar.pay.wechatshare.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * author：Administrator on 2017/2/22 14:15
 * company: xxxx
 * email：1032324589@qq.com
 */

public class ArticleBean implements Serializable{

    /**
     * id : 16
     * title : 123
     * main_pic : /uploads\2017\03\1489763765228.png
     * description : 213123
     * hits : 29
     * share : null
     * num : null
     * channel : 科技
     */

    private int id;
    private String title;
    private String main_pic;
    private String description;
    private int hits;
    private int share;
    private int num;
    private String channel;
    private String username;

    public static List<ArticleBean> arrayArticleBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ArticleBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMain_pic() {
        return main_pic;
    }

    public void setMain_pic(String main_pic) {
        this.main_pic = main_pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
