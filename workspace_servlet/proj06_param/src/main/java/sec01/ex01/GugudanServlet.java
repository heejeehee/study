package sec01.ex01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugu")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dan = request.getParameter("dan");
		int intdan = Integer.parseInt(dan);

		ArrayList danArr = new ArrayList();
		for (int i = 1; i <= 9; i++) {
			if (intdan == i) {
				for (int j = 1; j <= 9; j++) {
					System.out.println(i + "x" + j + "=" + (i * j));
					danArr.add(i + "x" + j + "=" + (i * j));
				}
			} else {
				System.out.print("");
			}
		}

		// 응답 데이터 설정 (response object 이용) (이게 xhr.responseText 가 됨.)
		response.setContentType("text/html; charset=UTF-8");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < danArr.size(); i++) {
		  sb.append(danArr.get(i) + "\n" +"<br>");
		}
		String outputString = sb.toString();
		response.getWriter().write(outputString);
	}

}
