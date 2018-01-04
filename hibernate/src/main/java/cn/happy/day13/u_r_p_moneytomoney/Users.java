package cn.happy.day13.u_r_p_moneytomoney;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CY on 2018/1/3.
 */
//用户表
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue
    private Integer userid;
    @Column
    private String username;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "U_R",joinColumns = {@JoinColumn(name = "u_id")},inverseJoinColumns = {@JoinColumn(name = "r_id")})
    private Set<Role> roles=new HashSet<Role>();

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
