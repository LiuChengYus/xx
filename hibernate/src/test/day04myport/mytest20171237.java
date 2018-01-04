package day04myport;

import cn.happy.day01.util.HibernateUtil;
import cn.happy.day03.util.Tool;
import cn.happy.day04.entity.Port;
import cn.happy.day04.entity.ViewModel.XXX;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

/**
 * Created by CY on 2017/12/27.
 */
public class mytest20171237 {


    //更新4-8这条记录
    @Test
    public void updateMyPort() throws ParseException {
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Port port = session.load(Port.class, 1);
        port.setWideprice(800.0);
        port.setWidedate(Tool.setToData("2009-9-9"));
        tx.commit();
    }
    //删除这条记录
    @Test
    public void deleteMyPort() throws ParseException {
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Port port = session.get(Port.class, 1);
        session.delete(port);
        tx.commit();
    }
    //hql语句查询指定的型号的备件  输出备件编号  型号，和出光价格
    @Test
    public void selectMyPort() throws ParseException {
      String hql="from Port d where d.pid=1";
        Query query = HibernateUtil.getSession().createQuery(hql);
        List<Port> list = query.list();
        for (Port item:list){
            System.out.printf(item.getWidecode()+"|"+item.getWideprice());
        }
    }
    //查询指定价格小于的产品
    @Test
    public void selectmypory2(){
        String hql="from Port d where d.wideprice <:sum";
        Query query = HibernateUtil.getSession().createQuery(hql);
        query.setParameter("sum",900.0);
        List<Port> list = query.list();
        for (Port item:list){
            System.out.printf(item.getWidecode()+"|"+item.getWideprice());
        }
    }
    //查询指定日期范围小于的产品
    @Test
    public void selectmypory3() throws ParseException {
        XXX xxx=new XXX();
        xxx.setStarDate(Tool.setToData("2001-2-1"));
        xxx.setEndDate(Tool.setToData("2010-1-1"));
        xxx.setStarprice(100.0);
        xxx.setEndprice(900.0);
        xxx.setCode("%MA%");
        StringBuilder sb=new StringBuilder("from Port port where 1=1 ");
        if(xxx.getStarDate()!=null){
            sb.append("and port.widedate >:starDate ");
        }
        if(xxx.getEndDate()!=null){
            sb.append("and port.widedate <:endDate ");
        }
       if(xxx.getStarprice()!=null){
            sb.append("and port.wideprice >:starprice ");
        }
        if(xxx.getEndprice()!=null){
            sb.append("and port.wideprice <:endprice ");
        }
      if(xxx.getCode()!=null){
            sb.append("and port.widecode like :code ");
        }
        Query query = HibernateUtil.getSession().createQuery(sb.toString());
        query.setProperties(xxx);
        List<Port> list = query.list();
        for (Port item:list){
            System.out.printf(item.getWidecode()+"|"+item.getWideprice());
        }
    }
}
