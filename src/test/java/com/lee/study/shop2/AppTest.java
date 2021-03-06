package com.lee.study.shop2;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.lee.study.dao.impl.UserDaoImpl;
import com.lee.study.domain.Address;
import com.lee.study.domain.User;


/**
 * Unit test UserDao for simple App.
 */
public class AppTest {
	
	public SqlSession sqlSession = null;

	
	@Before
	public void init(){
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
			sqlSession =  sessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   
	
	public void testAdd(){
		User user = new User();
		user.setNickname("wukong");
		user.setUsername("lixuwei2");
		user.setPassword("werwe");
		user.setType(1);
		
		sqlSession.insert("com.lee.study.domain.User.add",user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void testAdd2(){
		User user = new User();
		user.setNickname("wukong");
		user.setUsername("lixuwei2");
		user.setPassword("werwe");
		user.setType(1);
		
		UserDaoImpl daoImpl = new UserDaoImpl();
		daoImpl.add(user);
	}
	/**
	 * 
	 */
	
	public void testDelete(){
		/**
		 * execute delete method
		 */
		sqlSession.delete(User.class.getName()+".delete",2);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void testFindUserById(){
		User user = (User)sqlSession.selectOne(User.class.getName()+".load",1);
		System.out.println(user);
	}
	@Test
	public void testFindAddressById(){
		Address address = sqlSession.selectOne("com.lee.study.domain.Address.load",2);
		System.out.println(address);
	}
	
	public void testFindUserByUsername(){
		User user = (User)sqlSession.selectOne(User.class.getName()+".load_by_username","lixuwei2");
		System.out.println(user);
	}
	
}
