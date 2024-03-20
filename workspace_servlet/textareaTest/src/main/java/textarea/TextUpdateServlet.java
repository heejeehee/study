package textarea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/textUpdate")
public class TextUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		String seq = request.getParameter("seq");
		String title = request.getParameter("title");
		String msg = request.getParameter("text_info");
		System.out.println("seq : " + seq + ", title : " + title + ", msg : " + msg);
		
		if(title != null && msg != null) {
			TextareaDAO dao = new TextareaDAO();
			int result = dao.textUpdate(title, msg, seq);
			System.out.println(result);
			
			if (result == 1) {
				PrintWriter pw = response.getWriter();
				pw.println("<script>");
				pw.println("alert('수정 완료.');");
				pw.println("window.location.href = 'textDetail?seq=" + seq + "';");
				pw.println("</script>");
			} else {
				PrintWriter pw = response.getWriter();
				pw.println("<script>");
				pw.println("alert('작성 실패.\\n다시 시도해 주세요.');");
				pw.println("window.location.href = 'textDetail?seq=" + seq + "';");
				pw.println("</script>");
			}			
		} else {
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('내용이 없습니다.\\n다시 시도해 주세요.');");
			pw.println("</script>");
		}
		
	}

}
