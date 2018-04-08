package com.accp.v.service.vehicle.core.model;

import java.io.Serializable;

public class Vehiclemanagement implements Serializable {
    private Integer id;

    private String carlicense;

    private String vin;

    private Integer iccid;

    private Integer cartype;

    private String provinces;

    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarlicense() {
        return carlicense;
    }

    public void setCarlicense(String carlicense) {
        this.carlicense = carlicense;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getIccid() {
        return iccid;
    }

    public void setIccid(Integer iccid) {
        this.iccid = iccid;
    }

    public Integer getCartype() {
        return cartype;
    }

    public void setCartype(Integer cartype) {
        this.cartype = cartype;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}