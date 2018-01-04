package cn.happy.day05.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CY on 2017/12/27.
 */
public class Project {
    private Integer proid;
    private String  proname;
    private Set<Employee> employees=new HashSet<Employee>();

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
