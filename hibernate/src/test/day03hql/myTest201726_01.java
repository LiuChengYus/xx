package day03hql;
import cn.happy.day03.entity.Dept;
import cn.happy.day03.entity.Emp;
import cn.happy.day03.entity.ViewModel.EmpCondition;
import cn.happy.day03.entity.ViewModel.ModelDept;
import cn.happy.day03.util.Tool;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
public class myTest201726_01 {
    Configuration cfg;
    SessionFactory factory;
    Transaction tx;
    Session session;
    @Before
    public void before(){
        cfg=new Configuration().configure("hibernateday2.cfg.xml");
        factory=cfg.buildSessionFactory();
        session=factory.getCurrentSession();
        tx=session.beginTransaction();
    }
    @After
    public void after(){
        tx.commit();
    }

    //检索部分列01
    @Test
    public void t1(){
        String hql="select d.dname,d.deptno from Dept d";
        List<Object[]> list = session.createQuery(hql).list();
        for (Object[] it:list){
            for (Object item:it){
                System.out.println(item);
            }
        }
    }
    //检索部分列02
    @Test
    public void t2(){
        String hql="select d.dname from Dept d";
        List<String> list = session.createQuery(hql).list();
        for (String item:list){
            System.out.println(item);
        }
    }
   //参数化查询01 方案一？匿名站位
    @Test
    public void t3(){
        String hql=" from Dept d where d.dname=? ";
        Query query = session.createQuery(hql);
        query.setParameter(0,"SALES");
        List<Dept> list = query.list();
        for (Dept item:list){
            System.out.println(item.getDname());
        }

    }
    //参数化查询02 ：name参数名称绑定
    @Test
    public void t4(){
        //部门名称为SALES的部门信息
        //language=HQL
        String hql=" from Dept d where d.dname=:dname";
        Query query = session.createQuery(hql);
        query.setParameter("dname","SALES");
        List<Dept> list = query.list();
        for (Dept item:list){
            System.out.println(item.getDname());
        }
    }
    //参数化查询03
    @Test
    public void t5(){
        //部门名称为SALES的部门信息
        String hql="from Dept d where d.dname=:dname and d.loc=:loc";
        Query query = session.createQuery(hql);
        ModelDept modelDept=new ModelDept();
        //试图Model  ViewModel 因为:ui层
        modelDept.setDname("SALES");
        modelDept.setLoc("CHICAGO");
        query.setProperties(modelDept);
        List<Dept> list = query.list();
        for (Dept item:list){
            System.out.println(item.getDname());
        }
    }
   //动态查询04:方案三:name参数名称绑定++++对象属性
    @Test
    public void t6() throws ParseException {
        EmpCondition empCondition=new EmpCondition();
        //伪造界面Condition
        //试图mmodel
        empCondition.setJob("CLERK");
        empCondition.setSal(1000.0);
        empCondition.setFromDate(Tool.setToData("1987-1-2"));
        empCondition.setEndDate(new Date());
        //根据条件拼接SQl
        StringBuilder sb=new StringBuilder("from Emp e where 1=1 ");
        if(empCondition.getJob()!=null){
            sb.append("and e.job =:job " );
        }
        if(empCondition.getFromDate()!=null){
            sb.append("and e.hiredate >=:fromDate " );
        }

        if(empCondition.getEndDate()!=null){
            sb.append("and e.hiredate <=:endDate " );
        }

        Query query = session.createQuery(sb.toString());
        query.setProperties(empCondition);
        List<Emp> list = query.list();
        for (Emp item:list){
            System.out.println(item.getEname());
        }

    }

}
