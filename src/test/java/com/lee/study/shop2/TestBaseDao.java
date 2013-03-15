package com.lee.study.shop2;

import org.junit.Test;

import com.lee.study.dao.impl.UserServiceImpl;
import com.lee.study.domain.User;

public class TestBaseDao {

	@Test
	public void testBaseDao(){
		
		UserServiceImpl us = new UserServiceImpl();
		User load = us.load(3);
		System.out.println(load);
		
	}
}
