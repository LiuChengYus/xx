package com.accp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@SpringBootApplication
@MapperScan("com.accp.mapper")
public class SpringbootMybatisDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisDemoApplication.class, args);
	}
	@RequestMapping("/")
	String home() {
		return "index";
	}

}
