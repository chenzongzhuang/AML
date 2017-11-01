package com.aml.core.aop.log.factory;


import java.sql.Timestamp;
import java.util.Date;

import com.aml.sys.entity.LoginLog;

/**
 * 日志对象创建工厂
 */
public class LogFactory {

    /**
     * 创建登录日志
     *
     */
    public static LoginLog createLoginLog(String oper, Integer userId, String msg,String ip,String url) {
        LoginLog loginLog = new LoginLog();
        loginLog.setLogname(oper);
        loginLog.setUserid(userId);
        loginLog.setCreatetime(new Timestamp(new Date().getTime()));
        loginLog.setSucceed("成功");
        loginLog.setIp(ip);
        loginLog.setUrl(url);
        loginLog.setMessage(msg);
        return loginLog;
    }
}
