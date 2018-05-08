package com.ecar.entity;

public class Consult {
    private String cid;

    private String vid;

    private String title;

    private String question;

    private String solution;

    private Long qdate;

    private Long sdate;

    private String phone;

    private Integer dis;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution == null ? null : solution.trim();
    }

    public Long getQdate() {
        return qdate;
    }

    public void setQdate(Long qdate) {
        this.qdate = qdate;
    }

    public Long getSdate() {
        return sdate;
    }

    public void setSdate(Long sdate) {
        this.sdate = sdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getDis() {
        return dis;
    }

    public void setDis(Integer dis) {
        this.dis = dis;
    }
}