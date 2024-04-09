package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

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

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*")
public class EncoderFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncoderFilter() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("필터 생성");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("필터 소멸");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		

		/*
		 * 서블릿 실행 전
		 */
		System.out.println("실행 전");
		System.out.println("적은 주소 : http://localhost:8080/proj10_filter/login?user_name=꿀단지&user_pw=꿀벌");
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		PrintWriter out = response.getWriter();
		StringBuffer sb = req.getRequestURL();
		String url = sb.toString(); // 또는 String url = "" + sb;
		System.out.println("getRequestURL : " + url);
		
		String uri = req.getRequestURI();
		System.out.println("getRequestURI : " + uri);
		
		String ctxPath = req.getContextPath();
		System.out.println("getContextPath : " + ctxPath);
		
		String sPath =  req.getServletPath();
		System.out.println("getServletPath : " + sPath);
		
		String q = req.getQueryString();
		System.out.println("getQueryString : " + q);
		
		System.out.println("--------------------------------------------");
		
		if(isExclude(req.getServletPath())){
			System.out.println("로그인을 계속합니다.");
			// 서블릿 실행 (자원에 접근)
			chain.doFilter(request, response);
		} else {
			String login = (String)req.getSession().getAttribute("login");
			
			if(login == null || "".equals(login)) {
				System.out.println("로그인 정보가 없어서 로그인 페이지로 보냄");
				resp.sendRedirect("login.html");
			} else {		
				// 서블릿 실행 (자원에 접근)
				chain.doFilter(request, response);
			}
		}

		/*
		 * 서블릿 실행 후
		 */
		System.out.println("실행 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("필터 init 실행");
	}

	private boolean isExclude(String servletPath) {
		
		if(servletPath.indexOf("login.html") != -1
		|| servletPath.indexOf("/login") != -1) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
