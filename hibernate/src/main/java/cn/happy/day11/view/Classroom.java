package cn.happy.day11.view;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String className;

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private Set<Student> students=new HashSet<Student>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}

