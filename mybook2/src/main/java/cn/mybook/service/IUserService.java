package cn.mybook.service;


import cn.mybook.entity.Type;
import cn.mybook.entity.User;
import cn.mybook.util.PageUtil;

import java.util.List;

public interface IUserService {
    //登陆
    public User login(User user);
    //分类表
    public List<Type> getType();
    //分页多对一
    public PageUtil getOneData(Integer pageIndex, Integer pageSize, Integer type, String bookname, Integer look  );
    //注册
    public int addUser(User user);
}
