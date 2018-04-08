package cn.tmsreception.service;

import cn.tmsreception.entity.Tms_User;

/**
 * Created by 17921 on 2017/12/6.
 */
public interface IUserService {
    //登陆
    public Tms_User isLogin(Tms_User user);
    //查询用户是否存在
    public int getUsercount(String uname);
    //修改用户
    public int upUser(Tms_User user);
}
