package com.ar.pay.wechatshare.entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * author：Administrator on 2017/3/13 11:38
 * company: xxxx
 * email：1032324589@qq.com
 */

public class Category implements Serializable{


    /**
     * id : 2
     * create_time : 1489446819000
     * update_time : 1489446819000
     * level : 1
     * name : 科技
     * state : USE
     * channel_id : null
     */

    private int id;
    private long create_time;
    private long update_time;
    private int level;
    private String name;
    private String state;
    private Object channel_id;

    public static List<Category> arrayCategoryFromData(String str) {

        Type listType = new TypeToken<ArrayList<Category>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(Object channel_id) {
        this.channel_id = channel_id;
    }
}
