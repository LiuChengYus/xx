package cn.happy.day05.biz;

import cn.happy.day05.dao.HibernateDAO;
import cn.happy.day05.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;

import java.io.Serializable;

/**
 * Created by CY on 2017/12/27.
 */
public class HibernateBiz {
    HibernateDAO dao=new HibernateDAO();
    public Object get(Class clazz, Serializable id){
        /*Transaction tx= HibernateUtil.getSession().beginTransaction();*/
        /*System.out.println(HibernateUtil.getSession().hashCode()+"biz");*/
        Object obj=dao.get(clazz,id);
       /* if(!Hibernate.isInitialized(obj)){
            Hibernate.initialize(obj);
        }
        tx.commit();
        HibernateUtil.close();*/
        System.out.println("==============================");
        return obj;
    }
}
