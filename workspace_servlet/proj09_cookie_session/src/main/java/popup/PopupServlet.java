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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doget");
		response.setContentType("text/html; charset=utf-8");

		boolean showPopup = false;
		Cookie[] cs = request.getCookies();
		if (cs != null) {
			for (int i = 0; i < cs.length; i++) {
				Cookie c = cs[i];
				String cName = c.getName();
				if ("key".equals(cName)) {
					showPopup = true;
				} 
			}
		}
		
		if(!showPopup) {
			response.getWriter().println("<form method='post' action='pop'>");
			response.getWriter().println("<h1>메인페이지</h1>");
			response.getWriter().println("<hr>");
			response.getWriter().println("<div style='border: 1px solid red'>팝업입니다.<br><input type='checkbox' name='chk' value='1'>10초간 그만보기</div>");
			response.getWriter().println("<input type='submit' value='팝업닫기'>");
			response.getWriter().println("</form>");
		} else {
			response.getWriter().println("<form method='post' action='pop'>");
			response.getWriter().println("<h1>메인페이지</h1>");
			response.getWriter().println("<hr>");
			response.getWriter().println("</form>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost");
		String chk = request.getParameter("chk");
		if (chk != null) {
			setCookie(request, response);
		}
	}

	public void setCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie c = new Cookie("key", "value");
		c.setMaxAge(10);
		response.addCookie(c);
	}

}
