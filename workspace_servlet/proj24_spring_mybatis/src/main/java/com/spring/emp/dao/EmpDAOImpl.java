package com.spring.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpDAOImpl implements EmpDAO{
	private SqlSession sqlSession;

	EmpDAOImpl(){
		System.out.println("EmpDAOImpl 생성");
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("EmpDAOImpl > setSqlSession 실행");
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List selectEmp() {
		// DB연결 준비
		// DB연결
		// SQL 실행
		// 결과 확보
		// 를 전부 해 줌
		return sqlSession.selectList("mapper.emp.selectEmp");
	}
}
