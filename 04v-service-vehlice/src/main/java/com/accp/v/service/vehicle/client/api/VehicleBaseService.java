package com.accp.v.service.vehicle.client.api;

import com.accp.v.service.vehicle.client.model.Vehicle;
import com.accp.v.service.vehicle.core.model.Dictionary;
import com.accp.v.service.vehicle.core.util.PageUtil;

import java.util.List;
import java.util.Map;

public interface VehicleBaseService {



	/**
	 * 
	 * @Description: 通过车牌号查询车辆对象
	 *
	 * @date 2017年8月26日,下午12:10:16
	 * @author chenyun
	 * @version 1.0.0
	 *
	 * @param vin
	 * @return
	 * @throws Exception
	 */
	public Vehicle getVehicleByVin(String vin) throws Exception;


	/**
	 *
	 * @return
	 * @throws Exception
	 */
    public List<Dictionary> getVechicleAll() throws Exception;

	/**
	 * 分页
	 */
	public PageUtil getVehiclemanagementPageUtil(int pageIndex, int pageSize,String...args);




}
