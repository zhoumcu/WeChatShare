package com.ar.pay.wechatshare.entity;

/**
 * author：Administrator on 2016/12/7 13:48
 * company: xxxx
 * email：1032324589@qq.com
 */
public class User {

    /**
     * img : null
     * userName : 13480562458
     * phone : null
     * userCode : 13480562458
     * isDefault : 0
     */
    private Long id;

    private String img;
    private String userName;
    private String phone;
    private String userCode;
    private String isDefault;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
