package textarea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/textDetail")
public class TextDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		String seq = request.getParameter("seq");
		int cvSeq = Integer.parseInt(seq);
		if (seq != null) {
			TextareaDAO dao = new TextareaDAO();
			int result = dao.mainDetailSelect(cvSeq);
			System.out.println(result);

			System.out.println( dao.map.get("seq") );
			System.out.println( dao.map.get("title") );
			System.out.println( dao.map.get("text_info") );
			
			request.setAttribute("seq", dao.map.get("seq"));
			request.setAttribute("title", dao.map.get("title"));
			request.setAttribute("text_info", dao.map.get("text_info"));
			
			request.getRequestDispatcher("/detail.jsp").forward(request, response);
		}

	}
}
