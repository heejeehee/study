package signUpForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	// DB연결
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
	// 닉네임 체크
	public List nicknameChk() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List list = new ArrayList();

		try {
			conn = connDB();

			String sql = "";
			sql += " select user_name";
			sql += " from user_info";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // SQL 실행

			while (rs.next()) {
				String nickname = rs.getString("user_name");

				System.out.println("------------------------");

				System.out.println("nickname : \t" + nickname);

				System.out.println("------------------------");

				UserDTO userDTO = new UserDTO();
				userDTO.setUserName(nickname);

				list.add(userDTO.userName);
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
		System.out.println("list : " + list);
		return list;

	}
	// id 체크
	public List idChk() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List list = new ArrayList();

		try {
			conn = connDB();

			String sql = "";
			sql += " select user_id";
			sql += " from user_info";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); // SQL 실행

			while (rs.next()) {
				String userId = rs.getString("user_id");

				System.out.println("------------------------");

				System.out.println("userId : \t" + userId);

				System.out.println("------------------------");

				UserDTO userDTO = new UserDTO();
				userDTO.setUserId(userId);

				list.add(userDTO.userId);
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
		System.out.println("list : " + list);
		return list;

	}
	
	// 회원가입 등록
	public int insertUser(String userId, String userPw, String nickname) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = -1;
		
		try {
			conn = connDB();
			
			String sql = "";
			sql += " insert into user_info";
			sql += " (user_seq, user_id, user_pw, user_name)";
			sql += " values";
			sql += " (user_seq.nextval, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userPw);
			ps.setString(3, nickname);
			
			int rowAffected = ps.executeUpdate();
			if(rowAffected > 0) {
				System.out.println("insert sql : " + sql);
				System.out.println("insert clear");
				result = 1;
			} else {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		return result;
	}
	
}