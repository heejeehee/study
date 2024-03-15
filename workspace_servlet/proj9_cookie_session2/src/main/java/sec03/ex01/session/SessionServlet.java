package sec03.ex01.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// false 일 경우에 기존 세션이 없으면 null을
		HttpSession sess1 = request.getSession(false);
		// 기존 세션이 없으면 새로 만들어서 return
		HttpSession sess2 = request.getSession();
		
//		System.out.println("sess1 : " + sess1);
//		System.out.println("sess2 : " + sess2);
		System.out.println("sess2.isNew() : " + sess2.isNew()); // 새로운 새션이면 true, 아니면 false
//		System.out.println("sess2.getId() : " + sess2.getId());
//		System.out.println("sess2.getMaxInactiveInterval() : " + sess2.getMaxInactiveInterval());
//		System.out.println("sess2.getLastAccessedTime() : " + sess2.getLastAccessedTime());
		
		// 시계를 따로 관리하는 아이디어
//		sess2.setAttribute("마지막 유효 시간", "오후 12시 29분 14초");
		
		////////////////////////////////////////////////////////////////
		
		String old_id = (String)sess2.getAttribute("id");
		System.out.println("old_id : " + old_id);
		
		String id = "abcd";
		sess2.setAttribute("id", id);
		
		String url = response.encodeUrl("sess");
		System.out.println("url = " + url);
		response.getWriter().println("<a href='"+ url +"'>session으로 이동</a>");
		
	}

}
