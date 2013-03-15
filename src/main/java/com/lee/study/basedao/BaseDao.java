package com.lee.study.basedao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.lee.study.domain.Pager;
import com.lee.study.util.MyBatisUtil;

/**
 * <p>
 * 操作泛型，使一般的数据操作放入到BaseDao中来实现，
 * 但是这就要求我们按照约定优于配置的原则，来配置Mapper
 * </p>
 * 例如:<br/>
 * 		Mapper中的namespace,都为实体对象的权限定名<br/>
 *      普通的insert方法，在Mapper中都使用add
 * 		
 * @author AlexLee
 *
 * @param <T>
 * 
 */
public class BaseDao<T> {

	/**
	 * 子类的泛型Class对象
	 */
	private Class<T> clazz = null;
	/**
	 * 父类的构造函数，最先执行.因此我们可以通过构造函数
	 * 得到子类的字节码对象
	 */
	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type type = this.getClass().getGenericSuperclass();
		if(type instanceof ParameterizedType){
			
			ParameterizedType pType = (ParameterizedType) type;
			clazz = (Class<T>) pType.getActualTypeArguments()[0];
		}
	}
	/**
	 * 添加一个实体对象
	 * @param t  实体
	 */
	public void add(T t){
		
		SqlSession session = null;
		
		try {
			
			session = MyBatisUtil.createSession();
			session.insert(clazz.getName()+".add",t);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSessioin(session);
		}
	}
	/**
	 * 更新一个实体对象
	 * @param t 实体
	 */
	public void update(T t){
		
		SqlSession session = null;
		
		try {
			
			session = MyBatisUtil.createSession();
			session.update(clazz.getName()+".update",t);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSessioin(session);
		}
	}
	/**
	 * 删除一个实体对象
	 * @param id 实体ID
	 */
	public void delete(int id){
		
		SqlSession session = null;
		
		try {
			
			session = MyBatisUtil.createSession();
			session.delete(clazz.getName()+".delete",id);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			MyBatisUtil.closeSessioin(session);
		}
	}
	
	/**
	 * 根据ID返回一个实体对象
	 * @param id 实体ID
	 * @return entity
	 */
	public T load(int id){
		
		SqlSession session = null;
		T entity = null;
		try {
			
			session = MyBatisUtil.createSession();
			entity = session.selectOne(clazz.getName()+".load",id);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSessioin(session);
		}
		return entity;
	}
	/**
	 * 获取分页数据
	 * @param params  分页+排序+条件等参数
	 * @return        分页的Pager实体
	 */
	public Pager<T> find(Map<String,Object> params){
		SqlSession session = null;
		Pager<T> pagers = null;
		try {
			pagers = new Pager<T>();
			session = MyBatisUtil.createSession();
			if(params != null){
				List<T> datas = session.selectList(clazz.getName()+".find", params);
				pagers.setDatas(datas);
				int totalRecord = session.selectOne(clazz.getName()+".find_count",params);
				pagers.setTotalRecord(totalRecord);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagers;
	}
}
