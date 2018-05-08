package com.ecar.entity;

public class Donate {
    private String did;

    private String openid;

    private String phone;

    private String vid;

    private Long money;

    private Long ddate;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid == null ? null : vid.trim();
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Long getDdate() {
        return ddate;
    }

    public void setDdate(Long ddate) {
        this.ddate = ddate;
    }
}