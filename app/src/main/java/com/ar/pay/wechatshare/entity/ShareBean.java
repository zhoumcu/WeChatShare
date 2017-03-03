package com.ar.pay.wechatshare.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ymn on 2017/3/4.
 */
public class ShareBean implements Serializable{

    /**
     * id : 2
     * title : 原标题：中国古董鱼盆在英拍得700万元 曾被当赝品估价1.5万
     * main_pic : /uploads/2017/03/1488416372961.jpg
     * description : 原标题：中国古董鱼盆在英拍得700万元 曾被当赝品估价1.5万
     * hits : 3
     * share : 1
     * num : 2
     */

    private List<DataEntity> data;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private int id;
        private String title;
        private String main_pic;
        private String description;
        private int hits;
        private int share;
        private int num;

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
    }
}
