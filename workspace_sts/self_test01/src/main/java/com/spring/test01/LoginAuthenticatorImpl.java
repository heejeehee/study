package com.spring.test01;

public class LoginAuthenticatorImpl implements Authenticator {

	@Override
	public void authen(String userId, String userPw) throws UserException {
		
		if(!"admin".equals(userId) || !"1234".equals(userPw)) {
			throw new UserException("인증받지 않은 접근");
		}

	}

}
