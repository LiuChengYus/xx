package cn.book.dao;

import cn.book.entity.Book;
import cn.book.entity.Type;
import cn.book.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by CY on 2017/12/22.
 */
public interface IUserDao {

    //登陆
    public User login(User user);
    //分页多对一
    public List<Book> getOneData(Map<String,Object> map);
    //分类表
    public List<Type> getType();
    //总记录
    public int getCount(Map<String,Object> map);
    //注册
    public int addUser(User user);


}
