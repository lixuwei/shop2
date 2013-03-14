package com.lee.study.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * Order Entity
 * 订单实体
 * @author lee
 *	
 * 2013-3-13  下午11:14:55
 */
public class Orders implements Serializable{

	
	private static final long serialVersionUID = -6764889748785633705L;
	
	private int id;
	private Date buyDate;
	private Date payDate;
	private Date confirmData;
	private int status;
	private User user;
	private Address address;
	private List<Goods> goods;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getConfirmData() {
		return confirmData;
	}
	public void setConfirmData(Date confirmData) {
		this.confirmData = confirmData;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	
	
}
