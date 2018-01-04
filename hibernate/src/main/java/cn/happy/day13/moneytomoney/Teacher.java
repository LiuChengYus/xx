package cn.happy.day13.moneytomoney;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CY on 2018/1/2.
 */
@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue
    private Integer tid;
    @Column
    private String tname;

    @ManyToMany
    @Cascade(value = {CascadeType.ALL})
    @JoinTable(name = "S_T",joinColumns={@JoinColumn(name = "Teid")},inverseJoinColumns ={@JoinColumn(name = "stuid")} )
    private Set<Student> students=new HashSet<Student>();

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
