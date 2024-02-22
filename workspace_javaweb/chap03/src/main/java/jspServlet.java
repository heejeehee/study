

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp")
public class jspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
//		response.sendRedirect("param.jsp?id=" + id);
		
//		request.getRequestDispatcher("param.jsp?id=" + id).forward(request, response);
		// 어짜피 request를 전달하고 jsp는 거기서 id값을 꺼낼 수 있다.
//		request.getRequestDispatcher("param.jsp").forward(request, response);
		
		request.setAttribute("id2", id);
		List<String> list = new ArrayList<String>();
		list.add("최");
		list.add("민");
		list.add("수");
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("param.jsp").forward(request, response);
	}

}
