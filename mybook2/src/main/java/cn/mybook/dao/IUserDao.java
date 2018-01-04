package cn.mybook.dao;
import cn.mybook.entity.Book;
import cn.mybook.entity.Type;
import cn.mybook.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by CY on 2017/12/22.
 */
public interface IUserDao {

    //登陆
    public User login(User user);
    //分类表
    public List<Type> getType();
    //总记录
    public int getCount(Map<String,Object> map);
    //分页多对一
    public List<Book> getOneDataBook(Map<String,Object> map);
    //注册
    public int addUser(User user);

}
