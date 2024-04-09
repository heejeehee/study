package sec06.ex01.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginChk")
public class LoginCheckServlet extends HttpServlet {
	
	String id = "admin";
	String pw = "1234";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String user_id = request.getParameter("id");
		String user_pw = request.getParameter("pw");
		if("admin".equals(user_id) && "1234".equals(user_pw)) {
			HttpSession sc = request.getSession();
			sc.setAttribute("mysc", user_id);
			System.out.println(sc.getAttribute("mysc"));
			
			response.sendRedirect("main");
			
		} else {
			response.sendRedirect("login.html");
		}
	}

}
