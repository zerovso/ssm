package com.zerovso.spring.configure.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zerovso.spring.configure.controller.BaseController;
import com.zerovso.spring.configure.service.BaseService;

public class BaseTest {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application_configure.xml");
		System.out.println("========================IOC========================");
		BaseController bc = (BaseController) context.getBean("baseController");
		bc.test();
		System.out.println("========================AOP========================");
		BaseService bs = (BaseService) context.getBean("baseService");
		bs.adviceTest(1, 2);
		
	}

}
