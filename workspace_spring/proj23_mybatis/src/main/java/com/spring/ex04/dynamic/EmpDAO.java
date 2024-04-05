package com.spring.ex04.dynamic;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpDAO {
	
	private static SqlSessionFactory sqlMapper = null;
	public static SqlSessionFactory getInstance() {		// getInstance : 싱글톤 개념
		if(sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				sqlMapper = ssfb.build(reader);
				
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		return sqlMapper;
	}

	public List getEmpList(EmpDTO dto) {
		List list = null;
		
		try {
			sqlMapper = getInstance();
			if(sqlMapper != null) {
				SqlSession sqlSession = sqlMapper.openSession();
//				list = sqlSession.selectList("mapper.emp.dynamic.selectEmp", dto);
				list = sqlSession.selectList("mapper.emp.dynamic.selectEmp2", dto);
			} else {
				System.out.println("DB접속 실패 오류");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
