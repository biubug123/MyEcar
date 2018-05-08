package com.ecar.entity;

public class AccessToken {
    private String tid;

    private String accessToken;

    private String jsapiTicket;

    private Long refreshTime;

    private Long expiresIn;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket == null ? null : jsapiTicket.trim();
    }

    public Long getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(Long refreshTime) {
        this.refreshTime = refreshTime;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
}