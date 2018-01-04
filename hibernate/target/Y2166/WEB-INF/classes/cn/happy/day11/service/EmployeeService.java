package cn.happy.day11.service;

import cn.happy.day11.dao.EmployeeDAO;
import cn.happy.day11.util.HibernateUtil;
import org.hibernate.Transaction;

import java.io.Serializable;


/**
 * Created by CY on 2017/12/31.
 */
public class EmployeeService {
    EmployeeDAO dao=new EmployeeDAO();
    public  Object getData(Class clazz, Serializable id){

        Object date = dao.getDate(clazz, id);

        return date;
    }
}
