package com.zerovso.spring.configure.service.impl;

import com.zerovso.spring.configure.dao.BaseDao;
import com.zerovso.spring.configure.service.BaseService;

public class BaseServiceImpl implements BaseService {

	private BaseDao baseDao;
	
	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	// 切面:面向切面编程
	@Override
	public void test() {
		System.out.println("service 被调用了！");
		baseDao.test();
	}
	
	// 切面:面向切面编程
	@Override
	public String adviceTest(int args1, int args2) throws Exception {
		System.out.println("service 的  adviceTest方法被调用了！");
//		throw new Exception();
		return "return test";
	}

}
