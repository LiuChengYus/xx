package cn.happy.day11.view;

import javax.persistence.*;

/**
 * Created by CY on 2017/12/29.
 */
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue
    private int id;


    @Column
    private String name;


    //是否连及操作
    @ManyToOne(cascade = CascadeType.ALL)
    //从表的外键
    @JoinColumn(name = "rid")
    private Classroom room=new Classroom();



    public Classroom getRoom() {
        return room;
    }

    public void setRoom(Classroom room) {
        this.room = room;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}