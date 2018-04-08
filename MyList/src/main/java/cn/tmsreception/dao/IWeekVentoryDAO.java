package cn.tmsreception.dao;

import cn.tmsreception.entity.WeekVentory;

import java.util.List;
import java.util.Map;

/**
 * Created by 17921 on 2017/12/12.
 */
public interface IWeekVentoryDAO {
    //根据港口的编号查询所有的木材
    public List<WeekVentory> getWeekVentoryDAOByInfocode(String infoCode);
    //根据港口编号和木材编号查询木材
    public List<WeekVentory> getWeekByInfoCodeandLumpcode(Map<String,Object> map);
}
