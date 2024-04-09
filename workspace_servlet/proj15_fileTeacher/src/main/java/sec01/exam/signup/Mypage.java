package sec01.exam.signup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Mypage
 */
@WebServlet("/mypage")
public class Mypage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		
		Connection con = null;
		PreparedStatement ps = null;
		SignupDTO dto = new SignupDTO();
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			con = dataFactory.getConnection();

			// SQL 준비
			String query = " select * from signup ";
			query += " where id = ? ";

			ps = con.prepareStatement(query);
			ps.setString(1, id);

			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String db_id = rs.getString("id");
				String db_pw = rs.getString("pw");
				String db_filename = rs.getString("filename");
				
				dto.setId(db_id);
				dto.setPw(db_pw);
				dto.setFilename(db_filename);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		// jsp로 가기
		request.setAttribute("signupDTO", dto);
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
		
	}

}
