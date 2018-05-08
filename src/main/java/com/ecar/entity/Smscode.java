package com.ecar.entity;

public class Smscode {
    private String phonenumber;

    private String code;

    private Long lasttime;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getLasttime() {
        return lasttime;
    }

    public void setLasttime(Long lasttime) {
        this.lasttime = lasttime;
    }
}