package cn.happy.day04.entity;

import java.util.Date;

/**
 * Created by CY on 2017/12/27.
 */
public class Port {
    private Integer pid;
    private String widecode;
    private  Double wideprice;
    private Date widedate;

    public Port() {
    }

    public Port(Integer pid, String widecode, Double wideprice, Date widedate) {
        this.pid = pid;
        this.widecode = widecode;
        this.wideprice = wideprice;
        this.widedate = widedate;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getWidecode() {
        return widecode;
    }

    public void setWidecode(String widecode) {
        this.widecode = widecode;
    }

    public Double getWideprice() {
        return wideprice;
    }

    public void setWideprice(Double wideprice) {
        this.wideprice = wideprice;
    }

    public Date getWidedate() {
        return widedate;
    }

    public void setWidedate(Date widedate) {
        this.widedate = widedate;
    }
}
