package example01.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpInsertServlet
 */
@WebServlet("/empinsert")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/empinsert doGet 실행");
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		EmpDAO empDAO = new EmpDAO();
		empDAO.addEmp(request,response);
		request.getRequestDispatcher("emps").forward(request, response);
	}

}
