package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		
		System.out.println(userId);
		System.out.println(userPw);
		System.out.println(gender);
		System.out.println(hobbys.length);
		for(int i=0; i<hobbys.length; i++) {
			System.out.println(hobbys[i]);
		}
		
		for(String hobby : hobbys) {
			System.out.println(hobby);
		}
		
		response.getWriter().println("{\"k\" : \"v\"}");
	}

}
