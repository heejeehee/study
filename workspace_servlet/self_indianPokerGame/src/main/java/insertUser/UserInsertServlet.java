package insertUser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertuser")
public class UserInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		
		String userId = request.getParameter("userId");
		int userPw = Integer.parseInt(request.getParameter("userPw"));
		String userName = request.getParameter("userName");

		UserDAO userDao = new UserDAO();
		int result = userDao.insertUser(userId, userPw, userName);
		
		if (result == 1) {
		    PrintWriter pw = response.getWriter();
		    pw.println("<script>");
		    pw.println("alert('회원가입 성공.\n로그인 창으로 이동합니다.');");
		    pw.println("window.location.href = 'login.jsp';");
		    pw.println("</script>");
		} else {
			PrintWriter pw = response.getWriter();
		    pw.println("<script>");
		    pw.println("alert('회원가입 실패.\n다시 시도해 주세요.');");
		    pw.println("</script>");
		}
	}

}
