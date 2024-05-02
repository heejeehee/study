package com.myspring.proj27.emp.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.myspring.proj27.emp.dao.EmpDAO;


@RunWith(SpringJUnit4ClassRunner.class) // 컨테이너 생성
@WebAppConfiguration // 다이나믹 웹 설정
@ContextConfiguration( // 사용할 bean들과 scan할 패키지 로딩
  locations = {
   "file:src/main/webapp/WEB-INF/spring/action-mybatis.xml"
   ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
  })

public class EmpServiceTest {
	@Autowired
	EmpDAO empDAO;

	@Test
	public void testListEmp() {
//		fail("Not yet implemented");
		
		int a = 10;
		String empno = "7900";
		
		List list = empDAO.selectEmpList();
		System.out.println("list.size = " + list.size()); // 146
		
		assertEquals(list.size(), 145);
	}

}
