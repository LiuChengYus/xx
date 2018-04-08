package cn.accp.entity;

import java.io.Serializable;

/**
 * Created by CY on 2018/2/28.
 */
public class Employee implements Serializable {
    private String sn; //用户id
    private String password; //密码
    private String name; //昵称
    private String status; //工作状态 :是否在职

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
