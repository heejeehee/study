
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ppmd")
public class ProductionPlanManagementDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		deleter(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		deleter(request, response);
	}

	protected void deleter(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8;");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "alphaknow";
		String password = "qwer1234";

		try {
			// driver 로딩
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");

			// DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");

			// delete 할 컬럼 변수
			String del = request.getParameter(password)
			
			// SQL 작성
			String query = "";
			query += " INSERT INTO item_registration_temp (item_code, item_name)";
			query += " VALUES (?, ?)";
			System.out.println("item_registration_temp insert문 작성 성공");

			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("sql 실행 준비");

			// 데이터 가져오기
			System.out.println("데이터 가져오는 중...");

			ps.setString(1, itemCode);
			ps.setString(2, itemName);

			// SQL 실행
			ps.executeUpdate();

			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			request.getRequestDispatcher("/ppms").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
