package com.lee.study.domain;

import java.io.Serializable;
/**
 * Category Entity
 * 种类实体
 * @author lee
 *	
 * 2013-3-13  下午11:09:23
 */
public class Category implements Serializable{


	private static final long serialVersionUID = -4831138279110079924L;

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
