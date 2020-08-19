package com.zerovso.spring.annotation.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zerovso.spring.annotation.dao.BaseDao;
import com.zerovso.spring.annotation.service.BaseService;

@Service("baseService")
public class BaseServiceImpl implements BaseService {
	
	@Resource
	@Qualifier("dao") //加上这个就是ByName,不加上这个就是ByType
	private BaseDao baseDao; 
	
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
