package day06moneytonoe;

import cn.happy.day07.entity.Dept;
import cn.happy.day07.util.HibernateUtil;
import cn.happy.day07.entity.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import java.util.List;

/**
 * Created by CY on 2017/12/28.
 */
public class mytest20171228_01 {


    //关联查询  多对一单项关联1
    @Test
    public void testmoneytonoebydouble(){
        //工具类
        Session session = HibernateUtil.getSession();
        //提供一个员工的编号
        Emp load = session.load(Emp.class, 1);
        System.out.println(load.getEmpname());
        //隶属的部门
        System.out.println(load.getDept().getDeptname());

    }
    //保存部门的同时保存员工2
    @Test
    public  void savedeptandEmp(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();

        Dept dept=new Dept();
        dept.setDeptname("测试部2");

        Emp emp=new Emp();
        emp.setEmpname("小军3");

        dept.getEmps().add(emp);
        session.save(dept);
        tx.commit();
    }

    @Test
    //按照指定的部门对象，查询相关的emp对象
    public void t3() {
        Session session = HibernateUtil.getSession();
        String hql = "from Emp e where e.dept.deptno=1";
        Query query = session.createQuery(hql);
        List<Emp> list = query.list();
        for (Emp item : list) {
            System.out.println(item.getEmpname());
        }
        session.close();
    }

    //修改修改员工的同时修改部门 使用级联 caseode  和inversit
    @Test
    public void updatedept(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Dept dept=new Dept();
        dept.setDeptno(2);
        dept.setDeptname("小买部1");

        Emp emp=new Emp();
        emp.setEmpno(1);
        emp.setEmpname("小贱贱1");
        dept.getEmps().add(emp);
        session.saveOrUpdate(dept);
        tx.commit();


    }
    //04.输出指定的emps集合中的所有emp对象及其所关联的部门对象的信息
    @Test
    public void t4(){
        Session session=HibernateUtil.getSession();
        String hql="from Emp";
        Query query = session.createQuery(hql);
        List<Emp> list = query.list();
        //输出部门信息
        for (Emp item : list) {
            System.out.println("部门名称："+item.getDept().getDeptname());
            System.out.println(item.getEmpname());
        }
        session.close();
    }

    //一对多双向关联（1.2双向遍历）4
    @Test
    public void onetomoneydouble(){
        //检索部门的同时检索出员工
        String hql="from Dept";
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery(hql);
        List<Dept> list = query.list();
        for (Dept item:list) {
            System.out.println(item.getDeptname());
            for (Emp it:item.getEmps()) {
                System.out.println(it.getEmpname());
            }
        }


        //检索出员工的同时检索出部门
        Emp emp = session.get(Emp.class, 2);
        System.out.println(emp.getDept().getDeptname()+"HH");

    }
}
