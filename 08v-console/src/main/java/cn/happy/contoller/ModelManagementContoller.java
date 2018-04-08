package cn.happy.contoller;
import com.accp.v.service.vehicle.client.api.VehicleBaseService;
import com.accp.v.service.vehicle.core.model.Dictionary;
import com.accp.v.service.vehicle.core.model.Vehiclemanagement;
import com.accp.v.service.vehicle.core.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//接口

@Controller
@RequestMapping(value = "/vehicle")
public class VehicleContoller {
   @Autowired
    public VehicleBaseService vehicleBaseService;


        @RequestMapping(value = "/getVehicleDataPageUtil")
        @ResponseBody
            public Object forstcontoller(@RequestParam(defaultValue = "1", value = "page")int pageIndex, @RequestParam(defaultValue = "2",value = "rows")int pageSize){
                System.out.println(1);
                Map<String,Object> map=new HashMap<String,Object>();
                PageUtil<Vehiclemanagement> onePageData = vehicleBaseService.getVehiclemanagementPageUtil(pageIndex,pageSize);
                map.put("total",onePageData.getTotalRecords());
                map.put("rows",onePageData.getList());
                System.out.println(2);
                return map;
            }

    }
