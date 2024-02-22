package org.zerock.w1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sample")
public class SampleServlet extends HttpServlet {

    public SampleServlet() {
    	System.out.println("생성자");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 실행");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 실행");

		PrintWriter out = response.getWriter();
		out.println("<h1>");	
		out.print("Hello, servelet!");
		out.write("</h1>");
		out.append("!");
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doPost() 실행");
//		doGet(request, response);
//		여기를 주석처리 하면 오류가 남.
//	}

}
