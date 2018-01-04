package cn.happy.day02.entity;

import javax.persistence.Entity;

/**
 * Created by CY on 2017/12/23.
 */
//区县表
@Entity
public class District {
    private Integer id;//区县编号
    private String name;//区县名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
