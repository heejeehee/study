package example01.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Data Access Object
public class EmpDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
	private String user = "scott4_5";
	private String password = "tiger";

	private Connection conn; // 1. 필드에 따로 빼는 방식

	private void connDB() {
		// this.conn = null; // 2번 방식
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return conn // 2. return 값으로 돌려주는 방식
	}

	public List listEmp() {
		connDB(); // 1번 방식 (반드시 호출해 주어야 함)
		// Connection conn = connDB(); // 2번 방식

		PreparedStatement ps = null;
		ResultSet rs = null;

		List list = new ArrayList();

		try {
			String query = "select empno, ename from emp2";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");

				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);

				list.add(empDTO);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (this.conn != null) {
				try {
					this.conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return list;

	}

	public List listEmpDetail(HttpServletRequest request, HttpServletResponse response) {
		connDB(); // 1번 방식 (반드시 호출해 주어야 함)
		// Connection conn = connDB(); // 2번 방식

		PreparedStatement ps = null;
		ResultSet rs = null;

		List list = new ArrayList();

		try {
			String query = "select * from emp2 where empno=?";
			ps = conn.prepareStatement(query);
			String empno = request.getParameter("empno");
			System.out.println(empno);
			ps.setString(1, empno);
			rs = ps.executeQuery();
			while (rs.next()) {

				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt("empno"));
				empDTO.setEname(rs.getString("ename"));
				empDTO.setJob(rs.getString("job"));
				empDTO.setMgr(rs.getInt("mgr"));
				empDTO.setHiredate(rs.getDate("hiredate"));
				empDTO.setSal(rs.getInt("sal"));
				empDTO.setComm(rs.getInt("comm"));
				empDTO.setDeptno(rs.getInt("deptno"));

				list.add(empDTO);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (this.conn != null) {
				try {
					this.conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return list;

	}

	public void addEmp(HttpServletRequest request, HttpServletResponse response) {
		connDB(); // 1번 방식 (반드시 호출해 주어야 함)

		// 데이터 변수 지정
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = Integer.parseInt(request.getParameter("mgr"));
		Date hiredate = Date.valueOf(request.getParameter("hiredate")); // 문자열을 날짜로 변환
		int sal = Integer.parseInt(request.getParameter("sal"));
		int comm = Integer.parseInt(request.getParameter("comm"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));

		// SQL 작성
		String query = " INSERT INTO emp2 (empno, ename, job, mgr, hiredate, sal, comm, deptno)"
					 + " VALUES (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";
		System.out.println("production_plan_temp insert문 작성 성공");

		// SQL 실행 준비
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			System.out.println("sql 실행 준비");
			
			// 데이터 가져오기
			
			ps.setInt(1, empno); // empno
			ps.setString(2, ename); // ename
			ps.setString(3, job); // job
			ps.setInt(4, mgr); // mgr
			ps.setDate(5, hiredate); // hiredate 
			ps.setDouble(6, sal); // sal
			ps.setInt(7, comm); // comm
			ps.setInt(8, deptno); // deptno
			
			// SQL 실행
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
