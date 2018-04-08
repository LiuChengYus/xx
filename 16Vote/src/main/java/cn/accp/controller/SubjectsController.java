package cn.accp.controller;

import cn.accp.entity.Options;
import cn.accp.entity.Subjects;
import cn.accp.service.ISubjectsService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 14:14 2018/3/12
 */
@Controller
@RequestMapping("/vote")
public class SubjectsController {

    @Resource(name = "iSubjectsService")
    private ISubjectsService subjectsService;


    //list

    @RequestMapping("/subjectlist")
    @ResponseBody
    public Object index(Subjects subjects, HttpSession session){

        List<Subjects> subjectss = subjectsService.selectSubjectList(subjects);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List time=new ArrayList();
        for (Subjects item:subjectss) {
            String format = sdf.format(item.getCreateDate());
            time.add(format);
        }
        session.setAttribute("list",subjectss);
        session.setAttribute("time",time);
        return subjectss;
    }


    @RequestMapping("/options")
    public Object result(Integer sid, HttpSession session){
        System.out.println(sid+"---");
         Options options=new Options();
         options.setSid(sid);

        List<Options> optionss = subjectsService.selectOptionsList(options);
        for (Options item:optionss) {
            System.out.println(item.getId());
            System.out.println(item.getOptContent());
        }
        //subject look +1
        Subjects subjects1=new Subjects();
        subjects1.setId(sid);
        subjectsService.updateSubjectslook(subjects1);


        Subjects subjects = subjectsService.selectOne(sid);
        session.setAttribute("opt",optionss);
        session.setAttribute("selectOne",subjects);
        return "/result.jsp";
    }

    @RequestMapping("/add")
    public Object add(Integer ids,Integer id, HttpSession session){
        System.out.println("新闻id"+ids);
        System.out.println("投票id"+id);
        Subjects subjects=new Subjects();
        subjects.setId(ids);
        subjectsService.updateSubjectsDate(subjects);
        Options options=new Options();
        options.setId(id);
        subjectsService.updateOptionsDate(options);


        return "/succes.jsp";
    }

}
