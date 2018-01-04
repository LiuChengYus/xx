package cn.mybook.contoller;
import cn.mybook.entity.Book;
import cn.mybook.entity.Type;
import cn.mybook.entity.User;
import cn.mybook.service.IUserService;
import cn.mybook.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        Map<String,Object> map=new HashMap<String,Object>();
        PageUtil<Book> onePageData = userService.getOneData(1,3,-1,null,-1);
        session.setAttribute("bookData",onePageData);
        return num;
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
    @RequestMapping(value = "/getOneDatebook")
    public Object getOneDate(@RequestParam(defaultValue = "1",required = false)int pageIndex, @RequestParam(defaultValue = "3",required = false)int pageSize, @RequestParam(defaultValue = "-1",required = false) Integer type, @RequestParam(required = false) String bookname, @RequestParam(defaultValue = "-1",required = false) Integer look, HttpSession session, ModelAndView modelAndView,@RequestParam(required = false)Integer all){

        if(pageIndex<1||pageIndex>all){
            pageIndex=1;
        }
        Map<String,Object> map=new HashMap<String,Object>();
        PageUtil<Book> onePageData = userService.getOneData(pageIndex,3,type,bookname,look);
        session.setAttribute("bookData",onePageData);
        session.setAttribute("type",type);
        session.setAttribute("bookname",bookname);
        session.setAttribute("look",look);
        session.setAttribute("all",onePageData.getTotalPages());
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }
    //注册
    @RequestMapping(value = "/addUser")
    public String addUser(User user){
        int i = userService.addUser(user);
        System.out.println("注册成功");
        return "/login.jsp";
    }
}
