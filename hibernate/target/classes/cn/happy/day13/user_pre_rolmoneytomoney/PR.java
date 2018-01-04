package cn.happy.day13.user_pre_rolmoneytomoney;

import javax.persistence.*;

/**
 * Created by CY on 2018/1/3.
 */
//权限角色表
@Entity
@Table(name = "pr")
public class PR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pr_id", unique = true, nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "r_id")
    private R r;
    @ManyToOne
    @JoinColumn(name = "p_id")
    private P p;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public P getP() {
        return p;
    }

    public void setP(P p) {
        this.p = p;
    }
}