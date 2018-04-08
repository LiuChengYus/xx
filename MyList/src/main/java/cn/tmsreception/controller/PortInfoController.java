package cn.tmsreception.controller;

import cn.tmsreception.service.IPortInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 17921 on 2017/12/12.
 */
@Controller
public class PortInfoController {

    @Resource(name = "PortInfoService")
    private IPortInfoService portInfoService;



    //查询所有港口
    @RequestMapping("/findallPort")
    @ResponseBody
    public Object findallPort(){
        return portInfoService.findallPort();
    }








    public IPortInfoService getPortInfoService() {
        return portInfoService;
    }

    public void setPortInfoService(IPortInfoService portInfoService) {
        this.portInfoService = portInfoService;
    }
}
