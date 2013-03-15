package com.lee.study.dao.impl;

import com.lee.study.basedao.BaseDao;
import com.lee.study.dao.UserDao;
import com.lee.study.domain.Pager;
import com.lee.study.domain.User;

public class UserServiceImpl extends BaseDao<User> implements UserDao {

	@Override
	public User loadByUsername(String username) {
		return null;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<User> find(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
