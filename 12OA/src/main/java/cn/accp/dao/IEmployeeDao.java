package cn.accp.dao;

import cn.accp.entity.Employee;

/**
 * Created by CY on 2018/2/28.
 */
public interface IEmployeeDao {

    //登陆的方法
    public Employee login(Employee employee);
}
