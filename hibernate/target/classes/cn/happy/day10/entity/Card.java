package cn.happy.day10.entity;


import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue
    private Integer cid;
    @Column
    private String cnum;
    /**
     * mappedBy:属性
     在对方的实体中植入自身类型的属性名
     含义:交给card属性所在类型的实体进行关联关系的维护,相当于xml配置中的inverse=true
     不干预底层SQL的生成
     */
    @OneToOne(mappedBy = "card",cascade =CascadeType.ALL)
    private People people;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
