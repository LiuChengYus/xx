package cn.happy.day12.view;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Happy on 2017-09-26.
 * 工程实体
 */
public class Project {
    private Integer proid;
    private String proname;
    private  Set<ProEmp> employess=new HashSet<ProEmp>();

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

    public Set<ProEmp> getEmployess() {
        return employess;
    }

    public void setEmployess(Set<ProEmp> employess) {
        this.employess = employess;
    }
}
