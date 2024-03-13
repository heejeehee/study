package insertUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	public void insertUser(HttpServletRequest request, HttpServletResponse response) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = connDB();

			String userId = request.getParameter("userId");
			int userPw = Integer.parseInt(request.getParameter("userPw"));
			String userName = request.getParameter("userName");

			String sql = " INSERT INTO user_info (user_seq, user_id, user_pw, user_name)"
					   + " VALUES (user_seq.NEXTVAL, ?, ?, ?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, userPw);
			ps.setString(3, userName);

			ps.executeUpdate();

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

	}

}
