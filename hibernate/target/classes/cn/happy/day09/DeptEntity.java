package cn.happy.day09;

import java.util.Collection;

/**
 * Created by CY on 2017/12/29.
 */
public class DeptEntity {
    private int deptno;
    private String deptname;
    private Collection<EmpEntity> empsByDeptno;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeptEntity that = (DeptEntity) o;

        if (deptno != that.deptno) return false;
        if (deptname != null ? !deptname.equals(that.deptname) : that.deptname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deptno;
        result = 31 * result + (deptname != null ? deptname.hashCode() : 0);
        return result;
    }

    public Collection<EmpEntity> getEmpsByDeptno() {
        return empsByDeptno;
    }

    public void setEmpsByDeptno(Collection<EmpEntity> empsByDeptno) {
        this.empsByDeptno = empsByDeptno;
    }
}
