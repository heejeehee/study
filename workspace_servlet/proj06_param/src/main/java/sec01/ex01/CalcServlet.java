package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String sel = request.getParameter("sel");

		int cvNum1 = Integer.parseInt(num1);
		int cvNum2 = Integer.parseInt(num2);

		System.out.println(cvNum1 + "," + cvNum2);

		int result=0;
		if ("plus".equals(sel)) {
			result = cvNum1 + cvNum2;
			System.out.println(result);
		} else if ("minus".equals(sel)) {
			result = cvNum1 - cvNum2;
			System.out.println(result);
		}
		// "plusminus".equal(sel) 이렇게 하는게 nullpointexception이 안나옴. false를 돌려줌

		// 계산 결과를 문자열로 변환
		String resultStr = String.valueOf(result);

		// 응답 데이터 설정 (response object 이용) (이게 xhr.responseText 가 됨.)
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(resultStr);

	}

}
