package com.hz.sample.domain;

import java.util.Date;

/**
 * POJO representing the domain object
 */
public class Dashboard {
    private Long reckey;
    private Integer bankcode;
    private String brnchcode;
    private String scanref;
    private Date scndate;

    public Long getReckey() {
        return reckey;
    }

    public void setReckey(Long reckey) {
        this.reckey = reckey;
    }

    public Integer getBankcode() {
        return bankcode;
    }

    public void setBankcode(Integer bankcode) {
        this.bankcode = bankcode;
    }

    public String getBrnchcode() {
        return brnchcode;
    }

    public void setBrnchcode(String brnchcode) {
        this.brnchcode = brnchcode;
    }

    public String getScanref() {
        return scanref;
    }

    public void setScanref(String scanref) {
        this.scanref = scanref;
    }

    public Date getScndate() {
        return scndate;
    }

    public void setScndate(Date scndate) {
        this.scndate = scndate;
    }
}
