package cn.happy.day17cache;

/**
 * Created by Happy on 2017-12-27.
 */
//员工实体
public class Emp{
    private Integer empno;
    private String empname;
    //植入部门单个对象
    private Dept dept;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
