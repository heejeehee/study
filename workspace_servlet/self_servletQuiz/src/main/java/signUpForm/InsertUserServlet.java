package signUpForm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertUser")
public class InsertUserServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userNickname = request.getParameter("userNickname");
		
		UserDAO userDAO = new UserDAO();
		int result = userDAO.insertUser(userId, userPw, userNickname);
		
		System.out.println("result : " + result);
		
/*		if(result == 1) {
			response.getWriter().println("<script>alert('회원가입 완료. 로그인 페이지로 이동합니다.'); window.location.href='loginPage.jsp';</script>");
		}
*/
		if(result == 1) {
	        // 회원가입 성공 시에는 특정 서블릿으로 전달
	        request.getRequestDispatcher("/successPage").forward(request, response);
	    }
		
	}

}
