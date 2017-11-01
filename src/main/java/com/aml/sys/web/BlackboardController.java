package com.aml.sys.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hb on 2017/10/5.
 */
@Controller
@RequestMapping(value = "/blackboard")
public class BlackboardController {

    private static final Logger LOGGER = Logger.getLogger(BlackboardController.class);

    @RequestMapping("")
    public String blackboard(){
        LOGGER.info("开始加载主页！");
        return "/blackboard";
    }
}
