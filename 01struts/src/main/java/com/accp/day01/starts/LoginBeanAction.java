package com.accp.day01.starts;

import com.opensymphony.xwork2.Action;

/**
 * Created by CY on 2018/2/23.
 */
public class LoginAction implements Action {
    private  String name;
    private  String pwd;
    public String execute() throws Exception {
        if (name.equals("admin")&&pwd.equals("admin")){
            return SUCCESS;
        }else {
            return LOGIN;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
