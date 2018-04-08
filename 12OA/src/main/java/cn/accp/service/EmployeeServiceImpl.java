package cn.accp.service.imp;

import cn.accp.dao.IEmployeeDao;
import cn.accp.entity.Employee;
import cn.accp.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by CY on 2018/2/28.
 */
@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource(name = "IEmployeeDao")
    private IEmployeeDao employeeDao;
    public Employee login(Employee employee) {
        return employeeDao.login(employee);
    }

    public IEmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
