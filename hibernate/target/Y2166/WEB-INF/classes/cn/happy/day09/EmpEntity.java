package cn.happy.day09;

/**
 * Created by CY on 2017/12/29.
 */
public class EmpEntity {
    private int empno;
    private String empname;
    private Integer deptno;
    private DeptEntity deptByDeptno;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpEntity empEntity = (EmpEntity) o;

        if (empno != empEntity.empno) return false;
        if (empname != null ? !empname.equals(empEntity.empname) : empEntity.empname != null) return false;
        if (deptno != null ? !deptno.equals(empEntity.deptno) : empEntity.deptno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empno;
        result = 31 * result + (empname != null ? empname.hashCode() : 0);
        result = 31 * result + (deptno != null ? deptno.hashCode() : 0);
        return result;
    }

    public DeptEntity getDeptByDeptno() {
        return deptByDeptno;
    }

    public void setDeptByDeptno(DeptEntity deptByDeptno) {
        this.deptByDeptno = deptByDeptno;
    }
}
