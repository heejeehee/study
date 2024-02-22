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

@WebServlet("/jdbc")
public class JdbcServlet extends HttpServlet {
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
		String user = "Scott4_0";
		String password = "tiger";
		
		try {
			////////////////////////////////////////////////////////////////////
			// driver 로딩
			// Class.forName() : String 변수로 Class 생성
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			
			// DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");
			////////////////////////////////////////////////////////////////////
//			String name = "SCOTT";
//			String name = "S";
//			String name = "s";
			String name = request.getParameter("name");
			// SQL 작성
			String query = "";
			query += " select";
			query += " *";
			query += " from";
			query += " emp";
//			query += " where ename = 'SCOTT'";
//			query += " where ename = ?";
//			query += " where ename like '%?%'";
//			query += " where ename like '%' || ? || '%'";
			
			query += " where lower(ename) like '%' || lower(?) || '%'";
			
			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			
			// SQL 실행, ResultSet으로 결과 확보
			ResultSet rs = ps.executeQuery();
			// select : executeQuery()
			// return : result
			// 그 외 : executeUpdate()
			// return : int(몇개의 row가 영향을 받았는지 나옴)
			
			// DB값 활용하기
			// ResultSet rs 에는 모든 줄이 담겨 있음
			// next() 실행 후의 ResultSet rs 에는 다음 줄이 담김
//			if( rs.next() /* 다음 줄이 있으면 */) {
			while( rs.next() /* 다음 줄이 없을때 까지 */) {
				// getxxx, 전달인자로 컬럼명, 대소문자 구분 없음
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");
				// import된 class 명이 같기 때문에 
				// 날짜 사용하고 싶으면
				// java.util.Date 이 형태로 써 주어야 한다
				
				System.out.println("empno : " + empno);
				System.out.println("ename : " + ename);
				System.out.println("hiredate : " + hiredate);
				System.out.println("---------------------------");
				
				PrintWriter out = response.getWriter();
				out.println("<div>empno : " + empno + "</div>");
				out.println("<div>ename : " + ename + "</div>");
				out.println("<div>hiredate : " + hiredate + "</div>");
				out.println("<hr>");
			}
			
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
