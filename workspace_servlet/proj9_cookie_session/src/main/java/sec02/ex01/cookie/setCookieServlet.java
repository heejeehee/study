package sec02.ex01.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class setCookieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		Cookie c = new Cookie("key", "value");
//		c.setMaxAge(-1); 초단위, -1은 브라우저를 끄면 사라지는 시간 
		c.setMaxAge(10);
		response.addCookie(c);
		
		Cookie c2 = new Cookie("key2", "한글쿠키");
		c2.setMaxAge(10);
		response.addCookie(c2);
		
		System.out.println("쿠키 추가 완료");
		
	}

}
