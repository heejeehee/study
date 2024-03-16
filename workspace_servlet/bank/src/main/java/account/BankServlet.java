package account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankServlet
 */
@WebServlet("/bank")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int jango = 0;

    public BankServlet() {
        super();
        System.out.println("bank 생성");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("type");
		String str_in = request.getParameter("in");
		String str_out = request.getParameter("out");
		
		System.out.println("type : "+ type);
		System.out.println("str_in : "+ str_in);
		System.out.println("str_out : "+ str_out);
		
		String msg = null;
		if(type != null) {
			if("1".equals(type)) {
				if(str_in == null || "".equals(str_in)) {
					msg = "입금액을 확인하세요";
				} else {
					int money_in = Integer.parseInt(str_in);
					if(money_in <= 0) {
						msg = "입금액을 확인하세요";
					} else {
						jango = jango + money_in;
					}
				}
			
			} else if("2".equals(type)) {
				
				int money_out = Integer.parseInt(str_out);
				jango = jango - money_out;
				
			}
		}
		
		out.println("<h1>휴먼 은행</h1>");
		out.println("<div>현재 잔액 : "+ jango +"원</div>");
		if(msg != null) {
			out.println("____"+ msg);
		}
		out.println("<hr>");
		out.println("");
		out.println("<form method='get' action='bank'>");
		out.println("	입금 : <input type='text' name='in'>"); 
		out.println("	<input type='text' name='type' value='1'>"); 
		out.println("	<input type='submit' value='입금하기'>");
		out.println("</form>");
		out.println("");
		out.println("<form method='get' action='bank'>");
		out.println("	출금 : <input type='text' name='out'>");
		out.println("	<input type='text' name='type' value='2'>");
		out.println("	<input type='submit' value='출금하기'>");
		out.println("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
