package com.spring.ex01;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpDAO {
	/**
	 * static : JVM(java.exe 부팅)이 실행될 때 
	 * 			new 하지 않고도 메모리에 바로 올라감
	 * static 메소드에서는 static만 사용할 수 있음
	 * 가능하면 사용할 때 class.변수 형태로 쓰자 
	 */
	private static SqlSessionFactory sqlMapper = null;
	public static SqlSessionFactory getInstance() {		// getInstance : 싱글톤 개념
		if(sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
//				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				sqlMapper = ssfb.build(reader);
				
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		return sqlMapper;
	}
	
	public List<EmpDTO> selectAllEmpList(){
		List<EmpDTO> empList = null;
		
		// getInstance()만 호출해도 
		// EmpDAO.sqlMapper = getInstance(); 가 되는데
		// 책에서는 return 받아서 쓰도록 되어있고 큰 의미는 없다
		// sqlMapper 는 
		// 지역변수와 겹치는 경우
		// 그냥 쓰거나 this.sqlMapper 보다는 EmpDAO.sqlMapper 로 쓰는게 더 좋다
		
		// SqlMapConfig.xml 을 읽어서 
		// DB에 접속할 정보를 얻어 옴
		sqlMapper = getInstance();
		
		// DB 접속 실시
		// 정보를 얻어오는 단계에서 오류가 나면 nullPointException 에러가 난다.
		SqlSession sqlSession = sqlMapper.openSession();
		// selectList에는 sql 문이 적혀있는 곳의 namespace.id 를 적어준다.
		empList = sqlSession.selectList("mapper.emp.selectAllEmpList");
		
		System.out.println("empList.size()" + empList.size());
		
		return empList;
	}
	
	public String selectEname() {
		String ename = null;
		
		try {
			sqlMapper = getInstance();
			if(sqlMapper != null) {
				SqlSession sqlSession = sqlMapper.openSession();
				ename = (String) sqlSession.selectOne("mapper.emp.selectEname");
			} else {
				System.out.println("DB접속 실패 오류");
			}
		} catch (Exception e) {
			
		}
		
		return ename;
	}
	
	public Map selectEmpMap() {
		Map scottMap = null;
		
		try {
			sqlMapper = getInstance();
			if(sqlMapper != null) {
				SqlSession sqlSession = sqlMapper.openSession();
				scottMap = (Map) sqlSession.selectOne("mapper.emp.selectEmpMap");
			} else {
				System.out.println("DB접속 실패 오류");
			}
		} catch (Exception e) {
			
		}
		
		return scottMap;
	}
	
	public List<EmpDTO> selectEmpResult(){
		List<EmpDTO> empList = null;

		sqlMapper = getInstance();

		SqlSession sqlSession = sqlMapper.openSession();
		empList = sqlSession.selectList("mapper.emp.selectEmpResult");
		
		System.out.println("empList2.size()" + empList.size());
		
		return empList;
	}

}
