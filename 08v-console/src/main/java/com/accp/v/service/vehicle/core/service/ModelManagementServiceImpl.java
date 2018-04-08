package com.accp.v.service.vehicle.core.service;


import com.accp.v.service.vehicle.client.api.ModelManagementService;
import com.accp.v.service.vehicle.core.dao.ModelmanagementMapper;

import com.accp.v.service.vehicle.core.model.Modelmanagement;
import com.accp.v.service.vehicle.core.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("modelManagementService")
public class ModelManagementServiceImpl implements ModelManagementService {

    //车辆
    @Autowired
    private ModelmanagementMapper modelmanagementMapper;

    public List<Modelmanagement> getModelmanagementAll() throws Exception {
        return null;
    }

    public PageUtil getModelmanagementPageUtil(int pageIndex, int pageSize,String cartype) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",(pageIndex-1)*pageSize);//从第条数据开始
        map.put("pageSize",pageSize);
        map.put("carType",cartype);

        PageUtil pageUtil=new PageUtil();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);

        int totalCount = modelmanagementMapper.getAccountModelmanagementAll(map);
        System.out.println(totalCount+"-->totalCount");
        int page=totalCount % pageSize ==0 ? totalCount / pageSize : totalCount / pageSize+1;
        System.out.println(page+"-->page");
        pageUtil.setTotalPages(page);
        pageUtil.setTotalRecords(totalCount);

        List<Modelmanagement> onePageData = modelmanagementMapper.getModelmanagementPageUtil(map);
        pageUtil.setList(onePageData);
        System.out.println(onePageData.size()+"集合大小");
        for (Modelmanagement item:onePageData){
            System.out.println(item.getId());
            System.out.println(item.getCartype());
            System.out.println(item.getAnnouncement());
            System.out.println(item.getMileage());
            System.out.println(item.getTopspeed());
            System.out.println(item.getLength());
            System.out.println(item.getWidth());
            System.out.println(item.getWeigth());
            System.out.println(item.getSeatnumber());
            System.out.println(item.getDoornum());
        }
        return pageUtil;
    }
}
