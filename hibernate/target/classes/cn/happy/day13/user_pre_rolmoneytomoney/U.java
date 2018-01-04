package cn.happy.day13.user_pre_rolmoneytomoney;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CY on 2018/1/3.
 */
//用户表
@Entity
@Table(name = "u")
public class U {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id", unique = true, nullable = false)
    private Integer id;
    @OneToMany(mappedBy = "u",cascade=CascadeType.ALL)
    private Set<RU> ru = new HashSet<RU>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<RU> getRu() {
        return ru;
    }

    public void setRu(Set<RU> ru) {
        this.ru = ru;
    }
}