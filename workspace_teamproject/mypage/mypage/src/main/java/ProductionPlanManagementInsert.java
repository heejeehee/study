
import java.io.IOException;
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

import mypage.ProductPlanManagementDTO;

@WebServlet("/ppmi")
public class ProductionPlanManagementInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		insertItem(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		insertItem(request, response);
	}

	protected void insertItem(HttpServletRequest request, HttpServletResponse response) {
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

			// 데이터 변수 지정
			String itemCode = request.getParameter("itemCodeAdd");
			String itemName = request.getParameter("itemNameAdd");

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

////////////////////////////////////////////////////////////////////////////////			

			// SQL 작성
			query = "";
			query += " INSERT INTO employee_temp (ecode, ename)";
			query += " VALUES (104, '맹구')";
			System.out.println("employee_temp insert문 작성 성공");

			// SQL 실행 준비
			ps = con.prepareStatement(query);
			System.out.println("sql 실행 준비");

			// SQL 실행
			ps.executeUpdate();
			ps.close();

////////////////////////////////////////////////////////////////////////////////			

			// 데이터 변수 지정
			String outgoing = request.getParameter("outgoingAdd");
			String startdate = request.getParameter("startdateAdd");
			String enddate = request.getParameter("enddateAdd");
			String quantity = request.getParameter("quantityAdd");

			// 변수 값 변환
			int outgoingint = Integer.parseInt(outgoing);
			Date sqlstartdate = Date.valueOf(startdate);
			Date sqlenddate = Date.valueOf(enddate);
			int quantityint = Integer.parseInt(quantity);

			// SQL 작성
			query = "";
			query += " INSERT INTO outgoing_directions_temp (outgoing_code, item_code, employee_key, creation_date, delivery_date, quantity)";
			query += " VALUES (?, ?, 104, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), ?)";
			System.out.println("outgoing_temp insert문 작성 성공");

			// SQL 실행 준비
			ps = con.prepareStatement(query);
			System.out.println("sql 실행 준비");

			// 데이터 가져오기
			System.out.println("데이터 가져오는 중...");

			ps.setInt(1, outgoingint);
			ps.setString(2, itemCode);
			ps.setDate(3, sqlstartdate);
			ps.setDate(4, sqlenddate);
			ps.setInt(5, quantityint);
			
			System.out.println("가져오기 완료!");
			
			// SQL 실행
			ps.executeUpdate();
			ps.close();

////////////////////////////////////////////////////////////////////////////////

			// 데이터 변수 지정
			String remainAmount = request.getParameter("remainAmountAdd");

			// 변수 값 변환
			int remainAmountint = Integer.parseInt(remainAmount);

			// SQL 작성
			query = " INSERT INTO production_plan_temp (";
			query += " production_plan_code,";
			query += " outgoing_code,";
			query += " expected_production_amount,";
			query += " expected_remain_amount,";
			query += " expected_start_date,";
			query += " expected_end_date";
			query += ")";
			query += " VALUES (";
			query += " 'PP004',";
			query += " ?,";
			query += " ?,";
			query += " ?,";
			query += " TO_DATE(?, 'YYYY-MM-DD'),";
			query += " TO_DATE(?, 'YYYY-MM-DD')";
			query += ")";
			System.out.println("production_plan_temp insert문 작성 성공");

			// SQL 실행 준비
			ps = con.prepareStatement(query);
			System.out.println("sql 실행 준비");

			// 데이터 가져오기
			System.out.println("데이터 가져오는 중...");

			ps.setInt(1, outgoingint);
			ps.setInt(2, quantityint);
			ps.setInt(3, remainAmountint);
			ps.setDate(4, sqlstartdate);
			ps.setDate(5, sqlenddate);

			// SQL 실행
			ps.executeUpdate();
			ps.close();
	
			// 접속종료
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
