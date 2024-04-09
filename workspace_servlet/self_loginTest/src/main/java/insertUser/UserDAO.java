package insertUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
	private String user = "scott4_5";
	private String password = "tiger";

	private Connection connDB() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 회원가입
	public int insertUser(String userId, int userPw, String userName) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int result = -1;	// 데이터베이스 접근 오류

		try {

			conn = connDB();
			
			String sql = " INSERT INTO user_info (user_seq, user_id, user_pw, user_name, user_level)"
					   + " VALUES (user_seq.NEXTVAL, ?, ?, ?, 'user')";

			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, userPw);
			ps.setString(3, userName);

			int rowsAffected = ps.executeUpdate();	// 삽입된 값의 수
            if (rowsAffected > 0) {
                result = 1; // 성공적으로 삽입됨을 나타내는 값
            } else {
                result = 0; // 삽입된 행이 없음을 나타내는 값
            }

		} catch (SQLException e) {
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
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}
	
	public int chkIdDuplicate(String userId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = -1;	// 데이터베이스 접근 오류
		
		try {

			conn = connDB();
			
			String sql = " select user_id from user_info"
					   + " where user_id = ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);

			rs = ps.executeQuery();	// SQL 실행
            while(rs.next()) {
            	rs.getString("user_id");
            	result = 1;		// 데이터 읽기 성공
            }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
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
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
