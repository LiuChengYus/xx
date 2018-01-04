package cn.happy.day13.u_r_p_moneytomoney;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CY on 2018/1/3.
 */
//角色表
@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue
    private Integer rid;
    @Column
    private String rname;

    @ManyToMany
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "U_R",joinColumns = {@JoinColumn(name="r_id")},inverseJoinColumns = {@JoinColumn(name = "u_id")})
    private Set<Users> users=new HashSet<Users>();


    @ManyToMany()
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "R_P",joinColumns = {@JoinColumn(name="r_id")},inverseJoinColumns = {@JoinColumn(name = "p_id")})
    private Set<Privile> priviles=new HashSet<Privile>();

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public Set<Privile> getPriviles() {
        return priviles;
    }

    public void setPriviles(Set<Privile> priviles) {
        this.priviles = priviles;
    }
}
