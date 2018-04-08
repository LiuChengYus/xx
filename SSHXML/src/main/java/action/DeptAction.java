package cn.happy.action;

import cn.happy.entity.Dept;
import cn.happy.service.IDeptService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by CY on 2018/1/5.
 */
public class DeptAction extends ActionSupport {
    private Dept dept;
    private IDeptService deptService;
    public  String add(){
        deptService.addDept(dept);
        return SUCCESS;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public IDeptService getDeptService() {
        return deptService;
    }

    public void setDeptService(IDeptService deptService) {
        this.deptService = deptService;
    }
}
