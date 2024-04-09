package jstlTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Emp2DAO {

	private Connection connDB() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/OracleDB");
			conn = dataFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public List selectEmp() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List list = new ArrayList();
		try {
			conn = connDB();

			String query = "select * from emp2";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");

				System.out.println("------------------------");

				System.out.println("ename : \t" + ename);
				System.out.println("empno : \t" + empno);
				System.out.println("sal : \t\t" + sal);

				System.out.println("------------------------");

				Emp2DTO dto = new Emp2DTO();
				dto.setEmpno(empno);
				dto.setEname(ename);
				dto.setSal(sal);

				list.add(dto);

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

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
