package cn.happy.day13.u_r_p_moneytomoney;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CY on 2018/1/3.
 */
//权限表
@Entity
@Table(name = "Privile")
public class Privile {
    @Id
    @GeneratedValue
    private Integer pid;
    @Column
    private String pname;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "R_P", joinColumns = {@JoinColumn(name = "p_id")}, inverseJoinColumns = {@JoinColumn(name = "r_id")})
    private Set<Role> roles = new HashSet<Role>();

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
