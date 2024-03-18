package sec03.ex01.forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SecondServlet2", urlPatterns = { "/second/forward" })
public class SecondServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/second/forward doGet");
		response.getWriter().write("/second/forward doGet");
		
		String id = request.getParameter("id");
		System.out.println("id = " + id);
		
		response.getWriter().write("id = " + id);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/second/forward doPost");
		response.getWriter().write("/second/forward doPost");
	}

}
