package com.ar.pay.wechatshare.entity;

/**
 * author：Administrator on 2017/2/22 14:15
 * company: xxxx
 * email：1032324589@qq.com
 */

public class ArticleBean {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishData() {
        return publishData;
    }

    public void setPublishData(String publishData) {
        this.publishData = publishData;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getPageView() {
        return pageView;
    }

    public void setPageView(int pageView) {
        this.pageView = pageView;
    }

    public int getShareView() {
        return shareView;
    }

    public void setShareView(int shareView) {
        this.shareView = shareView;
    }
    @Override
    public String toString() {
        return "ArticleBean{" +
                "title='" + title + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", summary='" + summary + '\'' +
                ", classify='" + classify + '\'' +
                ", author='" + author + '\'' +
                ", publishData='" + publishData + '\'' +
                ", from='" + from + '\'' +
                ", pageView=" + pageView +
                ", shareView=" + shareView +
                '}';
    }

    public ArticleBean(){

    }

    public ArticleBean(String title, String thumbnailUrl, String summary, String classify, String author, String publishData, String from, int pageView, int shareView) {
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.summary = summary;
        this.classify = classify;
        this.author = author;
        this.publishData = publishData;
        this.from = from;
        this.pageView = pageView;
        this.shareView = shareView;
    }

    private String title;//标题
    private String thumbnailUrl;//缩略图url
    private String summary;//摘要
    private String classify;//文章分类
    private String author;//作者
    private String publishData;//发布日期
    private String from;//来源
    private int pageView;//浏览量
    private int shareView;//分享量
}
