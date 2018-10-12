package com.zbank.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;

@Controller
public class MyAop {
	
	//在方法上面使用注解完成增强操作
//	@Before(value="execution(* com.zbank.controller.SystemController.*(..))")
	public void before(){
		System.out.println("前置增强！！！！！！！！！！");
	}
	public void after(){
		System.out.println("后置增强！！！！！！！！！！");
	}
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("环绕增强！！！之前！！！！");
		
		proceedingJoinPoint.proceed();
		System.out.println("环绕增强！！！之后！！！！！");
	}
}
