package cn.tms.service.impl;

import cn.tms.dao.IPrivilegeUserDao;
import cn.tms.entity.*;
import cn.tms.service.IPrivilegeUserService;
import cn.tms.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "privilegeUserService")
public class PrivilegeUserServiceImpl implements IPrivilegeUserService {

    @Resource(name = "IPrivilegeUserDao")
    public IPrivilegeUserDao iPrivilegeUserDao;

    public UserInfo isLogin(UserInfo userInfo) {
        return iPrivilegeUserDao.isLogin(userInfo);
    }

    public List<Privilege> findAllPrivilegeByUserId(Integer id) {
        return iPrivilegeUserDao.findAllPrivilegeByUserId(id);
    }

    public PageUtil getOneDataRole(Integer pageIndex, Integer pageSize) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",(pageIndex-1)*pageSize );//从第条数据开始
        map.put("pageSize",pageSize);

        PageUtil pageUtil=new PageUtil();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);

        int totalCount = iPrivilegeUserDao.getTotalCount();
        System.out.println(totalCount+"-->totalCount");
        int page=totalCount % pageSize ==0 ? totalCount / pageSize : totalCount / pageSize+1;
        System.out.println(page+"-->page");
        pageUtil.setTotalPages(page);
        pageUtil.setTotalRecords(totalCount);

        List<Role> onePageData = iPrivilegeUserDao.getOneDataRole(map);
        pageUtil.setList(onePageData);
        return pageUtil;
    }

    public List<Privilege> getDataPrivilege() {
        return iPrivilegeUserDao.getDataPrivilege();
    }

    public int delRolePrivilege(Integer id) {
        return iPrivilegeUserDao.delRolePrivilege(id);
    }

    public int addRolePrivilege(Map<Object,Integer> map) {
        return iPrivilegeUserDao.addRolePrivilege(map);
    }

    public List<Column> findAllColumn() {
        return iPrivilegeUserDao.findAllColumn();
    }

    public PageUtil getOneDataNews(int pageIndex, int pageSize,String name) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",pageIndex);//从第条数据开始
        map.put("pageSize",pageSize);
        map.put("name",name);

        PageUtil pageUtil=new PageUtil();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);

        int totalCount = iPrivilegeUserDao.getCount(name);
        System.out.println(totalCount+"-->totalCount");
        int page=totalCount % pageSize ==0 ? totalCount / pageSize : totalCount / pageSize+1;
        System.out.println(page+"-->page");
        pageUtil.setTotalPages(page);
        pageUtil.setTotalRecords(totalCount);

        List<News> onePageData = iPrivilegeUserDao.getOneDataNews(map);
        pageUtil.setList(onePageData);
        return pageUtil;
    }

    public int getCount(String name) {
        return iPrivilegeUserDao.getCount(name);
    }

    public int addNews(News news) {
        return iPrivilegeUserDao.addNews(news);
    }

    //修改新闻
    public int updateNews(News news) {
        return iPrivilegeUserDao.updateNews(news);
    }

    //分页查询新闻列表
    public PageUtil getOneDataNewsTwo(int pageIndex, int pageSize, String columntype, String title, Integer status) {
       /* System.out.println("当前页"+pageIndex);
        System.out.println("当前分页数"+pageSize);
        System.out.println("文章类型"+columntype);
        System.out.println("文章标题"+title);
        System.out.println("文章状态"+status);*/
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",(pageIndex-1)*pageSize);//从第条数据开始
        map.put("pageSize",pageSize);
        map.put("columntype",columntype);
        map.put("title",title);
        map.put("status",status);
        PageUtil pageUtil=new PageUtil();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);

        int totalCount = iPrivilegeUserDao.getNewsCount(map);

        System.out.println(totalCount+"-->总记录数");
        int page=totalCount % pageSize ==0 ? totalCount / pageSize : totalCount / pageSize+1;
        System.out.println(page+"-->总页数");
        pageUtil.setTotalPages(page);
        pageUtil.setTotalRecords(totalCount);

        List<News> onePageData = iPrivilegeUserDao.getOneDataNewsTwo(map);
        pageUtil.setList(onePageData);
        return pageUtil;
    }

    public int getNewsCount(Map<String, Object> map) {
        return iPrivilegeUserDao.getNewsCount(map);
    }

    public News showNews(String id) {
        return iPrivilegeUserDao.showNews(id);
    }


}
