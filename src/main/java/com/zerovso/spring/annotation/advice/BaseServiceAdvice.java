package com.zerovso.spring.annotation.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>Title: BaseServiceAdvice</p>  

 * <p>Description: 增强类</p>  

 * @author lingmo 
 
 * @date 2020-8-19  
 */

@Component // 指定该类为普通bean
@Aspect //指定为增强类
public class BaseServiceAdvice {
	
	// 切入点 通过定义方法的方式来定义切入点
	@Pointcut("execution(public * com.zerovso.spring.annotation.service.impl.*.adviceTest(..))")
	public void myPointcut(){}

	/**
	 * <p>Title: beforeService</p> 
	 * <p>Description: 前置</p>  
	 * @param joinPoint 切入点 或者 连接点
	 */
	@Before("myPointcut()")
	public void beforeService(JoinPoint joinPoint) {
		System.out.println("前置增强");
		
		System.out.println("连接点对象："+joinPoint.getTarget().getClass().getSimpleName());
		System.out.println("连接点方法："+joinPoint.getSignature());
		System.out.println("连接点方法参数："+Arrays.toString(joinPoint.getArgs()));

	}
	
	/**
	 * <p>Title: afterService</p> 
	 * <p>Description: 后置</p>  
	 * @param joinPoint 切入点 或者 连接点
	 */
	@After("myPointcut()")
	public void afterService(JoinPoint joinPoint) {
		System.out.println("后置增强");
	}

	/**
	 * <p>Title: aroundService</p> 
	 * <p>Description: 环绕</p>  
	 * @param joinPoint 切入点
	 */
	@Around("myPointcut()")
	public void aroundService(ProceedingJoinPoint joinPoint) {
		System.out.println("环绕增强");
		System.out.println("环绕增强前......");
		try {
			Object obj = joinPoint.proceed(joinPoint.getArgs()); // 执行切面
			System.out.println("获取切面执行的返回值："+obj);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("环绕增强后......");
	}
	
	/**
	 * <p>Title: returnService</p> 
	 * <p>Description: 返回值</p>  
	 * @param joinPoint 切入点
	 * @param name 返回值
	 */
	@AfterReturning(pointcut="myPointcut()",returning="name")
	public void returnService(JoinPoint joinPoint,Object name) {
		System.out.println("返回值增强");
	}
	
	/**
	 * <p>Title: exService</p> 
	 * <p>Description: 异常</p>  
	 * @param joinPoint 切入点
	 * @param ex 异常信息
	 */
	@AfterThrowing(pointcut="myPointcut()",throwing="ex")
	public void exService(JoinPoint joinPoint,Throwable ex) {
		System.out.println("异常增强");
	}
}
