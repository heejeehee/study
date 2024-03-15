package sec02.ex01.cookie;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		Cookie[] cookies = request.getCookies();
		System.out.println(cookies);
		
//		if(cookies != null) {
//			for(int i=0; i<cookies.length; i++) {
//				Cookie c = cookies[i];
//				
//				System.out.println("쿠키 이름 : " + c.getName());
//				System.out.println("쿠키 값 : " + c.getValue());
//				
//				String name = c.getName();
//				if("key".equals(name)) {
//					response.getWriter().println("<h1>"+name+"으로 저장된 쿠키의 값 : "+c.getValue()+"</h1>");
//				}
//				if("key2".equals(name)) {
//					String han = URLDecoder.decode(c.getValue());
//					System.out.println("디코딩된 han:"+han);
//					response.getWriter().println("<h1>"+name+"으로 저장된 쿠키의 값 : "+c.getValue()+"</h1>");
//				}
//			}
//		}else {
//			response.getWriter().println("<h1>쿠키 없으니깐 썩 꺼져~</h1>");
//		}
		
		
		int a = -1;	// true false 사용하기도 가능.
		if(cookies != null) {
			
			for(int i=0; i<cookies.length; i++) {
				Cookie c = cookies[i];
				
					// "key" 이름을 가진 쿠키가 있는지 없었는지 출력	
					if("key".equals(c.getName())) {
						System.out.println("쿠키 이름 : " + c.getName() + "가 존재합니다.");
					}
					// 쿠키중에
					// 이름이 "key2"인게 있었으면
					if("key2".equals(c.getName())) {
						System.out.println("쿠키 이름 : " + c.getName() + "발견!!");
						a = 1;
					}
			}
			
		}
		if(a == 1) {
			// 안보여주고
			response.getWriter().println("안보여줄거지롱");
		} else {				
			// 없었으면 보여주고
			response.getWriter().println("<div style='border: 1px solid red'>팝업표시</div>");
		}
		
	}

}
