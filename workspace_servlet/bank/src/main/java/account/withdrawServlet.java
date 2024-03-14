package account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/withdraw")
public class withdrawServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int myAccount = Integer.parseInt(request.getParameter("myAccount"));
		int withdraw = Integer.parseInt(request.getParameter("withdraw"));
		
		response.getWriter().write(myAccount - withdraw);
		
	}

}
