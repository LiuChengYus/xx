package cn.tmsreception.controller;


import cn.tmsreception.entity.News;
import cn.tmsreception.service.INewsService;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;


/**
 * Created by 17921 on 2017/11/26.
 */
@Controller
public class NewsController {
    @Resource(name = "newsService")
    private INewsService newsService;

    //查询单条新闻
    @RequestMapping("/selNews")
    public String selNes(String nid, Model model){

        News news = newsService.selNews(nid);
        News upNew = newsService.selupNews(nid);
        News downNews = newsService.seldownNews(nid);
        /*System.out.println(upNew.getTitle());
        System.out.println(downNews.getTitle());*/

        model.addAttribute("newsinfo",news);
        model.addAttribute("upNew",upNew);
        model.addAttribute("downNews",downNews);
        return "/newsDetails.jsp";

    }

}
