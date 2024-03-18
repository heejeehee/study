package example01.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empdetail")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/empdetail doGet 실행");
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		
		EmpDAO empDAO = new EmpDAO();
		List list = empDAO.listEmpDetail(request,response);
		System.out.println(list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("empTableDetail.jsp").forward(request, response);
	}
	
}


