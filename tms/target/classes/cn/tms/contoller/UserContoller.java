package cn.tms.contoller;
import cn.tms.entity.*;
import cn.tms.service.IPrivilegeUserService;
import cn.tms.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;



@Controller
@RequestMapping("/user")
public class UserContoller {

    @Resource(name = "privilegeUserService")
    public IPrivilegeUserService PrivilegeUserService;


    //登陆保存实体
    @ResponseBody
    @RequestMapping("/login")
    public Object isLoin(HttpSession session, UserInfo userInfo){
        UserInfo login = PrivilegeUserService.isLogin(userInfo);
        if(login!=null){
            session.setAttribute("userinfo",login);
            return "y";
        }else {
            return "n";
        }
    }


    //权限列表

    @RequestMapping(value = "/doMain")
    public Object getAllPrivilege(HttpSession session, Model model){
        Privilege p=new Privilege();
        //新的容器 保存有父子关系的权限
        List<Privilege> rootMenus=new ArrayList<Privilege>();
        //用户id从哪里来    从session中获取
        UserInfo info=(UserInfo)session.getAttribute("userinfo");
        List<Privilege> privilegeList = PrivilegeUserService.findAllPrivilegeByUserId(info.getUserid());
        //将平级的权限  变成  有层级关系的权限集合
        //p.setName("其他");
        for (Privilege item:privilegeList){

            Privilege childMenu=item;
            int pid = childMenu.getParent();
            if (pid==0){
                rootMenus.add(item);
            }else{
                for (Privilege innerMenu:privilegeList){
                    Integer id = innerMenu.getId();
                    if (id==pid){
                        Privilege parentMenu=innerMenu;
                        parentMenu.getChildren().add(childMenu);

                        break;
                    }else {
                        p.getChildren().add(childMenu);
                    }
                }
            }
        }
/*
        for (Privilege item:rootMenus) {
            if (item.getChildren().size()<1){
                rootMenus.remove(item);
            }
        }
        rootMenus.add(p);*/
        //放入model中，为了在UI界面上获取到值  ======>request.setAttribute(key,value);
        model.addAttribute("privileges",rootMenus);
     /*   System.out.println("-----------------------------------------------------------------");
        for (Privilege xx:rootMenus) {
            System.out.println("父级名称"+xx.getName());
            for (Privilege cc:xx.getChildren()) {
                System.out.println("子级名称"+cc.getName());
            }
        }*/


        return "/main.jsp";
    }

    //获取用户数据
    @ResponseBody
    @RequestMapping(value = "/getOneRole")
    public Object getUserInfo(@RequestParam(defaultValue = "1", value = "page")int pageIndex, @RequestParam(defaultValue = "2",value = "rows")int pageSize){
        System.out.println(1);
        Map<String,Object> map=new HashMap<String,Object>();
        PageUtil<Role> onePageData = PrivilegeUserService.getOneDataRole(pageIndex, pageSize);
        map.put("total",onePageData.getTotalRecords());
        map.put("rows",onePageData.getList());
        System.out.println(2);
        return map;
    }


    //获取全部权限
    @ResponseBody
    @RequestMapping(value = "getDatePrivilege")
    public Object getDatePrivilege(){
        //新的容器 保存有父子关系的权限
        List<Privilege> rootMenus=new ArrayList<Privilege>();
        List<Privilege> dataPrivilege = PrivilegeUserService.getDataPrivilege();
        //将平级的权限  变成  有层级关系的权限集合
        for (Privilege item:dataPrivilege){
            Privilege childMenu=item;
            int pid = childMenu.getParent();
            if (pid==0){
                rootMenus.add(item);
            }else{
                for (Privilege innerMenu:dataPrivilege){
                    Integer id = innerMenu.getId();
                    if (id==pid){
                        Privilege parentMenu=innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }
        return rootMenus;
    }


    //获取角色全部权限
    @ResponseBody
    @RequestMapping(value = "getAllDatePrivilege")
    public Object getAllDatePrivilege(@RequestParam(value = "rid",required =false) Integer rid){
        //新的容器 保存有父子关系的权限
        List<Privilege> rootMenus=new ArrayList<Privilege>();
        List<Privilege> dataPrivilege = PrivilegeUserService.findAllPrivilegeByUserId(rid);
        //将平级的权限  变成  有层级关系的权限集合
        for (Privilege item:dataPrivilege){
            Privilege childMenu=item;
            int pid = childMenu.getParent();
            if (pid==0){
                rootMenus.add(item);
            }else{
                for (Privilege innerMenu:dataPrivilege){
                    Integer id = innerMenu.getId();
                    if (id==pid){
                        Privilege parentMenu=innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }
        return rootMenus;
    }

    //修改权限
    @RequestMapping(value = "/updateRolePrivilege")
    @ResponseBody
    public Object updateRolePrivilege(String rid,String id){
        System.out.println("角色id→"+rid);
        //删除权限
        PrivilegeUserService.delRolePrivilege(Integer.parseInt(rid));
        String[] ids=id.split(",");
        for (int i=0;i<ids.length;i++){
            Map<Object,Integer> map=new HashMap<Object,Integer>();
           System.out.println("权限id→"+ids[i]);
           map.put("roleId",Integer.parseInt(rid));
           map.put("privilegeId",Integer.parseInt(ids[i]));
           //循环增加权限
            PrivilegeUserService.addRolePrivilege(map);
       }

        return "OK";
    }


    //查询所有栏目
    @ResponseBody
    @RequestMapping(value = "/findAllColumn")
    public Object findAllColumn(){
        //新的容器 保存有父子关系的权限
        List<Column> rootMenus=new ArrayList<Column>();
        List<Column> dataPrivilege = PrivilegeUserService.findAllColumn();
        //将平级的权限  变成  有层级关系的权限集合
        for (Column item:dataPrivilege){
            Column childMenu=item;
            String pid = childMenu.getParentcode();
            if (pid.equals("0")){
                rootMenus.add(item);
            }else{
                for (Column innerMenu:dataPrivilege){
                    String id = innerMenu.getSyscode();
                    if (id.equals(pid)){
                        Column parentMenu=innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }
        return rootMenus;
    }

    //加载所有栏目下的新闻列表
    @ResponseBody
    @RequestMapping(value = "/getOneNews")
    public Object getOneNews(@RequestParam(defaultValue = "1", value = "page")int pageIndex, @RequestParam(defaultValue = "2",value = "rows")int pageSize,@RequestParam(required = false) String name){
        System.out.println(1);
        Map<String,Object> map=new HashMap<String,Object>();
        PageUtil<Role> onePageData = PrivilegeUserService.getOneDataNews(pageIndex, pageSize,name);
        map.put("total",onePageData.getTotalRecords());
        map.put("rows",onePageData.getList());
        System.out.println(2);
        return map;
    }

 /*  //添加新闻
    @ResponseBody
    @RequestMapping(value = "/addNews")
    public ModelAndView adddNews(News news, ModelAndView modelAndView,@RequestParam(value = "image_url") CommonsMultipartFile file)throws Exception{
        long startTime=System.currentTimeMillis();
        System.out.println("文件名称"+file.getOriginalFilename());
        String path="E:/"+new Date().getTime()+file.getOriginalFilename();
        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件
        file.transferTo(newFile);
        long endTime=System.currentTimeMillis();
        System.out.println("方法的运行时间"+String.valueOf(endTime-startTime)+"ms");
        int i = PrivilegeUserService.addNews(news);
        modelAndView.setViewName("/page/addNews.jsp");
        return  modelAndView;
    }*/

    //添加新闻
    @ResponseBody
    @RequestMapping(value = "/addNews")
    public Object adddNews(News news,ModelAndView modelAndView,@RequestParam MultipartFile upload,HttpSession session)throws Exception{

        String filename=upload.getOriginalFilename();
        System.out.println("图片名称"+filename);
        System.out.println("图片路径"+upload);

        String path=session.getServletContext(). getRealPath("/upload");

        File file=new File(path,filename);

        upload.transferTo(file);
        news.setImage_url(filename);
        PrivilegeUserService.addNews(news);
        modelAndView.setViewName("/page/column.jsp");
        return  modelAndView;
    }


    //测试
    @ResponseBody
    @RequestMapping(value = "/add")
    public ModelAndView add(ModelAndView modelAndView,MultipartFile image_url,HttpSession session)throws Exception{

        String filename=image_url.getOriginalFilename();
        System.out.println("图片名称"+filename);
        System.out.println("图片路径"+image_url);
        String path=session.getServletContext().getRealPath("/upload");
        File file=new File(path,filename);
        image_url.transferTo(file);
        modelAndView.setViewName("/myimgupload.jsp");
        return  modelAndView;
    }


    //第三步编写服务器ue配置获取返回json格式

    /*@RequestMapping(value = "/loadUEConfig.do")
    @ResponseBody
    public Object loadUEConfig(HttpServletRequest request){
        String action=request.getParameter("action");
        Map<String,Object> result = new HashMap<String,Object>();
        if(action.equals("config")){
            String endpoint = PropertiesUtil.getValue("file.domain");
            String maxUploadImageSize=PropertiesUtil.getValue("spring.maxUploadImageSize");
            String maxUploadSize=PropertiesUtil.getValue("spring.maxUploadSize");
            String prefix=PropertiesUtil.getValue("file.domain");
            result.put("imageActionName","file");
            result.put("imageFieldName","file");
            result.put("imageMaxSize",maxUploadImageSize);//上传大小限制，单位B
            result.put("host",endpoint);//上传路径
            result.put("imageAllowFiles",new String[]{".png", ".jpg", ".jpeg", ".gif", ".bmp"});
            result.put("imageCompressEnable",false); //是否压缩图片,默认是true"
            result.put("imageUrlPrefix",prefix);//图片访问路径前缀
            result.put("imageInsertAlign","none");//插入的图片浮动方式
            result.put("imagePathFormat","/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}");//上传保存路径,可以自定义保存路径和文件名格式
            result.put("videoActionName","file");//执行上传视频的action名称
            result.put("videoMaxSize",maxUploadSize);//上传视频大小限制，单位B
            result.put("videoUrlPrefix",prefix);//视频访问路径前缀
            result.put("videoAllowFiles ",new String[]{".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg",
                    ".mpg", ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid"});//视频访问路径前缀
            result.put("fileActionName","file");//执行上传文件的action名称
            result.put("fileMaxSize",maxUploadSize);//上传文件大小限制，单位B
            result.put("fileUrlPrefix",prefix);//文件访问路径前缀
            result.put("fileAllowFiles",new String[]{
                    ".png", ".jpg", ".jpeg", ".gif", ".bmp",
                    ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
                    ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid",
                    ".rar", ".zip", ".tar", ".gz", ".7z", ".bz2", ".cab", ".iso",
                    ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".md", ".xml"
            });//文件访问格式
        }

        return result;
    }
*/

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateNews")
   public Object updateNews(News news,@RequestParam MultipartFile upload,ModelAndView modelAndView,HttpSession session) throws Exception {
        String filename=upload.getOriginalFilename();
        String path=session.getServletContext(). getRealPath("/upload");
        File file=new File(path,filename);
        upload.transferTo(file);
        news.setImage_url(filename);
        int i = PrivilegeUserService.updateNews(news);
        modelAndView.setViewName("/page/column.jsp");
        return  modelAndView;
   }


    //分类加载全部新闻列表
    @ResponseBody
    @RequestMapping(value = "/getOneNewsTwo")
    public Object getOneNewsTwo(@RequestParam(defaultValue = "1", value = "page")int pageIndex, @RequestParam(defaultValue = "2",value = "rows")int pageSize,@RequestParam(required = false) String columntype,@RequestParam(required = false) String title,@RequestParam(defaultValue = "-1",required = false) Integer status){
     /*   System.out.println("当前页"+pageIndex);
        System.out.println("数据"+pageSize);
        System.out.println("类型"+columntype);
        System.out.println("标题"+title);
        System.out.println("状态"+status);*/
        Map<String,Object> map=new HashMap<String,Object>();
        PageUtil<Role> onePageData = PrivilegeUserService.getOneDataNewsTwo(pageIndex,pageSize,columntype,title,status);
        map.put("total",onePageData.getTotalRecords());
        map.put("rows",onePageData.getList());
        return map;
    }

    //数据会先
    @RequestMapping(value = "showNews")
    public String ShowNews(HttpSession session,@RequestParam(required = false) String id){
      News news = PrivilegeUserService.showNews(id);
        session.setAttribute("news",news);
        return  "/page/updateNews.jsp";
    }

    //处理请求一之角色管理
    @RequestMapping("/groupManage")
    public String fwored1(){
        return "/page/groupManage.jsp";
    }

    //处理请求一之内容发布
    @RequestMapping("/column")
    public String fwored2(){
        return "/page/column.jsp";
    }
    //处理请求一之安全退出
    @RequestMapping("/exit")
    public String fwored3(){
        return "/page/login.jsp";
    }


}
