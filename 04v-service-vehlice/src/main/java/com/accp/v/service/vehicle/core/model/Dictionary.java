package com.accp.v.service.vehicle.core.model;

import java.io.Serializable;

public class Dictionary implements Serializable {
    private Integer id;

    private Integer dictype;

    private String diccode;

    private String dicvalue;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictype() {
        return dictype;
    }

    public void setDictype(Integer dictype) {
        this.dictype = dictype;
    }

    public String getDiccode() {
        return diccode;
    }

    public void setDiccode(String diccode) {
        this.diccode = diccode == null ? null : diccode.trim();
    }

    public String getDicvalue() {
        return dicvalue;
    }

    public void setDicvalue(String dicvalue) {
        this.dicvalue = dicvalue == null ? null : dicvalue.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}