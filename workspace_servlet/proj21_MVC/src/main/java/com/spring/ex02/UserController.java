package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userID = request.getParameter("userID");
		String passwd = request.getParameter("passwd");
		
		ModelAndView mav = new ModelAndView();
//		ModelAndView mav = new ModelAndView("result"); 이렇게도 가능
		// setViewName : jsp의 이름만 적으면 앞, 뒤를 알아서 채워줌, ModelAndView 가 값을 가지고 갈곳.(포워딩)
		mav.setViewName("result");
		
		
		// view로 보낼 값들, setAttribute랑 비슷함.
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		
		request.setAttribute("abcd", 1234);
		
		
		return mav;	// handelermapping이 받음
	}

	
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String viewName = "memberInfo";
		
		// 아이디어 1
		if("admin".equals(request.getParameter("id"))) {	// id값이 admin이면
			viewName = "memberAdmin";	// admin 전용 jsp로 보내는 방식
		}
		
		ModelAndView mav = new ModelAndView(viewName);	// 생성자를 통해 setViewName 실행
		
		mav.addObject("id", request.getParameter("id"));
		mav.addObject("pw", request.getParameter("pw"));
		
		return mav;
	}
	
	
}
