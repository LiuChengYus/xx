package com.accp.v.service.vehicle.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accp.v.service.vehicle.core.dao.VehiclemanagementMapper;
import com.accp.v.service.vehicle.core.model.Vehiclemanagement;
import com.accp.v.service.vehicle.core.util.PageUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.accp.v.service.vehicle.client.api.VehicleBaseService;
import com.accp.v.service.vehicle.client.model.Vehicle;
import com.accp.v.service.vehicle.core.dao.DictionaryMapper;
import com.accp.v.service.vehicle.core.model.Dictionary;
import org.springframework.stereotype.Service;


public class VehicleBaseServiceImpl implements VehicleBaseService {

    //字典
	@Autowired
	private DictionaryMapper dictionaryMapper;
	//车辆
    @Autowired
	private VehiclemanagementMapper vehiclemanagementMapper;

	private static Logger logger = Logger.getLogger(VehicleBaseServiceImpl.class);

	public static Map<String, Vehicle> vinVehicleMap = new HashMap<String, Vehicle>();

	public static Map<String, Vehicle> linceVehicleMap = new HashMap<String, Vehicle>();

	static {
		/*Vehicle v1 = new Vehicle();
		v1.setVin("MMV2ARB25G0010730");
		v1.setLince("京B12345");
		vinVehicleMap.put("MMV2ARB25G0010730", v1);
		linceVehicleMap.put("京B12345", v1);

		Vehicle v2 = new Vehicle();
		v2.setVin("MMV2ARB25G0010724");
		v2.setLince("京A88888");
		vinVehicleMap.put("MMV2ARB25G0010724", v2);
		linceVehicleMap.put("京A88888", v2);*/
	}


	public Vehicle getVehicleByVin(String vin) throws Exception {
		logger.info("getVehicleByVin(String vin),vin:" + vin);
		Dictionary dictionary = dictionaryMapper.selectByPrimaryKey(1);


		Vehicle vehicle = new Vehicle();
		vehicle.setLince(dictionary.getDicvalue());
		return vehicle;
	}

    public List<Dictionary> getVechicleAll() throws Exception {
        logger.info("getVehicleAll() 查询所有的车辆:" );

        List<Dictionary> list =dictionaryMapper.selectByVehiclerAll();
        System.out.println("All Vehicle");

        return list;
    }

    public PageUtil getVehiclemanagementPageUtil(int pageIndex, int pageSize, String... args) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",(pageIndex-1)*pageSize);//从第条数据开始
        map.put("pageSize",pageSize);


        PageUtil pageUtil=new PageUtil();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);

        int totalCount = vehiclemanagementMapper.getAccountPagrUtil(map);
        System.out.println(totalCount+"-->totalCount");
        int page=totalCount % pageSize ==0 ? totalCount / pageSize : totalCount / pageSize+1;
        System.out.println(page+"-->page");
        pageUtil.setTotalPages(page);
        pageUtil.setTotalRecords(totalCount);

        List<Vehiclemanagement> onePageData = vehiclemanagementMapper.getVehiclemanagementPageUtil(map);
        pageUtil.setList(onePageData);
        System.out.println(onePageData.size()+"aaaaaaaa");
        for (Vehiclemanagement item:onePageData){
            System.out.println(item.getId()+"====="+item.getCarlicense()+"===="+item.getVin()+"==="+item.getIccid()+"==="+item.getCartype()+"==="+item.getProvinces()+"==="+item.getCity());
        }
        return pageUtil;

    }


}
