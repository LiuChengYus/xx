package cn.happy.day01.entity;

import javax.persistence.Entity;

/**
 * Created by CY on 2017/12/20.
 */
@Entity
public class Dog {

    private String dogName;
    private Integer dogAge;
    private String dogId;

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public Integer getDogAge() {
        return dogAge;
    }

    public void setDogAge(Integer dogAge) {
        this.dogAge = dogAge;
    }

    public String getDogId() {
        return dogId;
    }

    public void setDogId(String dogId) {
        this.dogId = dogId;
    }
}
