package sec06.ex01.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession sc = request.getSession();
		
		if(sc.getAttribute("mysc") == null) {
			response.sendRedirect("login.html");
		} else {
			System.out.println(sc.getAttribute("mysc"));
			sc.setMaxInactiveInterval(10);
			System.out.println(sc.getMaxInactiveInterval());
			// 페이지를 이동시키는 개념.
//			response.getWriter().println("<script>");
//			response.getWriter().println("alert('환영합니다"+sc.getAttribute("mysc")+"님.')");
//			response.getWriter().println("location.href = 'main.html'");
//			response.getWriter().println("</script>");
			request.getRequestDispatcher("/main.html").forward(request, response);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		doGet(request, response);
	}

}
