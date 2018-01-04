package cn.mybook.service.impl;
import cn.mybook.dao.IUserDao;
import cn.mybook.entity.Book;
import cn.mybook.entity.Type;
import cn.mybook.entity.User;
import cn.mybook.service.IUserService;
import cn.mybook.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "IUserServiceImpl")
public class IUserServiceImpl implements IUserService {

    @Resource(name = "IUserDao")
    private IUserDao userDao;
    public User login(User user) {
        return userDao.login(user);
    }

    public List<Type> getType() {
        return userDao.getType();
    }

    public PageUtil getOneData(Integer pageIndex, Integer pageSize, Integer type, String bookname, Integer look) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",(pageIndex-1)*pageSize);//从第条数据开始
        map.put("pageSize",3);
        map.put("type",type);
        map.put("name",bookname);
        map.put("look",look);
        PageUtil pageUtil=new PageUtil();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);

        int totalCount = userDao.getCount(map);

        System.out.println(totalCount+"-->总记录数");
        int page=totalCount % pageSize ==0 ? totalCount / pageSize : totalCount / pageSize+1;
        System.out.println(page+"-->总页数");
        pageUtil.setTotalPages(page);
        pageUtil.setTotalRecords(totalCount);

        List<Book> onePageData = userDao.getOneDataBook(map);
        pageUtil.setList(onePageData);
        return pageUtil;
    }

    public int addUser(User user) {

        return  userDao.addUser(user);
    }

}
