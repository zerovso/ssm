package com.zerovso.spring.annotation.dao.impl;

import org.springframework.stereotype.Repository;

import com.zerovso.spring.annotation.dao.BaseDao;

@Repository("dao")
public class BaseDaoImpl implements BaseDao {

	@Override
	public void test() {
		System.out.println("dao 被调用了！");
	}

	@Override
	public void adviceTest(int args1, int args2) {
		System.out.println("dao 的  adviceTest方法被调用了！");
	}


}
