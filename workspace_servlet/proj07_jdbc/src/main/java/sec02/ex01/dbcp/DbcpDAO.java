package sec02.ex01.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import sec01.ex01.jdbc.part.EmpDTO;

public class DbcpDAO {
	
	private Connection conn;

	void connDB(){
		try {
			// context.xml 에 적은 데이터를 자바로 가져오는 과정
			Context ctx = new InitialContext();
			// context.xml Resource 요소의 name 속성과 동일해야 한다.
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/OracleDB");
			this.conn = dataFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List listEmp() {
		
		long begin = System.currentTimeMillis();
		
		connDB();	// 1번 방식 (반드시 호출해 주어야 함)
		// Connection conn = connDB();		// 2번 방식
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List list = new ArrayList();
		
		try {
			String query = "select * from emp2";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				
				System.out.println("------------------------");
				
				System.out.println("ename : \t" + ename);
				System.out.println("empno : \t" + empno);
				System.out.println("sal : \t\t" + sal);
				
				System.out.println("------------------------");
				
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);
				empDTO.setSal(sal);
				
				list.add(empDTO);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			
			if(this.conn != null) {
				try {
					this.conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
			
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
		return list;
		
	}
	
	
}
