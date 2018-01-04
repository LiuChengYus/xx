package cn.happy.day10.entity;

import javax.persistence.*;

/**
 * Created by CY on 2017/12/29.
 */
@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue//主键生成策咯木人为native
    private Integer pid;
    @Column
    private  String pname;
    @OneToOne
    @JoinColumn(name = "people")
    private Card card;

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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
