package cn.happy.day10.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    //线程变量  get set
    static  ThreadLocal<Session> tl=new ThreadLocal<Session>();
    //有SeesionFactory
    static Configuration cfg=null;
    static SessionFactory sessionFactory;
    static Transaction tx;
    static {
        cfg=new Configuration().configure("hibernatethree.cfg.xml");
         sessionFactory=cfg.buildSessionFactory();
    }
    //01.获取连接
    public static Session getSession(){
        //01.从线程变量中尝试获取
        Session session = tl.get();
        if(session==null){
            //用户第一次获取连接，发现线程变量中没有session创建一个，并放入线程变量
            session=sessionFactory.openSession();
            tl.set(session);
        }
        return session;
    }
    //02.释放连接
    public static  void close(){
        Session session = tl.get();
        if(session!=null){
            //线程变量set成null
            tl.set(null);
            session.close();
        }
    }
}
