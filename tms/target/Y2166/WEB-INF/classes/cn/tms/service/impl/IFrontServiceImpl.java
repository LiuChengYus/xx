package cn.tms.service.impl;

import cn.tms.dao.IFrontDao;
import cn.tms.entity.*;
import cn.tms.service.IFrontService;
import cn.tms.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CY on 2017/12/5.
 */
@Service(value = "frontServiceImpl")
public class IFrontServiceImpl implements IFrontService {
    @Resource(name = "IFrontDao")
    public IFrontDao FrontDao;


    public UserInfo isLoginFront(UserInfo userInfo) {
        return FrontDao.isLoginFront(userInfo);
    }

    public List<Column> columnList() {
        return FrontDao.columnList();
    }

    public int updateFrontUser(UserInfo userInfo) {
        return FrontDao.updateFrontUser(userInfo);
    }

    public List<News> findNewsByColumnParent() {
        return FrontDao.findNewsByColumnParent();
    }

    public List<News> findNewLimit(Map<String, Object> map) {
        return FrontDao.findNewLimit(map);
    }

    public int pageCount() {
        return FrontDao.pageCount();
    }

    public List<PortInfo> findPortInfo() {
        return FrontDao.findPortInfo();
    }

    public List<WeekVentory> findWeekVentory(String port) {
        return FrontDao.findWeekVentory(port);
    }

    public List<News> findNewsColumn() {
        return FrontDao.findNewsColumn();
    }

    public List<WeekVentory> findWeekVentoryByCode(String port, String type_code) {
        return FrontDao.findWeekVentoryByCode(port,type_code);
    }

}
