package org.zerock.w1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/param")
public class ParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 들어오는 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");

		// 내보내는 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

		// 브라우저에서 보낸 값을 확보
		// key 에 해당하는 값이 없으면 null
		String key = request.getParameter("key");
		System.out.println("key : " + key);

		// input에 값이 없으면 ""(아무것도 넣지 않은 값)이 옴. null은 아님
		String id = request.getParameter("id");
		System.out.println("id : " + id);

		PrintWriter pwout = response.getWriter();
		pwout.println("key : [" + key + "]<br>");
		pwout.println("id : [" + id + "]<br>");

		// key game이 여러개인 경우 getParameter 를 쓰면 첫번째 get 하나만 가져옴
		String game = request.getParameter("game");
		System.out.println("game : " + game);
		pwout.println("game 단독 : [" + game + "]<br>");

		// 여러개 받는 방법
		String[] games = request.getParameterValues("game");
		if (game != null) {
			for (String g : games) {
				System.out.println("game : " + g);
				pwout.println("game 반복 : [" + g + "]<br>");
			}
		} else {
			pwout.println("선택한 게임이 없습니다!<br>");
		}

		// name값을 모를때
		Enumeration en = request.getParameterNames();
		while (en.hasMoreElements()) {		// 다음 요소가 있는가 체크
			String name = (String)en.nextElement();		// 있으면 가져옴
			System.out.println("name : " + name);
			
			String[] values = request.getParameterValues(name);
			if (values != null) {
				for (String g : values) {
					System.out.println("values : " + g);
					pwout.println("values 반복 : [" + g + "]<br>");
				}
			} else {
				pwout.println("선택한 게임이 없습니다!<br>");
			}
		}

	}

}
