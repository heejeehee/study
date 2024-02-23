

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// 세션은 서버에 
// 쿠키는 클라이언트에 저장됨
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	/*
	#application
	 
	같은 tomcat에 사용 가능
	#session
	 
	같은 브라우저에서는 계속 사용 가능
	#request
	 
	요청때 생겨서 응답때 사라짐
	#page
	 
	딱 그 jsp 안에서만 사용 가능
	*/
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새로운 세션이면 세션을 생성해서 돌려줌
		HttpSession session = request.getSession();
		if(session.isNew()) {
			System.out.println("신규 사용자");
			System.out.println("처음 보는 브라우저");
		} else {
			System.out.println("아까 왔던 브라우저");
		}
		System.out.println(session.getId());
		
		// false를 준 상황 가정
		// 새로운 세션이면 null
//		HttpSession session = request.getSession(false);
		
		// 로그인에 써먹기 좋은 기법
		String id = request.getParameter("id");
//		if(id.equals("admin")) {
		if("admin".equals(id)) {
			session.setAttribute("isLogon", true);
		}
		
	}

}
