package cn.tmsreception.entity;

import java.util.Date;

/**
 * Created by Happy on 2017-12-11.
 * 每周报表实体
 */
public class WeekVentory {
    private String weekcode;
    private String port; //港口
    private String typecode; //木材
    private Date pubtime;
    private double price;
    private double reduceprice;
    private double percent;
   //植入木材种类实体
    private  PortLumpType portlumptype;

    public String getWeekcode() {
        return weekcode;
    }

    public void setWeekcode(String weekcode) {
        this.weekcode = weekcode;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getReduceprice() {
        return reduceprice;
    }

    public void setReduceprice(double reduceprice) {
        this.reduceprice = reduceprice;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public PortLumpType getPortlumptype() {
        return portlumptype;
    }

    public void setPortlumptype(PortLumpType portlumptype) {
        this.portlumptype = portlumptype;
    }
}
