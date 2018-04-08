package cn.accp.contoller;

import cn.accp.entity.Employee;
import cn.accp.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by CY on 2018/2/28.
 */
@Controller
@RequestMapping("/user")
public class UserContoller  {
    @Resource(name = "employeeService")
    private EmployeeService employeeService;


    //登陆保存实体
    @ResponseBody
    @RequestMapping("/login")
    public Object isLoin(HttpSession session,Employee employee){
        Employee login= employeeService.login(employee);
        System.out.printf(login.getName());
        session.setAttribute("login",login);
        return login;
    }
}
