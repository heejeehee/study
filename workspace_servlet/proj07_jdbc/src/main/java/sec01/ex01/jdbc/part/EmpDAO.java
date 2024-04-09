package sec01.ex01.jdbc.part;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Data Access Object
public class EmpDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
	private String user = "scott4_5";
	private String password = "tiger";
	
	private Connection conn;	// 1. 필드에 따로 빼는 방식
	
	private void connDB() {
		// this.conn = null;	// 2번 방식
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return conn		// 2. return 값으로 돌려주는 방식
	}
	
	public List listEmp() {
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
		
		return list;
		
	}
}
