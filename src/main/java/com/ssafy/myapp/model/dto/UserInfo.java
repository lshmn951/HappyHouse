package com.ssafy.myapp.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class UserInfo implements Serializable, Comparable<UserInfo>{
	private String userId;
	private String userPw;
	private String userName;
	private String address;
	private String phone;
	private int assets;
	private int salary;
	
	public UserInfo(){};
	
	
	public UserInfo(String userId, String userPw, String userName, String address, String phone) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.address = address;
		this.phone = phone;
	}

	public UserInfo(String userId, String userPw, String userName, String address, String phone, int assets,
			int salary) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.address = address;
		this.phone = phone;
		this.assets = assets;
		this.salary = salary;
	}

	

	public int getAssets() {
		return assets;
	}


	public void setAssets(int assets) {
		this.assets = assets;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int compareTo(UserInfo o) {
		
		if(o!=null && o.userId != null&&userId!=null) {
			return userId.compareTo(o.userId);
		}
		return 0;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName 
				+ ", address=" + address + ", phone=" + phone + "]";
	}
	
	
}
