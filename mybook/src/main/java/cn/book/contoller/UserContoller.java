package cn.book.contoller;

import cn.book.entity.Book;
import cn.book.entity.Type;
import cn.book.entity.User;
import cn.book.service.IUserService;
import cn.book.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CY on 2017/12/22.
 */
@Controller
@RequestMapping(value = "/user")
public class UserContoller {

    @Resource(name = "IUserServiceImpl")
    private IUserService userService;
    //登陆
    @ResponseBody
    @RequestMapping(value = "/login")
    public Object islogin(User user, HttpSession session){
       User login = userService.login(user);
        int num=0;
        if(login!=null){
            num=1;
            session.setAttribute("user",login);
        }else {
            num=2;
        }
        return 1;
    }

    //分类
    @ResponseBody
    @RequestMapping(value = "/type")
    public Object getType(){
        List<Type> type = userService.getType();
        return type;
    }

    //分页
    @ResponseBody
    @RequestMapping(value = "/getOneDate")
    public Object getOneDate(@RequestParam(defaultValue = "1",required = false)int pageIndex, @RequestParam(defaultValue = "3",required = false)int pageSize, @RequestParam(value = "-1") Integer type, @RequestParam(required = false) String bookName,@RequestParam(value = "-1") Integer isborrow){
        System.out.println(1);
        Map<String,Object> map=new HashMap<String,Object>();
        PageUtil<Book> onePageData = userService.getOneData(1, 3,0,bookName,0);
        return onePageData;
    }

    //注册
    @RequestMapping(value = "/addUser")
    public String addUser(User user){
        int i = userService.addUser(user);
        System.out.println("注册成功");
        return "/login.jsp";
    }
}
