package kr.or.human.emp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.human.emp.dto.EmpDTO;

// Data Access Object
public class EmpDAO {

	// select
//	public List selectEmp(String ename, int deptno) {
	public List selectEmp(EmpDTO empDTO) {
		List list = new ArrayList();
		// DB 접속
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "Scott4_5";
		String password = "tiger";

		// driver 로딩
		// Class.forName() : String 변수로 Class 생성
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");

			// SQL 만들기
			String query = "";
			query += " select";
			query += " *";
			query += " from";
			query += " emp2";
			query += " where 1=1";
			query += " and lower(ename) like '%' || lower(?) || '%'";

			if(empDTO.getDeptno() != -1) {
				query += " and deptno = ?";				
			}
			System.out.println("query : " + query);

			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(1, ename);
//			ps.setInt(2, deptno);
			ps.setString(1, empDTO.getEname());
			if(empDTO.getDeptno() != -1) {
				ps.setInt(2, empDTO.getDeptno());
			}
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();

			// 결과 활용
//			List list = new ArrayList();	// 위로 옮겼음. 그냥 처음부터 선언함
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename2 = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");

//				System.out.println("empno : " + empno);
//				System.out.println("ename : " + ename2);
//				System.out.println("hiredate : " + hiredate);
//				System.out.println("---------------------------");

				// map에 담기
//				Map map = new HashMap();
//				map.put("empno", empno);
//				map.put("ename", ename2);
//				map.put("hiredate", hiredate);
				// list에 map을 담기
//				list.add(map);

				EmpDTO dto = new EmpDTO();
				dto.setEmpno(empno);
				dto.setEname(ename2);
				dto.setHiredate(hiredate);

				// list에 dto를 담기
				list.add(dto);

			}
			rs.close();
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// DB접속 메소드로 만들기
	private Connection getConn() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "Scott4_5";
		String password = "tiger";

		Connection con = null;
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");

			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// update
	public int updateEmp2(EmpDTO empDTO) {
		int result = -1;

		// DB 접속
		Connection con = getConn();
		// SQL 준비 및 실행
		String sql = "";
		sql += " UPDATE emp2";
		sql += " SET ename = ?";
		sql += " WHERE empno = ?";

		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empDTO.getEname());
			ps.setInt(2, empDTO.getEmpno());

			result = ps.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// 결과 활용
		return result;
	}
	// insert
	// delete

}
