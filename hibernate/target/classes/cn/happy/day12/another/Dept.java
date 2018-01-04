package cn.happy.day12.another;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by CY on 2017/12/30.
 */
//部门
@Entity
@Table(name = "DEPT")
public class Dept {
    @Id
    @GeneratedValue
    private Integer deptno;
    @Column
    private String deptname;

    //一个部门可以有多个员工
    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL)
    private Set<Emp> emps = new HashSet<Emp>();

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
