package cn.book.service.impl;

import cn.book.dao.IUserDao;
import cn.book.entity.Book;
import cn.book.entity.Type;
import cn.book.entity.User;
import cn.book.service.IUserService;
import cn.book.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CY on 2017/12/22.
 */
@Service(value = "IUserServiceImpl")
public class IUserServiceImpl implements IUserService {

    @Resource(name = "IUserDao")
    private IUserDao userDao;
    public User login(User user) {
        return userDao.login(user);
    }

    public PageUtil getOneData(Integer pageIndex, Integer pageSize, Integer type, String bookName, Integer isborrow) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",(pageIndex-1)*pageSize);//从第条数据开始
        map.put("pageSize",3);
        map.put("book_type",type);
        map.put("book_name",bookName);
        map.put("is_borrow",isborrow);
        PageUtil pageUtil=new PageUtil();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);

        int totalCount = userDao.getCount(map);

        System.out.println(totalCount+"-->总记录数");
        int page=totalCount % pageSize ==0 ? totalCount / pageSize : totalCount / pageSize+1;
        System.out.println(page+"-->总页数");
        pageUtil.setTotalPages(page);
        pageUtil.setTotalRecords(totalCount);

        List<Book> onePageData = userDao.getOneData(map);
        pageUtil.setList(onePageData);
        return pageUtil;
    }


    public List<Type> getType() {
        return userDao.getType();
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }
}
