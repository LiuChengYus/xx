package cn.tms.util;

import cn.tms.dao.IPrivilegeUserDao;
import cn.tms.entity.Privilege;
import cn.tms.entity.UserInfo;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.List;

/**
 * Created by CY on 2017/11/24.
 */
public class AuthorizeTag extends BodyTagSupport {

    private IPrivilegeUserDao privilegeUserDao;
    private String URL;

    public IPrivilegeUserDao getPrivilegeUserDao() {
        return privilegeUserDao;
    }

    public void setPrivilegeUserDao(IPrivilegeUserDao privilegeUserDao) {
        this.privilegeUserDao = privilegeUserDao;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public int doStartTag() throws JspException {
        if(null!=URL){
            getUserDao();
            HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
            UserInfo info=(UserInfo)request.getSession().getAttribute("userinfo");
            List<Privilege> list=privilegeUserDao.findAllPrivilegeByUserId(info.getUserid());
            System.out.println(list.size());
            System.out.println("执行jstl标签");
            for (Privilege item:list) {
                System.out.println("该角色所拥有的url"+item.getUrl());
                if(item.getUrl().equals(URL)){
                    System.out.println("url匹配正确"+item.getUrl());
                    //正确渲染该标签
                    return  EVAL_BODY_INCLUDE;
                }
            }

        }
        return  this.SKIP_BODY;
    }


    public void getUserDao(){
        WebApplicationContext applicationContext= WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
        privilegeUserDao=(IPrivilegeUserDao)applicationContext.getBean(IPrivilegeUserDao.class);
    }
}
