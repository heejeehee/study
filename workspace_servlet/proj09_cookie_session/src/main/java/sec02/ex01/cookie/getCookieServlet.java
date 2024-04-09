package sec02.ex01.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class getCookieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		Cookie[] cs = request.getCookies();
		if(cs != null) {
			for(int i=0; i<cs.length; i++) {
				Cookie c = cs[i];
				
				String name = c.getName();
				if("key".equals(name)) {
					response.getWriter().println(name + "으로 저장된 쿠키의 값은 " + c.getValue());
				}
			}			
		} else {
			response.getWriter().println("쿠키가 없습니다.");
		}
		if(cs != null) {
			for(int i=0; i<cs.length; i++) {
				Cookie c = cs[i];
				
				String name = c.getName();
				if("key2".equals(name)) {
					response.getWriter().println("key2 로 저장된 쿠키의 값은 " + c.getValue());
				}
			}			
		} else {
			response.getWriter().println("쿠키가 없습니다.");
		}
		
	}

}
