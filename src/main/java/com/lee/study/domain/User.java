package com.lee.study.domain;

import java.io.Serializable;
import java.util.List;

/**
 * User Entity
 * @author AlexLee
 *
 */
public class User implements Serializable{
    

	private static final long serialVersionUID = 1237851749321188777L;
	
	private int id;
	private String username;
	private String password;
	private String nickname;
	private int type;
	private List<Address> addresses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", type=" + type
				+ ", addresses=" + addresses + "]";
	}
	
}
