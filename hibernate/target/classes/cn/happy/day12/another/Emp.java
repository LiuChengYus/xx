package cn.happy.day12.another;
import javax.persistence.*;
/**
 * Created by CY on 2017/12/30.
 */
//员工
@Entity
@Table(name = "EMP")
public class Emp {
    @Id
    @GeneratedValue
    private Integer empno;
    @Column
    private String empname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deptno")
    private Dept dept = new Dept();

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
