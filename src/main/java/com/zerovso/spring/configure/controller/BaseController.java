package com.zerovso.spring.configure.controller;

import com.zerovso.spring.configure.service.BaseService;

public class BaseController {

	private BaseService baseService;
	
	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public void test() {
		baseService.test();
	}
	
	public void adviceTest(int args1,int args2) throws Exception {
		baseService.adviceTest(args1, args2);
	}
	
}
