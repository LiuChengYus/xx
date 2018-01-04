package cn.tms.contoller;

import cn.tms.entity.Column;
import cn.tms.entity.News;
import cn.tms.entity.UserInfo;
import cn.tms.entity.WeekVentory;
import cn.tms.service.IFrontService;

import cn.tms.service.IPrivilegeUserService;
import cn.tms.util.EmailTest;
import cn.tms.util.SmsDemo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CY on 2017/12/5.
 */

@Controller
@RequestMapping(value = "/front")
public class FrontContoller {

    //前台
    @Resource(name = "frontServiceImpl")
    public IFrontService frontService;

    //后台
    @Resource(name = "privilegeUserService")
    public IPrivilegeUserService PrivilegeUserService;

    //登陆保存实体
    @ResponseBody
    @RequestMapping("/loginFront")
    public Object isLoin(HttpSession session, UserInfo userInfo){
        UserInfo login = frontService.isLoginFront(userInfo);
        List<Column> allColumnList = frontService.columnList();
        for (Column item:allColumnList) {
            System.out.println(item.getColumnname());
        }
        session.setAttribute("userinfo",login);
        session.setAttribute("columnList",allColumnList);
        session.setAttribute("newList",frontService.findNewsByColumnParent());
        session.setAttribute("portInfo",frontService.findPortInfo());
         return login;
    }

    //查询所有的栏目列表
    @ResponseBody
    @RequestMapping(value = "/getAllColumn")
    public Object getAllColumnlist(HttpSession session){
        List<Column> allColumnList = frontService.columnList();
    /*   for (Column item:allColumnList) {
            System.out.println(item.getColumnname());
            for (Column item1:item.getChildren()){
                System.out.println(item1.getColumnname());
            }
        }*/
       session.setAttribute("columnList",allColumnList);
        return allColumnList;
    }

    //发送邮箱验证码
    @ResponseBody
    @RequestMapping(value = "/SenCode")
    public  Object getEmailQQ(HttpSession session,String address) throws Exception {
        //发送本次验证码
        int email = EmailTest.email(address);
        //记录本次验证码
        session.setAttribute("codes",email);

        return  "OK";
    }

    //邮箱找回密码
    @ResponseBody
    @RequestMapping("/findCode")
    public  Object getUserPwdCode(UserInfo userInfo,HttpSession session,Integer code){
        System.out.println("用户名"+userInfo.getUsername());
        System.out.println("密码"+userInfo.getUserpwd());
        System.out.println("验证码"+code);
        //读取上一此操作的验证码
        Integer codes = (Integer) session.getAttribute("codes");
        //对比验证
        if (codes==code){
            //执行修改密码操作
            frontService.updateFrontUser(userInfo);
        }else {
            return "NO";
        }

        return "OK";

    }

    //短信验证码
    @ResponseBody
    @RequestMapping(value = "/sendManagerCode")
    public Object huoquTel(String phone,HttpSession session){

       /* System.out.println(1);*/
        //创建随机数
        double math = Math.random();
        int YZM;
        if (math < 0.1) {
            YZM = (int) ((math + 1) * 1000000);
        } else {
            YZM = (int) (math * 1000000);
        }
        try{
            /*System.out.println(2);*/
            //发送验证码
            /*System.out.println("验证码是"+YZM);
            System.out.println("手机号"+phone+"验证码"+YZM);*/
            //保存到session中
            session.setAttribute("manageCode",YZM);
            SmsDemo.sendSms(phone, YZM);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "OK";
    }
    //短信找回密码
    @ResponseBody
    @RequestMapping("/findManageCode")
    public  Object getManageCode(UserInfo userInfo,HttpSession session,Integer code){
        System.out.println("用户名"+userInfo.getUsername());
        System.out.println("密码"+userInfo.getUserpwd());
        //读取上一此操作的验证码
        Integer codes = (Integer) session.getAttribute("manageCode");
        System.out.println("验证码->"+code);
        System.out.println("作用域里面的验证码->"+codes);
        System.out.println(codes.equals(code));
        //对比验证
        if (codes.equals(code)){
            //执行修改密码操作
            frontService.updateFrontUser(userInfo);
       }else {
            return "NO";
        }
        return "OK";
    }

    //查看新闻详情 --/新闻上一页下一页
    @RequestMapping(value = "/newsDetails")
    public String lookNewDetails(String id,Model model){
        System.out.println("新闻的id"+id);
        /*News newsList = PrivilegeUserService.showNews(id);*/
        /*modelAndView.addObject("newsDetails",newsList);*/

        //中间页
        List<News> newsColumn = frontService.findNewsColumn();
        int index=0;
        News news=null;
        for (News item:newsColumn) {
            if(item.getInformation_code().equals(id)){
                news=item;

                System.out.println("索引"+item.getInformation_code()+"id"+index);
                break;
            }
            index++;
        }
        model.addAttribute("news1",news);
        //上一页
        try {
            News news1 = newsColumn.get(index-1);
            model.addAttribute("news2",news1);
        }catch (Exception e){
            News news1 = newsColumn.get(0);
            model.addAttribute("news2",news1);
        }
       //下一页
        try{
            News news2 = newsColumn.get(index+1);
            model.addAttribute("news3", news2);
        }catch (Exception e){
            News news2 = newsColumn.get(index);
            model.addAttribute("news3", news2);
        }

        return  "/front/newsDetails.jsp";
    }

    /*//新闻上一页下一页
    @RequestMapping(value = "/newspaing")
    public Object newsSpaing(String id,Model model){

        List<News> newsColumn = frontService.findNewsColumn();
        int index=0;
        News news=null;
        for (News item:newsColumn) {
            if(item.getInformation_code().equals(id)){
              news=item;
              break;
            }
            index++;
        }
        //中间页
        model.addAttribute("news1",news);
        System.out.println("新闻编号"+news.getInformation_code());
        //上一页
        News news1 = newsColumn.get(index + 1);
        model.addAttribute("news2",news1);
        //下一页
        News news2 = newsColumn.get(index -1);
        model.addAttribute("news3",news2);
        return "/front/index.jsp";
    }*/

    //报表
    @ResponseBody
    @RequestMapping(value = "/echaresWeek")
    public Object getecharesWeeks(@RequestParam(required = false) String port, @RequestParam(required = false) String type_Code){
        System.out.println("仓库"+port+"木材"+type_Code);
        List<WeekVentory> weekVentoryList=frontService.findWeekVentoryByCode(port,type_Code);
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");

        List<String> price=new ArrayList<String>();
        List<String> time=new ArrayList<String>();
        for (WeekVentory item:weekVentoryList) {
         price.add(Double.toString(item.getPrice()));
         time.add(sdf.format(item.getPubtime()));
        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("prices",price);
        map.put("datatime",time);
        return map;
    }

}
