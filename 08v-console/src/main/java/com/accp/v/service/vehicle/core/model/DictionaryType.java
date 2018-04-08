package com.accp.v.service.vehicle.core.model;

import java.io.Serializable;

public class DictionaryType implements Serializable {
    private Integer id;

    private Integer dictypeid;

    private String dictypename;

    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictypeid() {
        return dictypeid;
    }

    public void setDictypeid(Integer dictypeid) {
        this.dictypeid = dictypeid;
    }

    public String getDictypename() {
        return dictypename;
    }

    public void setDictypename(String dictypename) {
        this.dictypename = dictypename == null ? null : dictypename.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}