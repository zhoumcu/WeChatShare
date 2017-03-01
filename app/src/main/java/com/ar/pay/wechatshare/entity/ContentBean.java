package com.ar.pay.wechatshare.entity;

import java.io.Serializable;

/**
 * author：Administrator on 2017/2/28 16:46
 * company: xxxx
 * email：1032324589@qq.com
 */

public class ContentBean implements Serializable {

    /**
     * id : 97
     * createTime : 1488337145455
     * updateTime : 1488337145455
     * title : 反重力电磁悬浮杯 办公室喝个茶都有拉风特效
     * user : {"id":1,"createTime":1488116752470,"updateTime":1488116752470,"username":"admin","password":"admin","name":"admin","email":null,"phone":null,"userType":"ADMIN","state":"USE"}
     * mainPic : /uploads/2017/03/1488337122470.jpg
     * conten : <p class="pcenter" style="text-align: center;"><strong><img src="http://img02.imgcdc.com/grab/img/20160926/68501474851281.jpg"></strong></p><div id="CH_MTL_10002"></div><p><strong>腾讯数码讯</strong>（Newsboy）杯子，是每个家庭的必备之物，不管是奢华昂贵的杯子，还是普通实用的杯子，除了本身喝水、喝酒之用外，它们还有另一项额外作用——家里的装饰品。如果你的杯子能够像悬浮在空中，是不是会很拉风呢？</p><div class="img_wrapper" style="text-align: center;"><p class="pcenter"><imghttp: img1.gtimg.com="" igi="" ics="" v1="" 7="" 78="" 133="" 38743762.jpg=""></imghttp:></p><p></p><p>这听起来就像是在玩魔术！是的，没错，现在有人就发明出了这种<span class="kw"><a href="http://tech.china.com/baike_5Y-N6YeN5Yqb55S156OB5oKs5rWu5p2v.html" target="_blank">反重力电磁悬浮杯</a></span>Levitating CUP。</p><p>Levitating CUP由两部分构成，杯子和底座。事实上，它的设计原理非常简单：杯子底部和底座本身充当电磁两极，同极相斥，自然就能够让你的杯子悬浮在空中，只不过它是如果做到平衡，这可能是这款产品的技术含量所在。</p><p class="pcenter"></p><p class="pcenter"><img src="http://img03.imgcdc.com/grab/img/20160926/7491474851281.gif"></p><p>有了Levitating CUP，你可以倒水，饮料或者鸡尾酒，即便是不小心的碰到杯子，它也不会打翻，因为它就是一个“不倒翁”。</p><p>Levitating CUP悬浮在空中时，它是一种旋转状态，这样看起来是不是逼格更高呢？</p><p class="pcenter"></p><p class="pcenter"><img src="http://img01.imgcdc.com/grab/img/20160926/82101474851282.gif"></p><p>你还可以将底座隐藏在桌子底部，这样当外人看不到底座时，会更加觉得这款杯子的神奇。</p><p>如果是餐厅服务员，端着悬浮杯子将饮料放到客人面前时，肯定会让后者惊呼尖叫！</p><p class="pcenter"></p><p class="pcenter"><img src="http://img03.imgcdc.com/grab/img/20160926/59631474851282.gif"></p><p>当然，这样一款高大上的杯子价格肯定也是不便宜，Levitating CUP提供两个版本，一个是无线底座（充满电可持续使用8小时），另一款是插电底座，无线底座 杯子的价格为129美元（约合人民币860元），插电底座 杯子的价格为149美元（约合人民币993元）。</p></div>
     * description : 反重力电磁悬浮杯 办公室喝个茶都有拉风特效，反重力电磁悬浮杯 办公室喝个茶都有拉风特效
     * hits : 5
     * share : null
     * voteUp : null
     * state : PUSH
     */

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
    private int hits;
    private int share;
    private int voteUp;
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

    public int getVoteUp() {
        return voteUp;
    }

    public void setVoteUp(int voteUp) {
        this.voteUp = voteUp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
