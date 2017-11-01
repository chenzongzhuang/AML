package com.aml.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopControll {
	
	@RequestMapping(value = "/logins")
    public String run(){
        System.out.println("测试");
        return "Controller completed!";
    }
}
