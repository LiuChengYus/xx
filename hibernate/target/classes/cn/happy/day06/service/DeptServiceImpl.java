package cn.happy.day06.service;

import cn.happy.day06.bean.Dept;
import cn.happy.day06.dao.IDeptDao;
import cn.happy.day06.util.HibernateUtil;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CY on 2017/12/27.
 */
public class DeptServiceImpl implements IDeptService {
    private IDeptDao deptDao;
    @Transactional
    public int addDept(Dept dept) {
        Transaction tx= HibernateUtil.getSession().beginTransaction();
        int result=deptDao.addDept(dept);
        tx.commit();
        return result;
    }

    public IDeptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(IDeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
