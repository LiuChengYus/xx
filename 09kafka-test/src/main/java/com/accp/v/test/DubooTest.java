package com.accp.v.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accp.v.service.vehicle.client.api.VehicleBaseService;
import com.accp.v.service.vehicle.client.model.Vehicle;

/**
 * Hello world!
 *
 */
public class DubooTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring.xml");// 此文件

		VehicleBaseService vehicleBaseService = (VehicleBaseService) context
				.getBean("vehicleBaseService");
		try {
			long time1=System.currentTimeMillis();
			Vehicle v = vehicleBaseService.getVehicleByVin("MMV2ARB25G0010730");
			System.out.println(v.getLince());
			long time2=System.currentTimeMillis();
			System.out.print("第一个接口调用用时："+(time2-time1));
			Vehicle v1 = vehicleBaseService.getVehicleByVin("MMV2ARB25G0010730");
			System.out.println(v1.getLince());
			long time3=System.currentTimeMillis();
			System.out.print("第二个接口调用用时："+(time3-time2));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
