package com.accp.v.service.vehicle.core.dao;

import com.accp.v.service.vehicle.core.model.Dictionary;
import com.accp.v.service.vehicle.core.model.DictionaryExample;
import java.util.List;


public interface DictionaryMapper {
    long countByExample(DictionaryExample example);

    int deleteByExample(DictionaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    /**查询所有
     *
     * @param
     * @return
     */

    List<Dictionary> selectByVehiclerAll();

    Dictionary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Dictionary record,  DictionaryExample example);

    int updateByExample(Dictionary record, DictionaryExample example);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}