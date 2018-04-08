package cn.tmsreception.controller;

import cn.tmsreception.entity.WeekVentory;
import cn.tmsreception.service.IWeekVentoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.bind.SchemaOutputResolver;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 17921 on 2017/12/12.
 */
@Controller
public class WeekVentoryController {
    @Resource(name = "WeekVentoryService")
    private IWeekVentoryService weekVentoryService;


    @RequestMapping("/findAllWeekList")
    @ResponseBody
    public Object getWeekList(String infoCode){
        List<WeekVentory> weekVentory = weekVentoryService.getWeekVentoryDAOByInfocode(infoCode);
        return weekVentory;
    }
@RequestMapping("/findAllWeekBycode")
    @ResponseBody
    public Object getweekByinfoCodeandlumpcode(@RequestParam(defaultValue = "ELHT") String port,@RequestParam(defaultValue="LYSYM",required = false) String typecode){

    System.out.println(port);
    System.out.println(typecode);
        List<WeekVentory> weekVentories = weekVentoryService.getWeekByInfoCodeandLumpcode(port, typecode);
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");
        List<String> pubtime=new ArrayList<String>();
        List<String> price=new ArrayList<String>();

        for (WeekVentory item:weekVentories){
            String str=sdf.format(item.getPubtime());
            pubtime.add(str);
            price.add(Double.toString(item.getPrice()));

        }
    Map<String,Object> map=new HashMap<String, Object>();
        map.put("pubtime",pubtime);
        map.put("prices",price);

            return map;
    }







    public IWeekVentoryService getWeekVentoryService() {
        return weekVentoryService;
    }

    public void setWeekVentoryService(IWeekVentoryService weekVentoryService) {

        this.weekVentoryService = weekVentoryService;
    }
}
