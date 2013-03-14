package com.lee.study.util;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sessionFactory;
	
	static{
		try{
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取Session
	 * @return
	 */
	public static SqlSession createSession(){
		return sessionFactory.openSession();
	}
	/**
	 * 关闭Session
	 * @param session
	 */
	public static void closeSessioin(SqlSession session){
		if(session != null){
			session.close();
		}
	}
}
