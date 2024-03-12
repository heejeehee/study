package example01.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empupdate")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/empupdate doGet 실행");
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		EmpDAO empDAO = new EmpDAO();
		empDAO.updateEmp(request,response);
		request.getRequestDispatcher("emps").forward(request, response);
	}

}
