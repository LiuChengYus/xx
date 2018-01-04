package cn.happy.day05.entity;

import java.util.*;


public class Dept {
     private Integer deptno;
     private String deptname;
    private Set<Emp> emps=new HashSet<Emp>();
     public void f(){

     }
    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }
}
