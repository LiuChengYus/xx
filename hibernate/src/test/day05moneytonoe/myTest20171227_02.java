package day05moneytonoe;


import cn.happy.day05.biz.HibernateBiz;
import cn.happy.day05.entity.Dept;
import cn.happy.day05.entity.Emp;
import cn.happy.day05.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class myTest20171227_02 {
    Session session;
    Transaction tx;
    @Before
    public void before(){
        Configuration cfg=new Configuration().configure("hibernatetwo.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        session = factory.getCurrentSession();
        tx=session.beginTransaction();
    }
    @After
    public void after(){
        tx.commit();;
    }
    //1类级别查询策咯
    @Test
    public  void t1(){
        Student load = session.load(Student.class, 1);
        System.out.println(load.getSname());
    }

    //一对多和多对多关联关系查询策咯
    @Test
    public  void t2(){
        Dept dept = session.get(Dept.class, 1);
        Set<Emp> emps=dept.getEmps();
        emps.size();
        for (Emp emp:emps){
            System.out.println(emp.getEmpname());
        }
    }
    //多对一关联查询策咯
    @Test
    public  void t3(){
        Emp emp = session.get(Emp.class, 1);
       emp.getDept().f();
        //System.out.println(emp.getDept());
    }
    @Test
    public  void loadGetTest(){
        HibernateBiz biz=new HibernateBiz();
        //01.获取单个员工对象
        Emp emp = (Emp)biz.get(Emp.class, 2);
        //获取员工实体中员工姓名
        System.out.println(emp.getEmpname());

    }

}
