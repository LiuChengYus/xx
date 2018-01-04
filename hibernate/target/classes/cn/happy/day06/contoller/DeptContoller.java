package cn.happy.day06.contoller;

import cn.happy.day06.bean.Dept;
import cn.happy.day06.service.IDeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by CY on 2017/12/27.
 */
@Controller
public class DeptContoller {
    @Resource
    private IDeptService deptService;

    @RequestMapping(value = "/addDept")
     public String add(Dept dept){
        deptService.addDept(dept);
        return "/index.jsp";
     }
}
