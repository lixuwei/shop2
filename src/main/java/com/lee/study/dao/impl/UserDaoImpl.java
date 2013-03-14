package com.lee.study.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.lee.study.dao.UserDao;
import com.lee.study.domain.Pager;
import com.lee.study.domain.ShopException;
import com.lee.study.domain.User;
import com.lee.study.util.MyBatisUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public void add(User user) {
		User load = this.loadByUsername(user.getUsername());
		if(load == null){
			new ShopException("要添加的用户已经存在");
		}
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.insert(User.class.getName()+".add",user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSessioin(session);
		}
	}

	@Override
	public void delete(int id) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.delete(User.class.getName()+".delete",id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally{
			MyBatisUtil.closeSessioin(session);
		}
	}

	@Override
	public void update(User user) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.update(User.class.getName()+".update",user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally{
			MyBatisUtil.closeSessioin(session);
		}
	}

	@Override
	public User loadByUsername(String username) {
		SqlSession session = null;
		User u = null;
		try {
			session = MyBatisUtil.createSession();
			u = (User)session.selectOne(User.class.getName()+".load_by_username",username);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			MyBatisUtil.closeSessioin(session);
		}
		return u;
	}

	@Override
	public User load(int id) {
		SqlSession session = null;
		User u = null;
		try {
			session = MyBatisUtil.createSession();
			u = (User)session.selectOne(User.class.getName()+".load",id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			MyBatisUtil.closeSessioin(session);
		}
		return u;
	}

	@Override
	public Pager<User> find(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String password) {
		User u = this.loadByUsername(username);
		if(u == null){
			new ShopException("该用户不存在");
		} else {
			if(!u.getPassword().equalsIgnoreCase(password)){
				new ShopException("输入的密码不正确");
			}
		}
		return u;
	}

}
