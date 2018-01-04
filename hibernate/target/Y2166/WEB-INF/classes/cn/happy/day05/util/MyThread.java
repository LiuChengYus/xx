package cn.happy.day05.util;

import org.hibernate.Session;

/**
 * Created by CY on 2017/12/27.
 */
public class MyThread  extends Thread {
    @Override
    public void run() {
        Session session = HibernateUtil.getSession();
        Session session2 = HibernateUtil.getSession();
        System.out.println("子线程==1=="+session.hashCode());
        System.out.println("子线程==2=="+session2.hashCode());
    }
}
