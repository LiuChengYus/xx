package cn.happy.day13.onetomoney;

import javax.persistence.*;

/**
 * Created by CY on 2018/1/2.
 */
@Entity
@Table(name = "EMP3")
public class Emp {
    @Id
    @GeneratedValue
    private Integer empno;
    @Column
    private String  empname;
    @ManyToOne(cascade = CascadeType.ALL,fetch =FetchType.LAZY )
    @JoinColumn(name = "deptno")
    private Dept dept=new Dept();

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
