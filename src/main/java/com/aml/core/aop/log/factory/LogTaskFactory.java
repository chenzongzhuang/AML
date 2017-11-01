package com.aml.core.aop.log.factory;

import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aml.core.util.SpringContextHolder;
import com.aml.sys.entity.LoginLog;
import com.aml.sys.service.ILogService;
import com.aml.sys.service.impl.LogServiceImpl;

import java.util.TimerTask;

/**
 * 日志操作任务创建工厂
 *
 */
public class LogTaskFactory {
    private static Logger logger = LoggerFactory.getLogger(LogManager.class);
    @Autowired
    private static ILogService logServiceImpl = SpringContextHolder.getBean(LogServiceImpl.class);
    public static TimerTask loginLog(final Integer userId, final String ip,final String msg,final String url,final String operName) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    LoginLog loginLog = LogFactory.createLoginLog(operName, userId, msg, ip,url);
                    logServiceImpl.insertOpLog(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录日志异常!", e);
                }
            }
        };
    }

}
