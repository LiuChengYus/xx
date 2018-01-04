package cn.happy.day06.dao;


import cn.happy.day06.bean.Dept;
import cn.happy.day06.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

/**
 * Created by CY on 2017/12/27.
 */
public class DeptDaoImpl implements IDeptDao {

    private SessionFactory sessionFactory;
    public int addDept(Dept dept) {
        Session session = sessionFactory.getCurrentSession();
        Serializable save = session.save(dept);
        return (Integer)save;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
