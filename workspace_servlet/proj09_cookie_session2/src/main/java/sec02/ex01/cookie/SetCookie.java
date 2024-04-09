package sec02.ex01.cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		Cookie c = new Cookie("key","value");
		c.setMaxAge(-1);
		/** 
		 setMaxAge()
		 단위는 초단위, 24*60*60 은 하루
		 설정하지 않거나 음수값을 넣으면 세션쿠키 즉, 브라우저 메모리에만 저장된다. 
		 브라우저의 모든 탭을 끄면 사라진다. 
		*/
		response.addCookie(c);
		
		String han = "한글";
		han = URLEncoder.encode(han,"utf-8");
		System.out.println("인코딩된 han : "+han);
		
		Cookie c1 = new Cookie("key2",han);
		c1.setMaxAge(10); //단위는 초단위 ex) 24*60*60 은 하루
		response.addCookie(c1);

		System.out.println("쿠키 세팅완료");
		
	
	}


}
