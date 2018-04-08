package cn.happy.dao;

import cn.happy.entity.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by CY on 2018/1/5.
 */
public class DeptDaoImpl implements IDeptDao {
    private SessionFactory sessionFactory;
    public void addDept(Dept dept) {
        Session session = sessionFactory.getCurrentSession();
        session.save(dept);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
