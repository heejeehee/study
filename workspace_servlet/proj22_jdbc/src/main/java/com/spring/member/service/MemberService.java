package com.spring.member.service;

import com.spring.member.dao.MemberDAO;

public class MemberService {
	
	MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
}
