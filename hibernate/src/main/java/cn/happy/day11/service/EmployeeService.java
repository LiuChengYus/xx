package cn.happy.day11.service;

import cn.happy.day11.dao.EmployeeDAO;
import cn.happy.day11.entity.Emp;
import cn.happy.day11.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;

import java.io.Serializable;


/**
 * Created by CY on 2017/12/31.
 */
public class EmployeeService {
    EmployeeDAO dao=new EmployeeDAO();
    public  Object getData(Class clazz, Serializable id){
        Transaction tx=HibernateUtil.getSession().beginTransaction();
        Object date = dao.getDate(clazz, id);
        /*if(!Hibernate.isInitialized(date)){
            Hibernate.initialize(date);
        }*/
        Emp date1 = (Emp) date;
        date1.getEmpname();
        tx.commit();
        HibernateUtil.close();
        return date;
    }
}
