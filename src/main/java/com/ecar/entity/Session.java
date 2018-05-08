package com.ecar.entity;

public class Session {
    private String id;

    private String accountid;

    private Long expireat;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid == null ? null : accountid.trim();
    }

    public Long getExpireat() {
        return expireat;
    }

    public void setExpireat(Long expireat) {
        this.expireat = expireat;
    }
}