package com.zerovso.spring.configure.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class BaseServiceAdvice {
	
	/**
	 * <p>Title: beforeService</p> 
	 * <p>Description: 前置</p>  
	 * @param joinPoint 切入点 或者 连接点
	 */
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
	public void afterService(JoinPoint joinPoint) {
		System.out.println("后置增强");
	}

	/**
	 * <p>Title: aroundService</p> 
	 * <p>Description: 环绕</p>  
	 * @param joinPoint 切入点
	 */
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
	public void returnService(JoinPoint joinPoint,Object name) {
		System.out.println("返回值增强");
	}
	
	/**
	 * <p>Title: exService</p> 
	 * <p>Description: 异常</p>  
	 * @param joinPoint 切入点
	 * @param ex 异常信息
	 */
	public void exService(JoinPoint joinPoint,Throwable ex) {
		System.out.println("异常增强");
	}
	

}
