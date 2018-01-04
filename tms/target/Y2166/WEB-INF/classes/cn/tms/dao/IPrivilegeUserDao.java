package cn.tms.dao;

import cn.tms.entity.*;

import java.util.List;
import java.util.Map;

/**
 * Created by CY on 2017/11/19.
 */
public interface IPrivilegeUserDao {

    //登陆
    public UserInfo isLogin(UserInfo userInfo);

    //权限列表
    public List<Privilege> findAllPrivilegeByUserId(Integer id);
    //角色分页
    public List<Role> getOneDataRole(Map<String,Object> map);
    //总记录
    //全部 / 分类 总记录
    public int getTotalCount();
    //权限全部
    public List<Privilege> getDataPrivilege();

    //删除权限
    public int delRolePrivilege(Integer id);
    //添加权限
    public int addRolePrivilege(Map<Object,Integer> map);
    //所有的栏目
    public List<Column> findAllColumn();

    //查询所有新闻
    public List<News> getOneDataNews(Map<String,Object> map);

    //查询总记录数
    public int getCount(String name);
    //增加新闻
    public int addNews(News news);
    //修改新闻
    public int updateNews(News news);

    //分页查询所有数据
    public List<News> getOneDataNewsTwo(Map<String,Object> map);

    //分页查询你总的记录数
    public int getNewsCount(Map<String,Object> map);

    //数据回显
    public News showNews(String id);
}
