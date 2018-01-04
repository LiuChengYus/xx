package day01;

import cn.happy.day02.entity.Users;
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
 * Created by CY on 2017/12/23.
 */
public class mytest2017122303 {

    Configuration cfg;
    SessionFactory factory;
    Transaction tx;
    Session session;
    @Before
    public void before(){
        cfg=new Configuration().configure("OraclelHouse.cfg.xml");
        factory = cfg.buildSessionFactory();
        session=factory.getCurrentSession();
        tx=session.beginTransaction();

    }
    @After
    public void after(){
        tx.commit();
        //session.close();
    }

    //用户增加
    @Test
    public void t1(){
        Users users=new Users();
        users.setName("小红");
        users.setPassword("1");
        users.setTelephone("1");
        users.setUsername("小红啊");
        users.setIsadmin("是");
        session.save(users);
    }
    //用户修改
    @Test
    public void t2(){
        Users users = session.get(Users.class, 1);
        users.setName("小红");
        System.out.println("前"+users);
        System.out.println("后"+users);
    }
    //删除用户
    @Test
    public void t3(){
        Users users=session.load(Users.class,1);
        session.delete(users);
    }
    //查询用户
    @Test
    public void t4(){
        String hql="from Users where id=?";
        Query query = session.createQuery(hql);
        Query query1 = query.setParameter(0, 2);
        List<Users> list = query1.list();
        for (Users item:list){
            System.out.println(item.getName());
        }
    }
    //查询用户
    @Test
    public void t5(){
        Users load = session.load(Users.class, 2);
        System.out.println(load.getName());

    }
    //修改用户
    @Test
    public void t6(){
        Users users=new Users();
        users.setId(2);
        users.setName("小明");
        users.setPassword("2");
        users.setTelephone("2");
        users.setUsername("小红啊");
        users.setIsadmin("是");
        session.saveOrUpdate(users);

    }
}
