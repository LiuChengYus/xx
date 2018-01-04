package day09moneytomonet;
import cn.happy.day12.entity.Employee;
import cn.happy.day12.entity.Project;
import cn.happy.day12.view.ProEmp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Set;

/**
 * Created by CY on 2017/12/30.
 */
public class mytest20171230_01 {


    //保存员工的同时保存项目
    @Test
    public  void t1(){
        Configuration cdf=new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory=cdf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx=session.beginTransaction();

        Employee employee=new Employee();
        employee.setEmpname("张三");

        //项目对象
        Project project1=new Project();
        project1.setProname("项目1");

        Project project2=new Project();
        project2.setProname("项目2");

        employee.getProjects().add(project1);
        employee.getProjects().add(project2);
        session.saveOrUpdate(employee);

        tx.commit();
    }
   //延迟加载 1.类级别查询策咯
    @Test
    public  void t2(){
        Configuration cdf=new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory=cdf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        Employee emp = session.load(Employee.class, 20);
        System.out.println(emp);
        tx.commit();
    }


    //查询所有员工对应的项目
    @Test
    public  void t3(){
        Configuration cdf=new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory=cdf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Employee emp = session.load(Employee.class, 20);
        Set<Project> projects = emp.getProjects();
        System.out.println(projects.size());
    }




}
