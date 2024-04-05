package com.spring.ex04.dynamic;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dynamic")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmpDAO empDAO = new EmpDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8");
		
		EmpDTO dto = new EmpDTO();
		String keyword = request.getParameter("keyword");
		System.out.println("keyword : "+ keyword);
		String type = request.getParameter("type");
		System.out.println("type : " + type);
		
		String updown = request.getParameter("updown");
		System.out.println("updown : "+ updown);
		String typeud = request.getParameter("typeud");
		System.out.println("typeud : " + typeud);
		
		String orderColumn = request.getParameter("orderColumn");
		System.out.println("orderColumn : "+ orderColumn);
		String orderType = request.getParameter("orderType");
		System.out.println("orderType : " + orderType);
		
//		if("1".equals(type)) {
//			dto.setEname(keyword);			
//		} else if("2".equals(type)) {
//			try {
//				int sal = Integer.parseInt(keyword);
//				dto.setSal(sal);			
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if("4".equals(type)) {
//			dto.setJob(keyword);			
//		} else if("5".equals(type)) {
//			dto.setEname(keyword);
//			dto.setJob(keyword);
//		}
		
		dto.setType(type);
		dto.setKeyword(keyword);
		
		dto.setUpdown(updown);
		dto.setTypeud(typeud);
		
		dto.setOrderColumn(orderColumn);
		dto.setOrderType(orderType);
		
		
		List list = empDAO.getEmpList(dto);
		System.out.println("list.size() : " + list.size());
		
		request.setAttribute("list", list);
		request.setAttribute("keyword", keyword);
		request.setAttribute("type", type);
		request.getRequestDispatcher("/emp.jsp").forward(request, response);
		
	}
}
