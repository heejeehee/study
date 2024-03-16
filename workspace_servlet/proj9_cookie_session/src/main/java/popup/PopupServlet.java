package popup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pop")
public class PopupServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String popup_1Chkbox = request.getParameter("popup_1Chkbox");
		
		if(popup_1Chkbox != null || "".equals(popup_1Chkbox)) {
			response.sendRedirect("mainPage.jsp");
		} else {
			Cookie c = new Cookie("key","value");
			c.setMaxAge(10);
			response.addCookie(c);
		}
		
		Cookie[] cs = request.getCookies();
		if(cs != null) {
			for(int i=0; i<cs.length; i++) {
				Cookie c = cs[i];
				String name = c.getName();
				
				if("key".equals(name)) {
					response.getWriter().println("<script>");
					response.getWriter().println("document.querySelector('.popup_1').style.cssText='display: none;'");
					response.getWriter().println("window.location.href='mainPage.jsp'");					
					response.getWriter().println("</script>");
				}
			}			
		} else {
			response.getWriter().println("<script>");
			response.getWriter().println("window.location.href='mainPage.jsp'");					
			response.getWriter().println("</script>");
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
