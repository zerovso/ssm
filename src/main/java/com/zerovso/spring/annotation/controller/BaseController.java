package com.zerovso.spring.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zerovso.spring.annotation.service.BaseService;

@Controller
@Scope("prototype") // 多例 ， 不使用则为单例
public class BaseController {
	
	@Autowired
	private BaseService baseService;
	
	public void test() {
		baseService.test();
	}
	
	public void adviceTest(int args1,int args2) throws Exception {
		baseService.adviceTest(args1, args2);
	}
}
