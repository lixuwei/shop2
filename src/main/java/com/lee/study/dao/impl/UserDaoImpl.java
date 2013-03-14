package com.lee.study.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lee.study.dao.UserDao;
import com.lee.study.domain.Pager;
import com.lee.study.domain.ShopException;
import com.lee.study.domain.SystemContext;
import com.lee.study.domain.User;
import com.lee.study.util.MyBatisUtil;
/**
 * UserDao的数据操作接口实现
 * @author lee
 *	
 * 2013-3-14  下午10:15:24
 */
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
		
		int pageSize = SystemContext.getPageSize();
		int pageOffset = SystemContext.getPageOffset();
		String sort = SystemContext.getSort();
		String order = SystemContext.getOrder();
		Pager<User> pages = new Pager<User>();
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.createSession();
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("name", "%"+name+"%");
			params.put("pageSize", pageSize);
			params.put("pageOffset", pageOffset);
			params.put("sort", sort);
			params.put("order", order);
			List<User> datas = sqlSession.selectList(User.class.getName()+".find", params);
			pages.setDatas(datas);
			pages.setPageSize(pageSize);
			pages.setPageOffset(pageOffset);
			
			int totalRecord = sqlSession.selectOne(User.class.getName()+".find_count", params);
			pages.setTotalRecord(totalRecord);
		} finally {
			MyBatisUtil.closeSessioin(sqlSession);
		}
		
		return pages;
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
