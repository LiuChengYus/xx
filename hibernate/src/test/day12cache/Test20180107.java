package day07cache;
import cn.hibernate.day03hqldynamic.util.HibernateUtil;
import cn.hibernate.day07cache.Dept;
import cn.hibernate.day07cache.Emp;
import com.sun.deploy.resources.Deployment_pt_BR;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;


/**
 * Created by Happy on 2017-12-24.
 */
public class Test20180107 {

    //查询缓存
    @Test
    public void t8(){
        Session session= HibernateUtil.getSession();
        String hql="from Dept d where d.deptno=1";
        Query query=session.createQuery(hql);
       query.setCacheable(true);
        List<Dept> list = query.list();
        for (Dept dept:list) {
            System.out.println(dept.getDeptname());
        }



        HibernateUtil.closeSession();
        //OK的
        System.out.println("==================");

        Session session2= HibernateUtil.getSession();

      /*  Dept dept1= session2.load(Dept.class, 1);
        System.out.println(dept1.getDeptname());*/
        Query query2=session2.createQuery(hql);
        query2.setCacheable(true);
        List<Dept> list2 = query2.list();
        for (Dept dept:list2) {
            System.out.println(dept.getDeptname());
        };
        HibernateUtil.closeSession();
    }


    //证明二级缓存Value是散装数据
    @Test
    public void t7(){
        Session session= HibernateUtil.getSession();
        //根据部门编号，查询一个确切的部门
        Dept dept=session.load(Dept.class,1);
        System.out.println(dept.getDeptname());
        HibernateUtil.closeSession();
        //OK的
        System.out.println("==================");

        Session session2= HibernateUtil.getSession();
        Dept dept2=session2.load(Dept.class,1);
        System.out.println(dept2);
        HibernateUtil.closeSession();

        System.out.println("=======================春节，我要回家，2010");
        Session session3= HibernateUtil.getSession();
        Dept dept3=session3.load(Dept.class,1);
        System.out.println(dept3);
        HibernateUtil.closeSession();
    }


    //证明二级缓存配置成功
    @Test
    public void t6(){
        Session session= HibernateUtil.getSession();
        //根据部门编号，查询一个确切的部门
        Dept dept=session.load(Dept.class,1);
        System.out.println(dept.getDeptname());
        HibernateUtil.closeSession();
     //OK的
        System.out.println("==================");

        Session session2= HibernateUtil.getSession();
        Dept dept2=session2.load(Dept.class,1);
        System.out.println(dept2.getDeptname());
        HibernateUtil.closeSession();
    }


    //3.证明iterator  N+1
    @Test
    public void t5(){
        Session session= HibernateUtil.getSession();

        String hql="from Dept";
        Query query = session.createQuery(hql);
        Iterator<Dept> iterate = query.iterate();
        while (iterate.hasNext()){
            Dept dept = iterate.next();
            System.out.println(dept.getDeptname());
        }
        System.out.println("======================");

        HibernateUtil.closeSession();
    }

    //3.证明list只可以将数据放入一缓，但是不能从一级缓存获取数据
    @Test
    public void t4(){
        Session session= HibernateUtil.getSession();

        String hql="from Dept";
        Query query = session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept dept:list) {
            System.out.println(dept.getDeptname());
        }
        System.out.println("======================");

        Iterator<Dept> iterate = query.iterate();
        while (iterate.hasNext()){
            Dept dept = iterate.next();
            System.out.println(dept.getDeptname());
        }


   /*     Dept dept = session.load(Dept.class, 1);
        System.out.println(dept.getDeptname());*/
       /* List<Dept> list2=query.list();
        for (Dept dept:list2) {
            System.out.println(dept.getDeptname());
        }*/



        HibernateUtil.closeSession();
    }

    //证明一级缓存是不能跨Session
    @Test
    public void t2(){
        Session session= HibernateUtil.getSession();
        //根据部门编号，查询一个确切的部门
        Dept dept=session.load(Dept.class,1);
        System.out.println(dept.getDeptname());
        HibernateUtil.closeSession();
        System.out.println("==================");
        Session session2= HibernateUtil.getSession();
        Dept dept2=session2.load(Dept.class,1);
        System.out.println(dept2.getDeptname());
        HibernateUtil.closeSession();
    }



    //证明一级缓存是存在的
    @Test
    public void t3(){
        Session session= HibernateUtil.getSession();
        //根据部门编号，查询一个确切的部门
        Dept dept=session.load(Dept.class,1);
        System.out.println(dept.getDeptname());
        System.out.println("==================");
        Dept dept2=session.load(Dept.class,1);
        System.out.println(dept2.getDeptname());
        HibernateUtil.closeSession();
    }
}
