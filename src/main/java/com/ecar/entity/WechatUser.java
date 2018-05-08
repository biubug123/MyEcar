package com.ecar.entity;

public class WechatUser {
    private String openid;

    private String nickname;

    private Integer sex;

    private String city;

    private String province;

    private String contry;

    private String headimgurl;

    private String privilege;

    private String unionid;

    private String accesstoken;

    private Long expiresin;

    private String refreshtoken;

    private Long accesstokentime;

    private Long refreshtokentime;

    private Long firstlogintime;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry == null ? null : contry.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege == null ? null : privilege.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken == null ? null : accesstoken.trim();
    }

    public Long getExpiresin() {
        return expiresin;
    }

    public void setExpiresin(Long expiresin) {
        this.expiresin = expiresin;
    }

    public String getRefreshtoken() {
        return refreshtoken;
    }

    public void setRefreshtoken(String refreshtoken) {
        this.refreshtoken = refreshtoken == null ? null : refreshtoken.trim();
    }

    public Long getAccesstokentime() {
        return accesstokentime;
    }

    public void setAccesstokentime(Long accesstokentime) {
        this.accesstokentime = accesstokentime;
    }

    public Long getRefreshtokentime() {
        return refreshtokentime;
    }

    public void setRefreshtokentime(Long refreshtokentime) {
        this.refreshtokentime = refreshtokentime;
    }

    public Long getFirstlogintime() {
        return firstlogintime;
    }

    public void setFirstlogintime(Long firstlogintime) {
        this.firstlogintime = firstlogintime;
    }
}