package com.ecar.entity;

public class Collect {
    private String cid;

    private String vid;

    private String phone;

    private Long cdate;

    private Videos videos;

    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid == null ? null : vid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getCdate() {
        return cdate;
    }

    public void setCdate(Long cdate) {
        this.cdate = cdate;
    }
}