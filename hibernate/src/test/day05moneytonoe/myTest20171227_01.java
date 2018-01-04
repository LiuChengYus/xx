package day05moneytonoe;

import cn.happy.day05.entity.Dept;
import cn.happy.day05.entity.Employee;
import cn.happy.day05.entity.Project;
import cn.happy.day05.util.HibernateUtil;
import cn.happy.day05.entity.Emp;
import cn.happy.day05.util.MyThread;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


import java.util.List;

public class myTest20171227_01 {

    //01.关联查询,多对一单项
    @Test
    public void testMoneytoIneSingle(){
        //提供一个员工的编号
        Session session = HibernateUtil.getSession();
        Emp emp = session.get(Emp.class, 1);
        System.out.println(emp.getEmpname());
        System.out.println(emp.getDept().getDeptname());
    }
    //01.关联查询,多对一单项2
    @Test
    public void testMoneytoIneSingle2(){
        //提供一个员工的编号
        Session session = HibernateUtil.getSession();
        String hql="from Emp where empno=1";
        Query query = session.createQuery(hql);
        List<Emp> list = query.list();
        System.out.println(list.get(0).getEmpname());
        System.out.println(list.get(0).getDept().getDeptname());
    }

    //判断同意Ession是不是在相同的线程内
    @Test
    public  void testSesion(){
        Session session;
        Configuration cfg=new Configuration().configure();
        SessionFactory factory=cfg.buildSessionFactory();
        session= HibernateUtil.getSession();
        Session session1 = HibernateUtil.getSession();
        System.out.println(session);
        System.out.println(session1);
    }

    //线程测试
    @Test
    public void t1(){
        MyThread t1=new MyThread();
        t1.start();
        Session session = HibernateUtil.getSession();
        System.out.println("主线程==1=="+session.hashCode());
        Session session2 = HibernateUtil.getSession();
        System.out.println("主线程==2=="+session.hashCode());
    }

    //一对多双向关联
    @Test
    public  void testOneToMonetDouble(){
        Session session= HibernateUtil.getSession();
        List<Dept> list = session.createQuery("from Dept").list();
        for (Dept item:list){
            System.out.println(item.getDeptname());
            for (Emp it:item.getEmps()){
                System.out.println(it.getEmpname());
            }
        }

    }
    //保存部门的同时保存员工
    @Test
    public  void saveDeptAndEmp(){
        Session session= HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();

        Dept dept=new Dept();
        dept.setDeptname("财务部");

        Emp emp=new Emp();
        emp.setEmpname("小军");
        emp.setDept(dept);
        dept.getEmps().add(emp);
        session.save(dept);
        tx.commit();

    }
    //检索 指定部门下的所欲员工集合,打印输出(HQL连缀写法)
    @Test
    public  void testPrintEmpByNO(){
        Session session= HibernateUtil.getSession();
      /*  List<Emp> list = session.createQuery("from Emp emp where emp.dept.deptno=1").list();
        for (Emp item:list){
            System.out.println(item.getEmpname()+""+item.getDept().getDeptname());

        }*/
        Dept dept = session.get(Dept.class, 1);
        for (Emp item:dept.getEmps()){
            System.out.println(item.getEmpname());
        }

    }
    //多对多双向关联(检索特定员工参与所有工程名称)
    @Test
    public  void testPrintEmpNO(){
        Session session= HibernateUtil.getSession();
        Employee employee = session.get(Employee.class, 1);
        System.out.println(employee.getEmpname());
        for (Project item:employee.getProjects()){
            System.out.println(item.getProname());
        }

    }

    //多对多双向关联添加
    @Test
    public  void addTest(){
        //雇员1
        Employee employee=new Employee();
        employee.setEmpname("张三");


        //雇员2
        Employee employee2=new Employee();
        employee2.setEmpname("李四");
        //项目对象
        Project project=new Project();
        project.setProname("小鲜蘑菇");
        project.getEmployees().add(employee);
        project.getEmployees().add(employee2);
        Session session= HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        session.save(project);
        tx.commit();

    }
}
