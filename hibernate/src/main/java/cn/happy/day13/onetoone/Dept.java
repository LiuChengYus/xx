package cn.happy.day13.onetoone;

import javax.persistence.*;

/**
 * Created by CY on 2018/1/2.
 */
@Entity
@Table(name = "DEPT3")
public class Dept {
    @Id
    @GeneratedValue
    private Integer deptno;
    @Column
    private String deptname;
    @OneToOne(mappedBy = "dept",cascade = CascadeType.ALL)
     private Emp emp;

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

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }
}
