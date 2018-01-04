package day01;

import cn.happy.day01.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * Created by CY on 2017/12/20.
 */
public class mytest {
    Configuration cfg;
    Session session;
    Transaction tx;
    SessionFactory factory;

    @Before
    public void myBefore(){
        //创建配置对象
        cfg=new Configuration().configure();
        //根据配置对象创建SessionFactory
        factory=cfg.buildSessionFactory();
        //根据SessionFactory去创建Session
        session=factory.getCurrentSession();
        //在Session创建后开启事务
        tx=session.beginTransaction();
    }

    //创建dog表对象
    @Test
    public void test01()throws Exception{
        //Configuration
        Configuration cfg=new Configuration().configure();
        //session对象
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        session.close();
    }
    //添加数据
    @Test
    public void test02() throws Exception{
        Dog dog=new Dog();
        dog.setDogName("小黄狗");
        dog.setDogAge(12);
        session.save(dog);
        tx.commit();
        session.clear();
    }
    //添加数据
    @Test
    public void test03() throws Exception{
        Configuration cfg=new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx=session.beginTransaction();

        Dog dog=new Dog();
        dog.setDogName("小红");
        dog.setDogAge(12);
        session.merge(dog);
        tx.commit();
        session.close();



    }

    //修改数据
    @Test
    public void test04() throws Exception{
        //修改一个编号为2的信息
        Dog dog=new Dog();
        //dog.setDogId(1);
        dog.setDogName("今天天气不错");
        dog.setDogAge(12);
        session.update(dog);
        tx.commit();
        session.close();
        System.out.println("修改成功");
    }

    //查询数据
    /*@Test
    public void test05() throws Exception{
        String hql="from Dog";
        Query query =session.createQuery(hql);
        List<Dog> list = query.list();
        for (Dog item:list){
            System.out.println(item.getDogName());
        }
    }
*/
    //参数查询 方案一?匿名占位符
   /* @Test
    public void test06() throws Exception{
        String hql="from Dog where DOGNAME=?";
        Query query =session.createQuery(hql);
        query.setParameter(0,"今天天气不错");
        List<Dog> list = query.list();
        for (Dog item:list){
            System.out.println(item.getDogName());
        }
    }*/
}
