package com.spring.test01;

public interface Authenticator {
	
	public void authen(String userId, String userPw) throws UserException;
	
}