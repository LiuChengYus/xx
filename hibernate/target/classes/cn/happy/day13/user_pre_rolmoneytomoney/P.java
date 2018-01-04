package cn.happy.day13.user_pre_rolmoneytomoney;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CY on 2018/1/3.
 */
//权限表
@Table(name = "p")
public class P {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id", unique = true, nullable = false)
    private Integer id;
    @OneToMany(mappedBy = "p",cascade=CascadeType.ALL)
    private Set<PR> pr = new HashSet<PR>();

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
}