package popup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/popuptest")
public class PopupTestServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String chk = request.getParameter("chk");
		System.out.println(chk);
		if(chk != null) {
			Cookie c = new Cookie("showPopup", "true");
			c.setMaxAge(10);
			response.addCookie(c);			
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");
		
		boolean showPopup = true;
		Cookie[] cs = request.getCookies();
		if(cs != null) {
			for(int i=0; i<cs.length; i++) {
				Cookie c = cs[i];
				String cName = c.getName();
				if("showPopup".equals(cName)) {
					showPopup = false;
				}
			}
		}
		
		System.out.println("showPopup : " + showPopup);
		
		if(showPopup) {
			System.out.println("팝업보임");
			response.getWriter().println("팝업보임");
		} else {
			System.out.println("팝업안보임");
			response.getWriter().println("팝업안보임");
		}
		
	}
	

}
