package cn.tms.entity;

/**
 * Created by CY on 2017/11/19.
 */
public class Role {

        private Integer rid;// 编号
        private String rolename;// 角色名称

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
