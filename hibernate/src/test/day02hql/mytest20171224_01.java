package day02hql;

import cn.happy.day01.entity.Student;
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
 * Created by CY on 2017/12/24.
 */
public class mytest20171224_01 {
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
    @After
    public void after(){
        tx.commit();
    }

    //01 hql检索所有学生
    @Test
    public void testselectAll(){
        String str="from Student";
        Query query = session.createQuery(str);
        List<Student> list = query.list();
        for (Student item:list){
            System.out.println(item.getSname());
        }
    }
    //01 hql检索所有学生
    @Test
    public void testseleectAllStudent(){
        String str="from cn.happy.day01.entity.Student";
        Query query = session.createQuery(str);
        List<Student> list = query.list();
        for (Student item:list){
            System.out.println(item.getSname());
        }
    }


    //02hql获取单列的信息
    @Test
    public void testSelectSomeRows(){
        String str="from Student s where s.sname='小红'";
        Query query = session.createQuery(str);
        List<Student> list = query.list();
        for (Student item:list){
            System.out.println(item.getSname());
        }
    }


    // 03 hql获取部分列
    @Test
    public void testgetmiuitClount(){
        String str="select d.sname from Student d ";
        Query query = session.createQuery(str);
        List<String> list = query.list();
        for (String item:list){
            System.out.println(item);
        }
    }
    // 04 hql获取部分列
    @Test
    public void testgetClounts(){
        String str="select d.sname,d.sage from Student d ";
        Query query = session.createQuery(str);
        List<Object[]> list = query.list();
        for (Object[] item:list){
           for (Object it:item){
               System.out.println(it);
           }
        }
    }
}
