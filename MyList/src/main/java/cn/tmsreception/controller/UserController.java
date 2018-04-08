package cn.tmsreception.controller;

import cn.tmsreception.dao.IWeekVentoryDAO;
import cn.tmsreception.entity.Column;
import cn.tmsreception.entity.News;
import cn.tmsreception.entity.PortInfo;
import cn.tmsreception.entity.Tms_User;
import cn.tmsreception.service.*;
import cn.tmsreception.util.EmailUtil;
import cn.tmsreception.util.PhoneUtil;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17921 on 2017/12/6.
 */
@Controller
public class UserController {
    @Resource(name = "UserService")
    private IUserService userService;

    @Resource(name = "ColumnService")
    private IColumnService columnService;

    @Resource(name = "PortInfoService")
    private IPortInfoService portInfoService;



    @Resource(name = "newsService")
    private INewsService newsService;
    //获取验证码
    @RequestMapping("/getnum")
    @ResponseBody
    public String getunum(String vs,String fotgetname,HttpSession session) throws MessagingException, ClientException, InterruptedException {
        if (vs=="2" || "2".equals(vs)){
            int getnum = EmailUtil.getnum(fotgetname);
            session.setAttribute("unum",getnum);
            return "true";
        }else if (vs=="1" || "1".equals(vs)){
            int getnum = PhoneUtil.getnum(fotgetname);
            session.setAttribute("unum",getnum);
            return "true";
        }
        return "false";
    }

    //忘记密码(修改密码)
    @RequestMapping("/forgetpassword")
    @ResponseBody
    public Object forgetpassword(Tms_User user,String vs,String unum,HttpSession session){
        //判断用户是否存在
        int usercount = userService.getUsercount(user.getUsername());
        if(usercount<=0){//不存在
            return "0";
        }else {
            Integer getnum = (Integer)session.getAttribute("unum");
            Integer unum1 = Integer.parseInt(unum);
            if(getnum.equals(unum1) || unum1==getnum){
                int i = userService.upUser(user);
                if (i>0){
                    return "1";
                }
            }

        }
        return  "0";
    }
    //跳转到找回密码页面
    @RequestMapping("/jumpforget")
    public String jumpforget(){
        return "/forgot-pass.jsp";
    }

    //登陆
    @RequestMapping("/login")
    public String isLogin(Tms_User user, Model model,HttpSession session){
        Tms_User login = userService.isLogin(user);
        if (login != null && login.getUsername() != null) {
            List<Column> columnList = columnService.getColumn();
            //新的容器 保存有父子关系的权限
            List<Column> rootMenus = new ArrayList<Column>();

            //将平级的权限  变成  有层级关系的权限集合

            for (Column item : columnList) {
                Column childMenu = item;
                String code=childMenu.getParentcode();
                if (code.equals("0")) {
                    rootMenus.add(item);
                } else {
                    for (Column innerMenu : columnList) {
                        String code1=innerMenu.getSyscode();

                        if (code1.equals(code)) {
                            Column parentMenu = innerMenu;
                            parentMenu.getChildren().add(childMenu);
                            break;
                        }
                    }
                }
            }
            List<News> newslist = newsService.findAllNewsbycode();
            List<PortInfo> portInfos = portInfoService.findallPort();
            session.setAttribute("newslist",newslist);
            session.setAttribute("rootMenus",rootMenus);
            session.setAttribute("userinfo", login);
            session.setAttribute("portInfo",portInfos);
            return "/index.jsp";
        } else {
            return "/login.jsp";
        }

    }


}
