package com.accp.controller;

import com.accp.model.User;
import com.accp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("loginindex")
    public String loginindex(){
        return "login";
    }

    @RequestMapping(value="login",method= RequestMethod.POST)
    public String login(HttpServletRequest request){
        //String ref=request.getHeader("referer");
        User u=new User();
        u.setUsername(request.getParameter("username"));
        u.setPassword(request.getParameter("password"));
        u=userService.selectByUser(u);
        if(u!=null){
            request.getSession().setAttribute("sessionUser",u);
            return "redirect:/";
        }else{
            request.setAttribute("error","用户名或密码不对");
            return "login";
        }
    }

    @RequestMapping(value = "add")
    public int addUser(User user){
        return userService.addUser(user);
    }


    /*
退出
 */
    @RequestMapping("out")
    public String out(HttpServletRequest request){
        request.getSession().removeAttribute("sessionUser");
        return "redirect:/";
    }
}
