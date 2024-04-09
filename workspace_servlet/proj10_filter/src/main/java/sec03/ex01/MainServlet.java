package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String login = (String)request.getSession().getAttribute("login");
		// 대문자 Boolean 타입
		// 만약 login 세션의 value값을 true 로 한 경우
		// 일반 boolean 타입은 null 을 허용하지 않기 때문에 주소창에 그냥 들어오면 실행자체가 안됨.
		// 대문자 Boolean은 null을 허용.
		
//		if(login == null || "".equals(login)) {
//			response.sendRedirect("login.html");
//		} 
//		else {
			out.println("<h1>비밀공간</h1>");		
			out.println("<h1>환영합니다"+login+"님</h1>");		
//		}
		
		
	}
	
}
