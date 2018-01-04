package day10onetomonetannocation;

import cn.happy.day13.entity.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by CY on 2018/1/2.
 */
public class mytest201812 {

    @Test
    public  void t1(){
        Configuration cfg=new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        Dept dept=new Dept();
        dept.setDeptname("开发部");
        session.saveOrUpdate(dept);
        tx.commit();
    }
}
