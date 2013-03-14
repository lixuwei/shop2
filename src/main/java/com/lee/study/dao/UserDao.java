package com.lee.study.dao;

import com.lee.study.domain.Pager;
import com.lee.study.domain.User;
/**
 * User的数据操作
 * @author AlexLee
 *
 */
public interface UserDao {
	
	void add(User user);
	void delete(int id);
	void update(User user);
	User loadByUsername(String username);
	User load(int id);
	User login(String username,String password);
	Pager<User> find(String name);
	
}
