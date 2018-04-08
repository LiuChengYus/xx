package com.accp.day08Typeconversion.test;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by CY on 2018/2/26.
 */
public class Student implements Serializable {
    private String name;
    private String idcard;
    private String birthday;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdcard() {
        return idcard;
    }
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
