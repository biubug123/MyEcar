package com.ecar.entity;

public class Record {
    private String rid;

    private String phone;

    private String videoid;

    private Long lastdate;

    private Long collectdate;

    private Integer iscollect;

    private Videos videos;

    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid == null ? null : videoid.trim();
    }

    public Long getLastdate() {
        return lastdate;
    }

    public void setLastdate(Long lastdate) {
        this.lastdate = lastdate;
    }

    public Long getCollectdate() {
        return collectdate;
    }

    public void setCollectdate(Long collectdate) {
        this.collectdate = collectdate;
    }

    public Integer getIscollect() {
        return iscollect;
    }

    public void setIscollect(Integer iscollect) {
        this.iscollect = iscollect;
    }
}