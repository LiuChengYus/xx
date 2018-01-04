package cn.happy.day13.user_pre_rolmoneytomoney;

import javax.persistence.*;

/**
 * Created by CY on 2018/1/3.
 */
//角色用户关系表
@Entity
@Table(name = "ru")
public class RU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ru_id", unique = true, nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "r_id")
    private R r;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private U u;

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

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }
}