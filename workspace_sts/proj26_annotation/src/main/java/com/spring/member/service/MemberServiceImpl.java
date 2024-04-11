package com.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	MemberServiceImpl(){
		System.out.println("MemberServiceImpl 생성");
	}
	
	/**
	 * IoC (제어 역전)
	 * Inversion of Control
	 * 찾아서 new 까지 대신해줌
	 * 찾는것 : 등록된 bean중에서 형변환해서 지금 변수의 타입에 넣을 수 있는 bean 을 new해줌
	 */
	
	/**
	 * DI (의존성 주입)
	 * Dependency Injection
	 * 넣어주기
	 */
	
	@Autowired
	@Qualifier("memberDAOImpl")
	// 만약에 Autowired 의 대상이 두개 이상인 경우
	// 1. @Primary가 있는 객체 우선
	// 2. @Qualifier가 있는 경우 지정한 객체를 찾기
	// 3. @Qualifier가 없는 경우 변수명과 bean id 가 같은 객체를 찾는다
	
	
	
//	@Autowired
	// xml을 통해 bean을 주입하는 작업을 대신해준다.
	// 등록되어있는 모든 bean 을 찾는다.
	// MemberDAO 형태로 변경이 가능한 것들을 전부 골라낸다
	// 자동으로 new 한 후에 주입시켜준다
	private MemberDAO memberDAO;
	
	@Override
	public List listMembers() {
		return memberDAO.selectMember();
	}

}
