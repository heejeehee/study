package sec01.ex01.sendRedirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first/test")
public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/first doGet");
		response.getWriter().write("/first doGet");
		
//		response.sendRedirect("second");
//		response.sendRedirect("/second");
//		response.sendRedirect("/proj8_forward/second");
		
//		System.out.println(request.getContextPath());	// /proj8_forward
		response.sendRedirect(request.getContextPath() + "/second");
//		response.sendRedirect("http://www.naver.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/first doPost");
		response.getWriter().write("/first doPost");
		
		response.sendRedirect(request.getContextPath() + "/second");
	}

}
