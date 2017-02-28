package com.ar.pay.wechatshare.entity;

import java.util.List;

/**
 * author：Administrator on 2017/2/22 14:15
 * company: xxxx
 * email：1032324589@qq.com
 */

public class ArticleBean{
    /**
     * content : [{"id":65,"createTime":1488244801337,"updateTime":1488244801337,"title":"test","user":{"id":1,"createTime":1488116752470,"updateTime":1488116752470,"username":"admin","password":"admin","name":"admin","email":null,"phone":null,"userType":"ADMIN","state":"USE"},"mainPic":"/uploads/2017/02/1488244784323.jpg","conten":"<p>sdfsdfs<\/p><p><img src=\"/uploads/2017/02/1488244799738.jpg\" alt=\"undefined\"><br><\/p>","description":"test","hits":null,"voteUp":null,"state":"PUSH"},{"id":34,"createTime":1488177890615,"updateTime":1488177890615,"title":"test","user":{"id":1,"createTime":1488116752470,"updateTime":1488116752470,"username":"admin","password":"admin","name":"admin","email":null,"phone":null,"userType":"ADMIN","state":"USE"},"mainPic":"/uploads/2017/02/1488177873869.jpg","conten":"<p>teststss<\/p><p><img src=\"/uploads/2017/02/1488177888471.jpg\" alt=\"undefined\"><br><\/p>","description":"","hits":null,"voteUp":null,"state":"PUSH"},{"id":33,"createTime":1488118389801,"updateTime":1488118389801,"title":"8797","user":{"id":1,"createTime":1488116752470,"updateTime":1488116752470,"username":"admin","password":"admin","name":"admin","email":null,"phone":null,"userType":"ADMIN","state":"USE"},"mainPic":"/uploads/2017/02/1488118374888.jpg","conten":"yuiyiu","description":"88888","hits":null,"voteUp":null,"state":"PUSH"},{"id":1,"createTime":1488117763653,"updateTime":1488117763653,"title":"123213","user":{"id":1,"createTime":1488116752470,"updateTime":1488116752470,"username":"admin","password":"admin","name":"admin","email":null,"phone":null,"userType":"ADMIN","state":"USE"},"mainPic":"/uploads/2017/02/1488117760152.png","conten":"123123","description":"213123123","hits":null,"voteUp":null,"state":"PUSH"}]
     * last : true
     * totalPages : 1
     * totalElements : 4
     * sort : [{"direction":"DESC","property":"id","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
     * numberOfElements : 4
     * first : true
     * size : 10
     * number : 0
     */

    private boolean last;
    private int totalPages;
    private int totalElements;
    private int numberOfElements;
    private boolean first;
    private int size;
    private int number;
    /**
     * id : 65
     * createTime : 1488244801337
     * updateTime : 1488244801337
     * title : test
     * user : {"id":1,"createTime":1488116752470,"updateTime":1488116752470,"username":"admin","password":"admin","name":"admin","email":null,"phone":null,"userType":"ADMIN","state":"USE"}
     * mainPic : /uploads/2017/02/1488244784323.jpg
     * conten : <p>sdfsdfs</p><p><img src="/uploads/2017/02/1488244799738.jpg" alt="undefined"><br></p>
     * description : test
     * hits : null
     * voteUp : null
     * state : PUSH
     */

    private List<ContentBean> content;
    /**
     * direction : DESC
     * property : id
     * ignoreCase : false
     * nullHandling : NATIVE
     * ascending : false
     */

    private List<SortBean> sort;

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public List<SortBean> getSort() {
        return sort;
    }

    public void setSort(List<SortBean> sort) {
        this.sort = sort;
    }


    public static class SortBean {
        private String direction;
        private String property;
        private boolean ignoreCase;
        private String nullHandling;
        private boolean ascending;

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public boolean isIgnoreCase() {
            return ignoreCase;
        }

        public void setIgnoreCase(boolean ignoreCase) {
            this.ignoreCase = ignoreCase;
        }

        public String getNullHandling() {
            return nullHandling;
        }

        public void setNullHandling(String nullHandling) {
            this.nullHandling = nullHandling;
        }

        public boolean isAscending() {
            return ascending;
        }

        public void setAscending(boolean ascending) {
            this.ascending = ascending;
        }
    }

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getThumbnailUrl() {
//        return thumbnailUrl;
//    }
//
//    public void setThumbnailUrl(String thumbnailUrl) {
//        this.thumbnailUrl = thumbnailUrl;
//    }
//
//    public String getSummary() {
//        return summary;
//    }
//
//    public void setSummary(String summary) {
//        this.summary = summary;
//    }
//
//    public String getClassify() {
//        return classify;
//    }
//
//    public void setClassify(String classify) {
//        this.classify = classify;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getPublishData() {
//        return publishData;
//    }
//
//    public void setPublishData(String publishData) {
//        this.publishData = publishData;
//    }
//
//    public String getFrom() {
//        return from;
//    }
//
//    public void setFrom(String from) {
//        this.from = from;
//    }
//
//    public int getPageView() {
//        return pageView;
//    }
//
//    public void setPageView(int pageView) {
//        this.pageView = pageView;
//    }
//
//    public int getShareView() {
//        return shareView;
//    }
//
//    public void setShareView(int shareView) {
//        this.shareView = shareView;
//    }
//    @Override
//    public String toString() {
//        return "ArticleBean{" +
//                "title='" + title + '\'' +
//                ", thumbnailUrl='" + thumbnailUrl + '\'' +
//                ", summary='" + summary + '\'' +
//                ", classify='" + classify + '\'' +
//                ", author='" + author + '\'' +
//                ", publishData='" + publishData + '\'' +
//                ", from='" + from + '\'' +
//                ", pageView=" + pageView +
//                ", shareView=" + shareView +
//                '}';
//    }
//
//    public ArticleBean(){
//
//    }
//
//    public ArticleBean(String title, String thumbnailUrl, String summary, String classify, String author, String publishData, String from, int pageView, int shareView) {
//        this.title = title;
//        this.thumbnailUrl = thumbnailUrl;
//        this.summary = summary;
//        this.classify = classify;
//        this.author = author;
//        this.publishData = publishData;
//        this.from = from;
//        this.pageView = pageView;
//        this.shareView = shareView;
//    }
//
//    private String title;//标题
//    private String thumbnailUrl;//缩略图url
//    private String summary;//摘要
//    private String classify;//文章分类
//    private String author;//作者
//    private String publishData;//发布日期
//    private String from;//来源
//    private int pageView;//浏览量
//    private int shareView;//分享量
}
