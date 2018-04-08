package com.accp.v.service.vehicle.client;

import com.accp.v.service.vehicle.client.api.ModelManagementService;
import com.accp.v.service.vehicle.core.model.Modelmanagement;
import com.accp.v.service.vehicle.core.util.PageUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by CY on 2018/1/18.
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring.xml");// 此文件

        ModelManagementService modelManagementService = (ModelManagementService) context.getBean("modelManagementService");
        try {
             List<Modelmanagement> list=modelManagementService.getModelmanagementPageUtil(1, 2,null).getList();
            for (Modelmanagement item:list){
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

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
