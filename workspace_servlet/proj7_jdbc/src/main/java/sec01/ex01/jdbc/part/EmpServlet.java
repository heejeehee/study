package sec01.ex01.jdbc.part;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emp")
public class EmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/emp doGet 실행");
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		
		EmpDAO empDAO = new EmpDAO();
		List list = empDAO.listEmp();
		
		System.out.println("총 개수 : " + list.size());
		
		response.getWriter().println("<table border='1'>");
		response.getWriter().println("<tr>");
		response.getWriter().println("<th>empno</th><th>ename</th><th>sal</th>");
		response.getWriter().println("</tr>");
		for(int i=0; i<list.size(); i++) {
			EmpDTO empDTO = (EmpDTO) list.get(i);
			int empno = empDTO.getEmpno();
			String ename = empDTO.getEname();
			int sal = empDTO.getSal();
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+ empno +"</td><td>"+ ename +"</td><td>"+ sal +"</td>");
			response.getWriter().println("</tr>");
		}
		response.getWriter().println("</table>");
	}

}
