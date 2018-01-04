package day01;

import cn.happy.day01.entity.Dog;
import cn.happy.day01.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by CY on 2017/12/23.
 */
public class test20171223 {

    Session session;
    Transaction tx;
    @Test
    public void t1(){

        //操作
        Student student=new Student();
        student.setSname("小红");
        student.setSage(12);
        student.setSid(1);
        //真正添加
        session.save(student);
        //提交或者后滚事务
        tx.commit();
        //7.关闭连接
        session.close();

    }

    @Before
    public void before(){
        Configuration cfg=new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
         session = factory.getCurrentSession();
         tx=session.beginTransaction();
    }

    //修改第一种
    @Test
    public void t2(){
        Student student = session.get(Student.class, 1);
        student.setSname("小康");
    }

    //修改第二种
    @Test
    public void t3(){
        Student student=new Student();
        student.setSname("小发");
        student.setSage(12);
        student.setSid(1);
        session.update(student);
    }

    @Test
    public void t4(){
        Dog dog = session.get(Dog.class, "2c9b4781608298cb01608298cf210000");

    }

    @After
    public void after(){
        tx.commit();;
        session.clear();
        session.close();
    }
}
