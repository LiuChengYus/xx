package cn.happy.day01.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by CY on 2017/12/23.
 */
public class HibernateUtil {
    private static ThreadLocal<Session> tl=new ThreadLocal<Session>();
    private static Configuration cfg;
    private static SessionFactory sessionFactory;
    static {
        cfg=new Configuration().configure();
        sessionFactory=cfg.buildSessionFactory();
    }
    public static  Session getSession(){
        Session session=tl.get();
        if(session==null){
             session = sessionFactory.openSession();
           tl.set(session);
        }
        return session;
    }
    public static void closeSession(){
        Session session = (Session) tl.get();
        tl.set(null);
        session.close();
    }
}
