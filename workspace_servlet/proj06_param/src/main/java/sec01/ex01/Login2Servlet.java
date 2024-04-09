package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class Login2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		if(id == null || "".equals(id.trim())) {
			response.getWriter().write("아이디는 필수로 입력해야 합니다.");
			return;
		}
		
		
		
		System.out.println("id : " + id + "pw : " + pw);
		
		String myId = "당신의 아이디는 " + id + "입니다.";
		String myPw = "당신의 비밀번호는 " + pw + "입니다.";
		
		response.getWriter().println(myId + "<br>");
		response.getWriter().println(myPw);
	}

}
