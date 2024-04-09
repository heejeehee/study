package example01.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emps")
public class EmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/emp doGet 실행");
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		
		EmpDAO empDAO = new EmpDAO();
		List list = empDAO.listEmp();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("empTable.jsp").forward(request, response);
	}

}
