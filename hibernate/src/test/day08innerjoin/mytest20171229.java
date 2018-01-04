package day08innerjoin;

import cn.happy.day11.entity.Dept;
import cn.happy.day11.entity.Emp;
import cn.happy.day11.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by CY on 2017/12/29.
 */
public class mytest20171229 {



    //内连接 查询部门和员工
    @Test
    public  void t1(){
        Session session = HibernateUtil.getSession();
        //distinct 去重   迫切 内连接
        /*Query query = session.createQuery("select distinct d from Dept d inner join  d.emps");*/
        Query query = session.createQuery("select d from Dept d inner join fetch d.emps");
        List<Dept> list = query.list();
        for (Dept item:list){
            System.out.println(item.getDeptname());
            for (Emp it:item.getEmps()){
                System.out.println(it.getEmpname());
            }
        }
    }


    //隐式内连接   根据部门名称检索该部门下的所有员工 导航属性
    @Test
    public  void t2(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Emp e where e.dept.deptname='开发部'");
        List<Emp> list = query.list();
        for (Emp item:list){
            System.out.println(item.getEmpname());

        }
    }

    //查询所有员工工资都小于5000的部门
    @Test
    public  void t3(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Dept d where 5000>all(select e.empno from d.emps e)");
        List<Dept> list = query.list();
        for (Dept item:list){
            System.out.println(item.getDeptname());

        }
    }

}
