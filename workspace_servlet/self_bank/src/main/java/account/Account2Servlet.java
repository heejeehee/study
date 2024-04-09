package account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/account2")
public class Account2Servlet extends HttpServlet {
	
	int account = 1000;
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("deposit") != null) {	// 입금이 null이 아닐 경우 (입금한 금액이 있을 경우)
			depositMoney(request, response);
			request.setAttribute("account", getAccount());
			request.getRequestDispatcher("myAccount2.jsp").forward(request, response);
		} else if(request.getParameter("withdraw") != null) {	// 출금이 null이 아닐 경우 (출금한 금액이 있을 경우)
			withdrawMoney(request, response);
			request.setAttribute("account", getAccount());
			request.getRequestDispatcher("myAccount2.jsp").forward(request, response);
		} else {	// 입금이나 출금이 없을 경우 (초기화면 로드)
			request.setAttribute("account", getAccount());
			request.getRequestDispatcher("myAccount2.jsp").forward(request, response);			
		}
	}

	public void depositMoney(HttpServletRequest request, HttpServletResponse response) {
		int deposit = 0;
		deposit = Integer.parseInt(request.getParameter("deposit"));
		setAccount(getAccount() + deposit);
	}
	
	public void withdrawMoney(HttpServletRequest request, HttpServletResponse response) {
		int withdraw = 0;
		withdraw = Integer.parseInt(request.getParameter("withdraw"));
		setAccount(getAccount() - withdraw);
	}
	
}
