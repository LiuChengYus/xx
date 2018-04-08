package cn.tmsreception.service.impl;

import cn.tmsreception.dao.IUserDAO;
import cn.tmsreception.entity.Tms_User;
import cn.tmsreception.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 17921 on 2017/12/6.
 */
@Service("UserService")
public class UserServiceImpl implements IUserService {

    @Resource(name = "IUserDAO")
    private IUserDAO userDAO;


    public Tms_User isLogin(Tms_User user) {
        return userDAO.isLogin(user);
    }

    public int getUsercount(String uname) {
        return userDAO.getUsercount(uname);
    }

    public int upUser(Tms_User user) {
        System.out.println(user.getUsername()+"----userimpl");
        System.out.println(user.getUserpwd()+"----userimpl");
        return userDAO.upUser(user);
    }
}
