package cn.happy.day12.view;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Happy on 2017-09-26.
 */
//员工实体
public class Employee {
    private Integer empid;
    private String empname;
    private  Set<ProEmp>  projects=new HashSet<ProEmp>();

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Set<ProEmp> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProEmp> projects) {
        this.projects = projects;
    }
}
