package com.lee.study.domain;

import java.io.Serializable;
/**
 * Goods Entity
 * 商品实体
 * @author lee
 *	
 * 2013-3-13  下午11:13:50
 */
public class Goods implements Serializable{

	private static final long serialVersionUID = 5747727523101471169L;

	private int id;
	private String name;
	private double price;
	private String intro;
	private String img;
	private int stock;
	private Category category;
	
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
