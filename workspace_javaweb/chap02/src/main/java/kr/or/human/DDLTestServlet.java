package kr.or.human;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/init")
public class DDLTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controller(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controller(request, response);
	}

	protected void controller(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 들어오는 한글 깨짐 방지
			request.setCharacterEncoding("utf-8");
			// 내보내는 한글 깨짐 방지
			response.setContentType("text/html; charset=utf-8;");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "Scott4_5";
		String password = "tiger";
		
		try {

			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");
			String name = request.getParameter("name");

			String query = "";
			query += " create table emp2";
			query += " as select * from emp";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			// select 할때는 executeQuery();
			// 그 외는 executeUpdate();
			int result = ps.executeUpdate();
			
			System.out.println("create table result" + result);
			// create table result14(영향받은 줄 수)
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
