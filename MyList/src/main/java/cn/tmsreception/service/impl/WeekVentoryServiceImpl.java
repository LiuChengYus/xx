package cn.tmsreception.service.impl;

import cn.tmsreception.dao.IWeekVentoryDAO;
import cn.tmsreception.entity.WeekVentory;
import cn.tmsreception.service.IWeekVentoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 17921 on 2017/12/12.
 */
@Service("WeekVentoryService")
public class WeekVentoryServiceImpl implements IWeekVentoryService {

    @Resource(name = "IWeekVentoryDAO")
    private IWeekVentoryDAO weekVentoryDAO;



    public List<WeekVentory> getWeekVentoryDAOByInfocode(String infoCode) {
        return weekVentoryDAO.getWeekVentoryDAOByInfocode(infoCode);
    }

    public List<WeekVentory> getWeekByInfoCodeandLumpcode(String port, String typecode) {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("port",port);
        map.put("typecode",typecode);

        return weekVentoryDAO.getWeekByInfoCodeandLumpcode(map);
    }


    public IWeekVentoryDAO getWeekVentoryDAO() {

        return weekVentoryDAO;
    }

    public void setWeekVentoryDAO(IWeekVentoryDAO weekVentoryDAO) {
        this.weekVentoryDAO = weekVentoryDAO;
    }
}
