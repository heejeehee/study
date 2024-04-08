package com.spring.test01;

public class UserException extends Exception {
	
	public UserException(String str) {
		super(str);
		System.out.println("UserException > UserException super");
	}
	
}
