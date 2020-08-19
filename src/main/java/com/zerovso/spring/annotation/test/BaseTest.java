package com.zerovso.spring.annotation.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zerovso.spring.annotation.controller.BaseController;
import com.zerovso.spring.annotation.service.BaseService;

public class BaseTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application_annotation.xml");
		System.out.println("========================IOC========================");
		BaseController bc = (BaseController) context.getBean("baseController");
		bc.test();
		
		bc.adviceTest(3, 4);
		
		System.out.println("========================AOP========================");
		BaseService bs = (BaseService) context.getBean("baseService");
		bs.adviceTest(5, 6);
	}
}
