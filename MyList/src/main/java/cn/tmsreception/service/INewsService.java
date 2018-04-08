package cn.tmsreception.service;

import cn.tmsreception.entity.News;

import java.util.List;
import java.util.Map;

/**
 * Created by 17921 on 2017/11/26.
 */
public interface INewsService {
    //根据栏目code查询新闻
    public List<News> findAllNewsbycode();
    //根据新闻ID查询新闻详情
    public News selNews(String nid);
    //根据时间排序，查询当前新闻的上一篇新闻详情
    public  News selupNews(String nid);
    //根据时间排序，查询当前新闻的下一篇新闻详情
    public  News seldownNews(String nid);

}
