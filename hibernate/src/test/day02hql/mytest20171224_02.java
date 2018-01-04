package day02hql;

import cn.happy.day01.entity.Student;
import cn.happy.day01.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * 脏检查和缓存机制探讨
 */
public class mytest20171224_02 {
    Configuration cfg;
    SessionFactory factory;
    Session session;
    Transaction tx;
    @Before
    public void before(){
        cfg=new Configuration().configure();
        factory=cfg.buildSessionFactory();
        session=factory.getCurrentSession();
        tx=session.beginTransaction();
    }
   /* @After
    public void after(){
        tx.commit();
    }*/

    @Test
    public void t1(){
        //使用update更新数据
        Student student = session.load(Student.class, 4);
        student.setSname("xx");
        session.update(student);
        tx.commit();
        //在数据同步情况下更新数据
        Student student1 = HibernateUtil.getSession().load(Student.class, 4);
        student1.setSname("xiaoli");

        HibernateUtil.closeSession();
    }
    @Test
    public void t2(){
        Configuration cfg=new Configuration().configure();
        //创建session工厂对象
        SessionFactory sf=cfg.buildSessionFactory();
        //打开session
        Session session=sf.getCurrentSession();
        //开启事务
        Transaction tx=session.beginTransaction();
        //第一次修改
        Student student=session.get(Student.class,4);
        student.setSname("小红");
        session.update(student);
        //第二次修改
        Student student1=session.get(Student.class,4);
        session.update(student);
        tx.commit();
    }

}
