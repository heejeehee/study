package sec03.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		
		String user_name = request.getParameter("user_name");
		String user_pass = request.getParameter("user_pass");
		
		System.out.println("user_name : " + user_name);
		System.out.println("user_pass : " + user_pass);
		
		response.getWriter().println("이름 : " + user_name);
		response.getWriter().println("<br>비번 : " + user_pass);
		
		if("admin".equals(user_name) 
		&& "1234".equals(user_pass)) {
			request.getSession().setAttribute("login", user_name);
			response.sendRedirect("main");
		} else {
			response.sendRedirect("login.html");
		}
	}

}
