package com.accp.v.service.vehicle.core.dao;

import com.accp.v.service.vehicle.core.model.Modelmanagement;
import com.accp.v.service.vehicle.core.model.ModelmanagementExample;
import java.util.List;
import java.util.Map;

import com.accp.v.service.vehicle.core.model.Vehiclemanagement;
import org.apache.ibatis.annotations.Param;

public interface ModelmanagementMapper {
    long countByExample(ModelmanagementExample example);

    int deleteByExample(ModelmanagementExample example);

    int insert(Modelmanagement record);

    int insertSelective(Modelmanagement record);

    List<Modelmanagement> selectByExample(ModelmanagementExample example);

    int updateByExampleSelective(@Param("record") Modelmanagement record, @Param("example") ModelmanagementExample example);

    int updateByExample(@Param("record") Modelmanagement record, @Param("example") ModelmanagementExample example);



    /**
     * 分页
     */
    public List<Modelmanagement> getModelmanagementPageUtil(Map<String,Object> map);
    /**
     * 数据
     */
    public int getAccountModelmanagementAll(Map<String,Object> map);
}