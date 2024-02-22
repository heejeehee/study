

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

@WebServlet("/jdbc2")
public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controller(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		controller(request, response);
	}
	
	protected void controller(HttpServletRequest request, HttpServletResponse response) {
		// 한글 깨짐 방지 ////////////////////////////////////////////////
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8;");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		///////////////////////////////////////////////////////////////
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "Scott4_5";
		String password = "tiger";
		
		try {
			Class.forName(driver);
			System.out.println("Oracle driver 로딩 성공");
			
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");
			
			String query = "";
			query += "select * from emp";
			query += " where ename=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "SMITH");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");
				
				PrintWriter out = response.getWriter();
				out.println(empno);
				out.println(ename);
				out.println(hiredate);
				out.println("<hr>");
				
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
