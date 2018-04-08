package com.accp.v.service.vehicle.core.dao;

import com.accp.v.service.vehicle.core.model.Vehiclemanagement;
import com.accp.v.service.vehicle.core.model.VehiclemanagementExample;
import java.util.List;
import java.util.Map;

import com.accp.v.service.vehicle.core.util.PageUtil;
import org.apache.ibatis.annotations.Param;

public interface VehiclemanagementMapper {
    long countByExample(VehiclemanagementExample example);

    int deleteByExample(VehiclemanagementExample example);

    int insert(Vehiclemanagement record);

    int insertSelective(Vehiclemanagement record);

    List<Vehiclemanagement> selectByExample(VehiclemanagementExample example);

    int updateByExampleSelective(@Param("record") Vehiclemanagement record, @Param("example") VehiclemanagementExample example);

    int updateByExample(@Param("record") Vehiclemanagement record, @Param("example") VehiclemanagementExample example);
    /**
     * 分页
     */
    public List<Vehiclemanagement> getVehiclemanagementPageUtil(Map<String,Object> map);
    /**
     * 数据
     */
    public int getAccountPagrUtil(Map<String,Object> map);
}