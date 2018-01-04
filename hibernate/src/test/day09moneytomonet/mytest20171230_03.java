package day09moneytomonet;

import cn.happy.day13.moneytomoney.Student;
import cn.happy.day13.moneytomoney.Teacher;
import cn.happy.day13.u_r_p_moneytomoney.Privile;
import cn.happy.day13.u_r_p_moneytomoney.Role;
import cn.happy.day13.u_r_p_moneytomoney.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by CY on 2017/12/30.
 */
public class mytest20171230_03 {

    //注解版 多对多双向关联关系 保存 学生和老师
    @Test
    public void testannontion() {
        Configuration cdf = new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cdf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Teacher teacher1=new Teacher();
        teacher1.setTname("老远");
        Teacher teacher2=new Teacher();
        teacher2.setTname("老付");
        Teacher teacher3=new Teacher();
        teacher3.setTname("彪哥");

        Student student1=new Student();
        student1.setSname("小红");
        Student student2=new Student();
        student2.setSname("小明");
        Student student3=new Student();
        student3.setSname("小军");

        student1.getTeachers().add(teacher1);
        student1.getTeachers().add(teacher2);

        session.save(student1);


        tx.commit();
    }
    //注解版 多对多  用户   角色 权限
    @Test
    public void testannontiontwo() {
        Configuration cdf = new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cdf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Users user=new Users();
        user.setUsername("小红");

        Role role1=new Role();
        role1.setRname("教师");

        Role role2=new Role();
        role2.setRname("校长");


        Privile privile1=new Privile();
        privile1.setPname("用户管理");

        Privile privile2=new Privile();
        privile2.setPname("角色管理");

        user.getRoles().add(role1);
        user.getRoles().add(role2);

        role1.getPriviles().add(privile1);
        role1.getPriviles().add(privile2);


        session.save(user);


        tx.commit();
    }

}
