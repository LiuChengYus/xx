package cn.happy.day13.moneytomoney;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by CY on 2018/1/2.
 */
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue
    private Integer sid;
    @Column
    private String sname;

    @ManyToMany
    @Cascade(value = {CascadeType.ALL})
    @JoinTable(name = "S_T",joinColumns={@JoinColumn(name = "stuid")},inverseJoinColumns ={@JoinColumn(name = "Teid")} )
    private Set<Teacher> teachers=new HashSet<Teacher>();

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
