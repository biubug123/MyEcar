package com.ecar.util.weiXinPublic;

/**
 * @program: ecar
 * @description: 微信用户实体类
 * @author: ziHeng
 * @create: 2018-05-07 16:57
 **/

public class WeChatPublicUser {

    /**
     * 普通用户的标识，对当前开发者帐号唯一
     */
    private String openid;

    /**
     * 访问令牌 由微信发放
     */
    private String accessToken;

    /**
     * 发放令牌的时间
     */
    private Long accessTokenTime;
    /**
     * 过期时间
     */
    private Long expiresIn;

    /**
     * 用于刷新Access Token 的 Refresh Token,所有应用都会返回该参数
     */
    private String refreshToken;

    private String refreshTokenTime;

    /**
     * 普通用户昵称
     */
    private String nickName;
    /**
     * 语言
     */
    private String language;
    /**
     * 普通用户性别，1为男性，2为女性
     */
    private Integer sex;
    /**
     * 普通用户个人资料填写的省份
     */
    private String province;
    /**
     * 普通用户个人资料填写的城市
     */
    private String city;
    /**
     * 国家，如中国为CN
     */
    private String contry;
    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     */
    private String headImgUrl;
    /**
     * 用户特权信息，json数组，如微信沃卡用户为（chinaunicom）
     */
    private String[] privilege;
    /**
     * 用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的。
     */
    private String unionid;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getAccessTokenTime() {
        return accessTokenTime;
    }

    public void setAccessTokenTime(Long accessTokenTime) {
        this.accessTokenTime = accessTokenTime;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String[] getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String[] privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }


}
