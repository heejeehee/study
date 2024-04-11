package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/test/login2.do")
	public ModelAndView login2(
			// String userID = request.getParameter("userID") 과 동일한 동작
			// 변수명이 key와 같다면 @RequestParam 생략 가능
			// 기본값은 필수, 없다면 400 Bad Request 에러 발생
			@RequestParam("userID") String userID,
			@RequestParam("userName") String userName) {
		System.out.println("login2 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		mav.setViewName("result");
		
		return mav;
	}
	
	@RequestMapping("/test/login2_1.do")
	public ModelAndView login2_1(
			// required의 기본값은 true
			@RequestParam("userID") String userID,
			@RequestParam(value="userName", required=false) String userName) {
		System.out.println("login2_1 실행");
		
		System.out.println("userName : " + userName);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		mav.setViewName("result");
		
		return mav;
	}
	
	@RequestMapping("/test/login3.do")
	public ModelAndView login3(
			@RequestParam Map<String, Integer> info) {
		System.out.println("login3 실행");
		
//		System.out.println("info.get(userName) : " + info.get("userName"));
		
		ModelAndView mav = new ModelAndView();
//		mav.addObject("userID", info.get("userID"));
//		mav.addObject("userName", info.get("userName"));
		
		// Map을 add한다면?
		// input태그의 name값을 받음.
		mav.addObject("info", info);
		
		mav.setViewName("result");
		return mav;
	}
	
	
	@RequestMapping("/test/login4.do")
	public ModelAndView login4(
			// @ModelAttribute : DTO 에 알아서 넣어줌
//			@ModelAttribute MemberDTO memberDTO
			
//			MemberDTO memberDTO
			// @ModelAttribute를 생략하고 DTO만 적은 경우
			// @ModelAttribute("memberDTO")클래스 앞글자를 소문자로 바꾼 변수에 넣어 줌
			MemberDTO a) {
		System.out.println("login4 실행");
		
		ModelAndView mav = new ModelAndView();
		
		// @ModelAttribute("info") 를 쓰면 알아서 addObject 해줌
//		mav.addObject("info", memberDTO);
		
		mav.setViewName("result");
		return mav;
	}
	
	
	@RequestMapping("/test/login5.do")
	public String login5(
			@RequestParam("userID") String userID,
			@RequestParam("userName") String userName,
			Model model) {	// 전달인자로 model 받기, 알아서 들어옴
		System.out.println("login5 실행");
		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("userID", userID);
//		mav.addObject("userName", userName);
//		mav.setViewName("result");
//		return mav;
		// 더이상 modelandview를 사용하지 않고
		model.addAttribute("userID", userID);
		model.addAttribute("userName", userName);
		
		// String을 리턴해줌
		// viewResolver가 받아서 jsp로 연결해 줌
		return "result";
	}
	
	// return type이 void
	// return null
	// 위의 경우 들어온 주소의 마지막 . 이후를 제거하고
	// 즉, 들어온 주소 .jsp가 호출됨
	// http://localhost:8080/ex01/result 로 result.jsp를 부름.
	@RequestMapping("result")
	public String login5_1() {	// String 하고 return null
		System.out.println("login5_1 실행");
		return null;
	}
//	@RequestMapping("result")
//	public void login5_2() {	// void 하고 return null
//		System.out.println("login5_2 실행");
//		return "result"; // 그래도 써 주는게 읽기 쉽다.
//	}
	
	
}
