package sec01.ex01.jdbc.one;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/one")
public class OneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/one 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		long begin = System.currentTimeMillis();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
        String user = "scott4_5";
        String password = "tiger";
        
        try {
        	// Class.forName() : String 변수로 class를 생성
        	// 드라이버 : 서로 다른 것들(java, oracle)이 소통할 수 있게 해주는 것
        	
        	// 오라클 드라이버 로딩
			Class.forName(driver);		// OracleDriver drive = new OracleDriver(); 와 같음
			
			// DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			
			// SQL 준비
			String query = "select * from emp2";
			PreparedStatement ps = con.prepareStatement(query);
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			// 조회된 결과 전체(테이블의 모든 줄)를 갖고 있음 (2차원 배열의 느낌)
			
			// 결과 활용
			// rs.next() : 다음 줄의 정보를 가져옴 (1차원 배열의 느낌)
//			for(;rs.next();) {} 가운데 영역이 false까지 계속됨
			while(rs.next()) {
				// 해당 줄의 EMPNO
				int empno = rs.getInt("empno");
				System.out.println("empno : " + empno);
				response.getWriter().print("empno : " + empno + "<br>");
				
				String ename = rs.getString("ename");
				System.out.println("ename : " + ename);
				response.getWriter().print("ename : " + ename + "<br>");
			}
			rs.close();
			ps.close();
			con.close();
			
			long end = System.currentTimeMillis();
			
			System.out.println(end-begin);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
