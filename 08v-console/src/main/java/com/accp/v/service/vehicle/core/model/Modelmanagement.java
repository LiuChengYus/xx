package com.accp.v.service.vehicle.core.model;

import java.io.Serializable;

public class Modelmanagement implements Serializable {
    private Integer id;

    private String cartype;

    private String announcement;

    private Double mileage;

    private Double topspeed;

    private Double length;

    private Double width;

    private Double weigth;

    private Integer seatnumber;

    private Integer doornum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement == null ? null : announcement.trim();
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Double getTopspeed() {
        return topspeed;
    }

    public void setTopspeed(Double topspeed) {
        this.topspeed = topspeed;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getWeigth() {
        return weigth;
    }

    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }

    public Integer getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(Integer seatnumber) {
        this.seatnumber = seatnumber;
    }

    public Integer getDoornum() {
        return doornum;
    }

    public void setDoornum(Integer doornum) {
        this.doornum = doornum;
    }
}