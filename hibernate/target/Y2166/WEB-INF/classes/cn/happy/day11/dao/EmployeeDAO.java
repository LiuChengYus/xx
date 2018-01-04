package cn.happy.day11.dao;

import cn.happy.day11.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;

/**
 * Created by CY on 2017/12/31.
 */
public class EmployeeDAO {
    //通过Load方法获取到一个员工
   public  Object getDate(Class clazz, Serializable id){
       Session session = HibernateUtil.getSession();
       Object obj = session.load(clazz, id);
       return obj;
   }
}