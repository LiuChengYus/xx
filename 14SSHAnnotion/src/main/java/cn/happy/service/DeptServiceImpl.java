package cn.happy.service;

import cn.happy.entity.Dept;
import cn.happy.dao.IDeptDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CY on 2018/1/5.
 */
public class DeptServiceImpl implements IDeptService {
    private IDeptDao deptDao;

    @Transactional
    public void addDept(Dept dept) {
         deptDao.addDept(dept);
    }

    public IDeptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(IDeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
