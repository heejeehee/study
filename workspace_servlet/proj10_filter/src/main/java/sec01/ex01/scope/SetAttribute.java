package sec01.ex01.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetAttribute extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		ctx.setAttribute("context", "context에 바인딩");
		session.setAttribute("session", "session에 바인딩");
		request.setAttribute("request", "request에 바인딩");
		
		System.out.println("바인딩 완료.");
		
	}

}
