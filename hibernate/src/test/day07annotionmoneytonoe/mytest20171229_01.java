package day07annotionmoneytonoe;

import cn.happy.day10.entity.Card;
import cn.happy.day10.entity.Dept;
import cn.happy.day10.entity.People;
import cn.happy.day10.util.HibernateUtil;
import cn.happy.day11.view.Classroom;
import cn.happy.day11.view.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by CY on 2017/12/29.
 */
public class mytest20171229_01 {


    //添加部门(不使用主键生成策咯)
    @Test
    public  void t1(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Dept dept=new Dept();
        dept.setDeptname("邪恶不2");
        session.save(dept);
        tx.commit();

    }

    //注解开发之 一对一身份证 和 人连及添加
    @Test
    public  void t2(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Card card=new Card();
        card.setCnum("2375196");
        People people=new People();
        people.setPname("小贱贱");
        card.setPeople(people);
        people.setCard(card);
        session.save(card);
        tx.commit();

    }

    //注解开发之 添加教师的同时添加学生 多对一
    @Test
    public  void t3(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();

        Classroom classroom=new Classroom();
        classroom.setClassName("四机房");

        Student student=new Student();
        student.setName("小明");

        classroom.getStudents().add(student);
        student.setRoom(classroom);

        session.save(classroom);
        tx.commit();

    }
}
