package sec01.exam.signup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import sec01.ex01.upload.FileUpload2;

@WebServlet("/signup")
public class Signup extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String basePath = "C:\\file_repo";

		FileUpload2 fu = new FileUpload2();
		SignupDTO dto = fu.request2DTO(basePath, request);

		System.out.println(dto);

		Connection con = null;
		PreparedStatement ps = null;
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			con = dataFactory.getConnection();

			// SQL 준비
			String query = " insert into signup";
			query += " values(seq_signup.nextval, ?, ?, ?) ";

			ps = con.prepareStatement(query);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getFilename());

			// SQL 실행 및 결과 확보
			int cntInsert = ps.executeUpdate();
			System.out.println("insert 결과 : " + cntInsert);

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
		
		response.getWriter().println("회원가입 완료");
	}

}
