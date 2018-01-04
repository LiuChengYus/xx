package cn.happy.day05.entity;
import javax.persistence.Entity;
public class Student {
    private  Integer sid;
    private  String sname;
    private  Integer sage;

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }


}
