package org.zerock.w1.todo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/register")
public class ToDoRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 실행");
		System.out.println("입력 화면을 볼 수 있도록 구성");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/register.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("입력을 처리하고 목록 페이지로 이동");
		
		response.sendRedirect("/SelfToDoList/todo/list");
		
	}

}
