package com.accp.v.service.vehicle.core.dao;

import com.accp.v.service.vehicle.core.model.DictionaryType;
import com.accp.v.service.vehicle.core.model.DictionaryTypeExample;
import java.util.List;


public interface DictionaryTypeMapper {
    long countByExample(DictionaryTypeExample example);

    int deleteByExample(DictionaryTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryType record);

    int insertSelective(DictionaryType record);

    List<DictionaryType> selectByExample(DictionaryTypeExample example);

    DictionaryType selectByPrimaryKey(Integer id);

    int updateByExampleSelective( DictionaryType record, DictionaryTypeExample example);

    int updateByExample(DictionaryType record, DictionaryTypeExample example);

    int updateByPrimaryKeySelective(DictionaryType record);

    int updateByPrimaryKey(DictionaryType record);
}