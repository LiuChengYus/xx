package cn.tmsreception.service.impl;


import cn.tmsreception.dao.INewsDAO;
import cn.tmsreception.entity.News;
import cn.tmsreception.service.INewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 17921 on 2017/11/26.
 */
@Service("newsService")
public class NewsServiceImpl implements INewsService {

    @Resource(name = "INewsDAO")
    private INewsDAO newsDAO;

    public List<News> findAllNewsbycode() {
        return newsDAO.findAllNewsbycode();
    }

    public News selNews(String nid) {
        return newsDAO.selNews(nid);
    }

    public News selupNews(String nid) {
        return newsDAO.selupNews(nid);
    }

    public News seldownNews(String nid) {
        return newsDAO.seldownNews(nid);
    }

    public INewsDAO getNewsDAO() {
        return newsDAO;
    }

    public void setNewsDAO(INewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }



}
