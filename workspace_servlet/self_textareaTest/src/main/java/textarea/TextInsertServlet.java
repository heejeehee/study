package textarea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import textarea.TextareaDAO;

@WebServlet("/textInsert")
public class TextInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		String title = request.getParameter("title");
		String msg = request.getParameter("textarea");
		System.out.println("title : " + title + ", msg : " + msg);
		
		if(title != null && msg != null) {
			TextareaDAO dao = new TextareaDAO();
			int result = dao.insertText(title, msg);
			System.out.println(result);
			
			if (result == 1) {
				PrintWriter pw = response.getWriter();
				pw.println("<script>");
				pw.println("alert('작성 완료.\\n게시판으로 이동합니다.');");
				pw.println("window.location.href = 'main.jsp';");
				pw.println("</script>");
			} else {
				PrintWriter pw = response.getWriter();
				pw.println("<script>");
				pw.println("alert('작성 실패.\\n다시 시도해 주세요.');");
				pw.println("window.location.href = 'textarea.jsp';");
				pw.println("</script>");
			}			
		} else {
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('내용이 없습니다.\\n다시 시도해 주세요.');");
			pw.println("window.location.href = 'textarea.jsp';");
			pw.println("</script>");
		}
	}

}
