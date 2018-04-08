package cn.happy.action;

import cn.happy.entity.UserInfo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by CY on 2018/1/3.
 */
public class UserAction implements Action ,ModelDriven<UserInfo>{
    private UserInfo userInfo=new UserInfo();

    //五个静态常量 success none input login error
    public String execute() throws Exception {

        /*System.out.println(username);*/
        if("admin".equals(userInfo.getUsername())&&"admin".equals(userInfo.getPassword())){
            //login success
            return SUCCESS;
        }else {
            return INPUT;
        }

    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getModel() {
        return userInfo;
    }
}
