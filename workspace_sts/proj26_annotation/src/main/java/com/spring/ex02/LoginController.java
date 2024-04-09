package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/test/loginForm.do")
	public ModelAndView loginForm() {
		
		System.out.println("loginForm 실행");
		return new ModelAndView("loginForm");
	}
	
	@RequestMapping("/test/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("login 실행");
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		System.out.println("userID : " + userID + ", userName : " + userName);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		mav.setViewName("result");
		
		return mav;
	} 
}
