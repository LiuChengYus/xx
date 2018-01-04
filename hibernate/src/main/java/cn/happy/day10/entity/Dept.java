package cn.happy.day10.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
//将一个类生命为一个持久化的类
@Entity
//为持久化类映射指定的表
@Table
public class Dept {


    /**
     *  //标识属性
     @Id
     //生成策略
     @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_gen")

     //生成器name值与generator保持一致
     @SequenceGenerator(name = "seq_gen",sequenceName = "SEQ_NUM")
     private Integer deptno;
     @Column(name = "deptname")
     */

    //标识属性
    @Id
    @GeneratedValue(generator = "seq_gen")
    @GenericGenerator(name = "seq_gen",strategy = "uuid")
    private String deptno;
    @Column(name = "deptname")
    private String deptname;

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
}
