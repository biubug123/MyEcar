package com.ecar.entity;

public class Vin {
    private String vid;

    private String rid;

    private String carmodels;

    private String models;

    private String years;

    private String startnumber;

    private String endnumber;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCarmodels() {
        return carmodels;
    }

    public void setCarmodels(String carmodels) {
        this.carmodels = carmodels == null ? null : carmodels.trim();
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models == null ? null : models.trim();
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years == null ? null : years.trim();
    }

    public String getStartnumber() {
        return startnumber;
    }

    public void setStartnumber(String startnumber) {
        this.startnumber = startnumber == null ? null : startnumber.trim();
    }

    public String getEndnumber() {
        return endnumber;
    }

    public void setEndnumber(String endnumber) {
        this.endnumber = endnumber == null ? null : endnumber.trim();
    }
}