package day03hql;
import cn.happy.day01.util.HibernateUtil;
import cn.happy.day03.entity.Dept;
import cn.happy.day03.entity.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import java.util.List;
public class myTest201726_02 {

    //分页假象测试HibernateUtil工具类的关闭session方法是否起了作用
    @Test
    public void selectRows(){
        Session session=HibernateUtil.getSession();
        String hql="from Emp as d order by d.empno";
        Query query = session.createQuery(hql);
        int index=1;
        int size=3;
        query.setFetchSize((index-1)*size);
        query.setMaxResults(size);
        List<Emp> list = query.list();
        ///session.close();
        for (Emp item:list){
            System.out.println(item.getEname());
        }
        HibernateUtil.closeSession();
    }

    //分页
    @Test
    public void selectRow(){
        String hql="from Emp d order by d.empno";
        Query query = HibernateUtil.getSession().createQuery(hql);
        int index=1;
        int size=3;
        query.setFetchSize((index-1)*size);
        query.setMaxResults(size);
        List<Emp> list = query.list();
        for (Emp item:list){
            System.out.println(item.getEname());
        }
    }
    //构造查询强类型的获取部分列 多列 List<强类型>
    @Test
    public  void Strongtype(){
        Session session;
        //language=CoffeeScript
        String hql="select new Dept(d.deptno,d.dname,d.loc) from Dept d";
        session= HibernateUtil.getSession();
        Query query = session.createQuery(hql);
        List<Dept> list = query.list();
        for (Dept item:list){
            System.out.println(item.getDname());
        }
    }

}
