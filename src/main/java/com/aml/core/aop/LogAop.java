package com.aml.core.aop;

import com.aml.annotion.BussinessLog;
import com.aml.core.aop.log.LogManager;
import com.aml.core.aop.log.factory.LogTaskFactory;
import com.aml.core.util.IpUtil;
import com.aml.sys.entity.ShiroUser;
import com.aml.sys.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * 日志记录
 *
 */
@Aspect
@Component
public class LogAop {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Pointcut(value = "@annotation(com.aml.annotion.BussinessLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
    	
        //先执行业务
        Object result = point.proceed();
        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录出错!", e);
        }
        return result;
        
    }

    private void handle(ProceedingJoinPoint point) throws Exception {
        //获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();
        //获取拦截方法的参数
//        String className = point.getTarget().getClass().getName();
        Object[] params = point.getArgs();
        //获取RequestAttributes  
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();  
        //从获取RequestAttributes中获取HttpServletRequest的信息  
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);  
        String path = request.getContextPath();
        //如果要获取Session信息的话，可以这样写：  
        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);  
        ShiroUser user = (ShiroUser) session.getAttribute("shiroUser");
        //获取操作名称
        BussinessLog annotation = currentMethod.getAnnotation(BussinessLog.class);
        String bussinessName = annotation.value();
        String key = annotation.key();
//        String keyParams ="";
        StringBuilder sb = new StringBuilder();
        for (Object param : params) {
        	if(param.equals(key)){
        		System.out.println("Param:"+param);
        	}
            sb.append(param);
            sb.append(" & ");
        }
        String msg = bussinessName+"操作"+sb;
        if(user!=null){
        	  LogManager.me().executeLog( LogTaskFactory.loginLog(user.getId(), IpUtil.getIpAddr(request)+methodName, msg, path, bussinessName));
        }else{
        	  LogManager.me().executeLog( LogTaskFactory.loginLog(0, IpUtil.getIpAddr(request)+methodName, msg, path, bussinessName));
        }
      
        //记录信息
        //LogManager.me().executeLog(LogTaskFactory.bussinessLog(user.getId(), bussinessName, className, methodName, msg));
    }
}