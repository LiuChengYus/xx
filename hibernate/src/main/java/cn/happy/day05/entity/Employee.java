package cn.happy.day05.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CY on 2017/12/27.
 */
public class Employee {
    private  Integer empid;
    private  String  empname;
    private Set<Project> projects=new HashSet<Project>();

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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
