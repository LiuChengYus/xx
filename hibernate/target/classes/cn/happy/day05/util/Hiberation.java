package cn.happy.day05.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by CY on 2017/12/27.
 */
public class Hiberation {
    static  ThreadLocal<Session> tl=new ThreadLocal<Session>();
    static Configuration cfg;
    static SessionFactory factory;
    static {
        cfg=new Configuration().configure();
        factory=cfg.buildSessionFactory();
    }

    public static  Session getSession(){
        Session session = tl.get();
        if(session==null){
            session=factory.openSession();
            tl.set(session);
        }
        return session;
    }
    public  static void close(){
        Session session = tl.get();
        if (session!=null){
            tl.set(null);
            session.close();
        }
    }
}
