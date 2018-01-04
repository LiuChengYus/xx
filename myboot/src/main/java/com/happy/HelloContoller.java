package com.happy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CY on 2017/12/29.
 */
@RestController
public class HelloContoller {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "Hello Spring Boot";
    }
}
