package org.zerock.w1.todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.w1.todo.dto.TodoDTO;
import org.zerock.w1.todo.service.TodoService;

@WebServlet("/todo/list")
public class ToDoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 실행...");
		
		List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
		
		request.setAttribute("list", dtoList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/list.jsp");
		dispatcher.forward(request, response);
	}

}
