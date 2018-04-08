package cn.happy.contoller;

import com.accp.v.service.vehicle.client.api.ModelManagementService;
import com.accp.v.service.vehicle.core.model.Modelmanagement;
import com.accp.v.service.vehicle.core.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
//接口

@Controller
@RequestMapping(value = "/Model")
public class ModelManagementContoller {
   @Autowired
    public ModelManagementService modelManagementService;


        @RequestMapping(value = "/getModelDataPageUtil")
        @ResponseBody
            public Object forstcontoller(HttpSession session, HttpServletResponse response,@RequestParam(defaultValue = "1", value = "page")int pageIndex, @RequestParam(defaultValue = "2",value = "rows")int pageSize, @RequestParam(required = false) String cartype){
               response.setCharacterEncoding("UTF-8");
               System.out.println("车型"+cartype);
                session.setAttribute("cartype",cartype);
                Map<String,Object> map=new HashMap<String,Object>();
                PageUtil<Modelmanagement> onePageData = modelManagementService.getModelmanagementPageUtil(pageIndex,pageSize,cartype);
                map.put("total",onePageData.getTotalRecords());
                map.put("rows",onePageData.getList());

                return map;
            }

    }
