package insertUser.duplicateChk;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import insertUser.UserDAO;

@WebServlet("/idChk")
public class IdCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");

		UserDAO userDao = new UserDAO();
		int result = userDao.chkIdDuplicate(userId);

		// 응답 데이터 설정 (response object 이용) (이게 xhr.responseText 가 됨.)
		response.setContentType("text/html; charset=UTF-8");
		StringBuilder sb = new StringBuilder();
		sb.append(result);
		String outputString = sb.toString();
		response.getWriter().write(outputString);

	}

}
