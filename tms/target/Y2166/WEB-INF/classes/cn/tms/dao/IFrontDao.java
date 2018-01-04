package cn.tms.dao;
import cn.tms.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CY on 2017/12/5.
 */
public interface IFrontDao {

    //前台登陆
    public UserInfo isLoginFront(UserInfo userInfo);
    //查询所有的栏目列表
    public List<Column> columnList();
    //修改密码
    public int updateFrontUser(UserInfo userInfo);
    //栏目下的新闻列表
    public List<News> findNewsByColumnParent();
    //分页查询上一篇和下一篇
    public List<News> findNewLimit(Map<String,Object> map);
    //查询总记录数
    public int pageCount();
    //港口表
    public List<PortInfo> findPortInfo();

    //结果表
    public List<WeekVentory> findWeekVentory(String port);

    //查询新闻
    public List<News> findNewsColumn();

    //查询最近8周的数据
    public List<WeekVentory> findWeekVentoryByCode(@Param("port") String port,@Param("type_code") String type_code);
}
