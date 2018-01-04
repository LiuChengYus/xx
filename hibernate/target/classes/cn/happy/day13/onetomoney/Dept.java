package cn.happy.day13.onetomoney;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private String  deptname;
    @OneToMany(mappedBy = "dept",cascade = CascadeType.ALL)
    private Set<Emp> emps=new HashSet<Emp>();

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
