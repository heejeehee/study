package pagePath;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/successPage")
public class SuccessPageServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		
	    response.getWriter().println("<script>alert('회원가입이 완료되었습니다. 로그인 페이지로 이동합니다.'); window.location.href='loginPage.jsp';</script>");
	}

}
