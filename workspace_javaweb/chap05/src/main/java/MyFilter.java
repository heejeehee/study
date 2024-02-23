

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/*")
public class MyFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public MyFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		System.out.println("doFilter 실행");
		
		// 모든 곳에서 반복해야 할 작업
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		

		long start = System.currentTimeMillis();
		
		
		if(request instanceof HttpServletRequest) {

			HttpServletRequest req = (HttpServletRequest) request;
			
			String url = req.getRequestURI();
			System.out.println("요청url : " + url);
			
			if(url.indexOf("login.jsp") != -1
			|| url.indexOf("/logout") != -1
//			|| url.indexOf(".css") != -1
//			|| url.indexOf(".js") != -1
			|| url.indexOf("/assets/") != -1
			|| url.indexOf("login.do") != -1) {
				// 그냥 통과
				chain.doFilter(request, response);
			} else {
				HttpSession session = req.getSession();
				
				String isLogon = (String)session.getAttribute("isLogon");
				
				if("OK".equals(isLogon)/* 로그인 했다면 */) {
					chain.doFilter(request, response);  // 요청받은것 실행
				} else /* 로그인을 안했다면 */{
					HttpServletResponse resp = (HttpServletResponse)response;
					resp.sendRedirect("login.jsp");
				}				
			}
			
		}
		
//		// 서블릿 등의 동작
//		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간[ms] : " + (end-start) );
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
