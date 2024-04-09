package sec03.brd08.paging;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/emp")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = request.getParameter("view");
		System.out.println(view);
		
		String StrPageNum = request.getParameter("page");
		System.out.println(StrPageNum);
		
		/*
		 * String StrRows = request.getParameter("rows"); System.out.println(StrRows);
		 */
		
		
		if("all".equals(view)) {
			EmpService empService = new EmpService();
			List<EmpDTO> list = empService.listEmp();
			System.out.println("list.get(0) : " + list.get(0).lv);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/emp.jsp").forward(request, response);		
		}
		
		if("sort".equals(view)) {
			EmpService empService = new EmpService();
			List<EmpDTO> list = empService.listSortEmp();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/emp.jsp").forward(request, response);		
		}
		
		else if(StrPageNum != null) {
			int pageNum = Integer.parseInt(StrPageNum);
			EmpService empService = new EmpService();
			List<EmpDTO> list = empService.pageList(pageNum);
			int rowNum = empService.pageSetting();
			
			request.setAttribute("list", list);
			request.setAttribute("rowNum", rowNum);
			request.getRequestDispatcher("/emp.jsp").forward(request, response);
		}
	}

}
