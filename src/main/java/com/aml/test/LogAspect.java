package com.aml.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class LogAspect {
	
	@Pointcut("@annotation(com.aml.test.Log)")
	private void cut() { }    

	@Around("cut()")
	public void advice(ProceedingJoinPoint joinPoint){
	    System.out.println("环绕通知之开始1111");
	    try {
	        joinPoint.proceed();
	    } catch (Throwable e) {
	        e.printStackTrace();
	    }
	    System.out.println("环绕通知之结束111");
	}
}
