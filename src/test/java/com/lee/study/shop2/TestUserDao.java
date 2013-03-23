package com.lee.study.shop2;

import org.junit.Test;

import com.lee.study.dao.impl.UserDaoImpl;
import com.lee.study.domain.Pager;
import com.lee.study.domain.SystemContext;
import com.lee.study.domain.User;

/**
 * 测试分页，主要测试的是分页方法
 * @author lee
 *	
 * 2013-3-14  下午10:38:22
 */
public class TestUserDao {
	
	
	public void testFind(){
		UserDaoImpl ud = new UserDaoImpl();
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(2);
		SystemContext.setSort("id");
		SystemContext.setOrder("desc");
		Pager<User> pager = ud.find("lixu");
		System.out.println(pager.getTotalRecord());
		for (User user : pager.getDatas()) {
			System.out.println(user);
		}
	}
}
