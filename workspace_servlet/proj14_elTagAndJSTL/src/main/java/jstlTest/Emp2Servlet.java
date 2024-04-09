package jstlTest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emp2")
public class Emp2Servlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Emp2DAO dao = new Emp2DAO();
		List list = dao.selectEmp();
		
		System.out.println("list.toString() : " + list.toString());
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jstlTest/emp2Info.jsp").forward(request, response);
				
	}

}
