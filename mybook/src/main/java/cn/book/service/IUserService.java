package cn.book.service;

import cn.book.entity.Book;
import cn.book.entity.Type;
import cn.book.entity.User;
import cn.book.util.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by CY on 2017/12/22.
 */
public interface IUserService {
    //登陆
    public User login(User user);
    //分页多对一
    public PageUtil getOneData(Integer pageIndex,Integer pageSize,Integer type,String bookName,Integer isborrow  );
    //分类表
    public List<Type> getType();
    //注册
    public int addUser(User user);
}
