package com.accp.v.service.vehicle;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




/**
 * Hello world!
 *
 */
public class Main {
	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring.xml");// 此文件
		logger.info("[车辆基础服务][服务启动成功]");


		try {
			while (true) {
				Thread.sleep(10000);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
