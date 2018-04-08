package cn.happy.day08ognl.entity;

import java.util.Date;

/**
 * Created by CY on 2018/2/24.
 */
public class UserInfo {
    //用户名称属性
    private  String name;
    private Address address=new Address();
    //日期
    private Date mydate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getMydate() {
        return mydate;
    }

    public void setMydate(Date mydate) {
        this.mydate = mydate;
    }
}
