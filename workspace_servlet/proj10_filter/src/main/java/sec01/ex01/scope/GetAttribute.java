package sec01.ex01.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetAttribute extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		// 없으면 null
		String strCtx = (String)ctx.getAttribute("context");
		String strSession = (String)session.getAttribute("session");
		String strReq = (String)request.getAttribute("request");
		
		System.out.println("strCtx : " + strCtx);
		System.out.println("strSession : " + strSession);
		System.out.println("strReq : " + strReq);
	}

}
