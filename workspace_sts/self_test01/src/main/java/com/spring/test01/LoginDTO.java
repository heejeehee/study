package com.spring.test01;

public class LoginDTO {

	private String userId;
	private String userPw;
	private String userType;
	
	
	public String getUserId() {
		System.out.println("getUserId");
		return userId;
	}
	public void setUserId(String userId) {
		System.out.println("setUserId");
		this.userId = userId;
	}
	public String getUserPw() {
		System.out.println("getUserPw");
		return userPw;
	}
	public void setUserPw(String userPw) {
		System.out.println("userPw");
		this.userPw = userPw;
	}
	public String getUserType() {
		System.out.println("getUserType");
		return userType;
	}
	public void setUserType(String userType) {
		System.out.println("setUserType");
		this.userType = userType;
	}
	
	
	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", userPw=" + userPw + ", userType=" + userType + "]";
	}
	
}
