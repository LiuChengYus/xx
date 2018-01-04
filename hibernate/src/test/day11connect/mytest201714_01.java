package day11connect;

import cn.happy.day12.another.Dept;
import cn.happy.day13.entity.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * Created by CY on 2018/1/4.
 */
public class mytest201714_01 {
    //查询部门和员工
    @Test
    public  void t1(){
        Configuration cfg=new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        String hql="from Emp e inner join e.dept";
        Query query = session.createQuery(hql);
        //数据形态
        List<Object[]> list = query.list();
        for (Object[] item:list){
            System.out.println(item[0]);
            System.out.println(item[1]);
        }
        tx.commit();
    }


    //隐式内连接  查询某个指定部门中所有的  员工集合
    @Test
    public  void t2(){
        Configuration cfg=new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        String hq="from Emp e where e.dept.deptname='开发部'";
        String  hq1="from emp e,dept d where e.empno=d.deptno";
        String hq2="from emp e inner join e.dept ";
        //三表联查
        String h="from b b1 left join a a1 on a1=b1.a left join c c1 on c1.b=bb";

        Query query = session.createQuery(hq);
        //数据形态
        List<Object[]> list = query.list();
        for (Object[] item:list){
            System.out.println(item[0]);
            System.out.println(item[1]);
        }
        tx.commit();
    }


    //迫切内连接 可以将集合投影成强类型
    @Test
    public  void t3(){
        Configuration cfg=new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        String hql="from Emp e inner join fetch e.dept";
        Query query = session.createQuery(hql);
        //数据形态
        List<Object[]> list = query.list();
        for (Object[] item:list){
            System.out.println(item[0]);
            System.out.println(item[1]);
        }
        tx.commit();
    }


    //子查询  查询所有员工工资<5000的部门名称
    @Test
    public  void t4(){
        Configuration cfg=new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        String hql="from Dept d where 5000>all(select e.empno from d.emps e)";
        Query query = session.createQuery(hql);
        List<Dept> list = query.list();
        for (Dept item:list){
            System.out.println(item.getDeptname());
        }
        tx.commit();
    }

    //相关子查询 执行顺序是从外到里 小可号里面的查询不能单独执行
    @Test
    public  void t5(){
        Configuration cfg=new Configuration().configure("hibernatethree.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        String hql="from Book b where b.bookprice>(select avg(b.bookprice) from b where b.bookid=b.bookid )";
        Query query = session.createQuery(hql);
        List<Book> list = query.list();
        for (Book item:list){
            System.out.println(item.getBookname());
        }
        tx.commit();
    }
}
