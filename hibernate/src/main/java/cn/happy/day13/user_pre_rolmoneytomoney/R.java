package cn.happy.day13.user_pre_rolmoneytomoney;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CY on 2018/1/3.
 */
//角色表
@Entity
@Table(name = "r")
public class R {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id", unique = true, nullable = false)
    private Integer id;
    @OneToMany(mappedBy = "r",cascade=CascadeType.ALL)
    private Set<PR> pr = new HashSet<PR>();
    @OneToMany(mappedBy = "r",cascade=CascadeType.ALL)
    private Set<RU> ru = new HashSet<RU>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<PR> getPr() {
        return pr;
    }

    public void setPr(Set<PR> pr) {
        this.pr = pr;
    }

    public Set<RU> getRu() {
        return ru;
    }

    public void setRu(Set<RU> ru) {
        this.ru = ru;
    }
}