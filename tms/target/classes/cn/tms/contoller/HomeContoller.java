package cn.tms.contoller;
import cn.tms.entity.Column;
import cn.tms.entity.PortInfo;
import cn.tms.entity.WeekVentory;
import cn.tms.service.IFrontService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by CY on 2017/12/12.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeContoller {

    //前台
    @Resource(name = "frontServiceImpl")
    public IFrontService frontService;

    //前台港口
    @RequestMapping(value = "/portinfo")
    public Object portinfo(Model model, HttpSession session){
        List<PortInfo> portInfo = frontService.findPortInfo();
        List<Column> allColumnList = frontService.columnList();
        model.addAttribute("portInfo",portInfo);
        session.setAttribute("columnList",allColumnList);
        session.setAttribute("newList",frontService.findNewsByColumnParent());
        return  "/front/index.jsp";
    }
    //前台结果
    @ResponseBody
    @RequestMapping(value = "/week")
    public Object WeekVentory(@RequestParam(required =false) String port){
      if (port==null){
          port="TC";
      }
        List<WeekVentory> weekVentory = frontService.findWeekVentory(port);
        return  weekVentory;
    }
}
