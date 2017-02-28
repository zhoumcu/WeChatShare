package com.ar.pay.wechatshare.entity;

import java.io.Serializable;

/**
 * author：Administrator on 2017/2/28 16:46
 * company: xxxx
 * email：1032324589@qq.com
 */

public class ContentBean implements Serializable {
    private static final long serialVersionUID = 4226755799531293257L;
    private int id;
    private long createTime;
    private long updateTime;
    private String title;
    /**
     * id : 1
     * createTime : 1488116752470
     * updateTime : 1488116752470
     * username : admin
     * password : admin
     * name : admin
     * email : null
     * phone : null
     * userType : ADMIN
     * state : USE
     */

    private UserBean user;
    private String mainPic;
    private String conten;
    private String description;
    private Object hits;
    private Object voteUp;
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public String getConten() {
        return conten;
    }

    public void setConten(String conten) {
        this.conten = conten;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getHits() {
        return hits;
    }

    public void setHits(Object hits) {
        this.hits = hits;
    }

    public Object getVoteUp() {
        return voteUp;
    }

    public void setVoteUp(Object voteUp) {
        this.voteUp = voteUp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
