package com.spring.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller	// Controller bean(클래스)으로 등록한다
@RequestMapping("/test")	// 클래스에 적용한 RequestMapping 은 HandlerMapping이 처리함
							// 클래스에 적용한 주소는 메소드 공통으로 사용함
							// ip:port/context path/test/*
public class MainController {

	@RequestMapping("/main1.do")	// 메소드에 적용한 RequestMapping 은 HandlerAdaptor가 처리함
									// 메소드에 적용한 주소는 실질적인 주소임
	public ModelAndView main1() {
		
		System.out.println("main1 메소드 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main1 실행");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/main2.do")
	public ModelAndView main2() {
		
		System.out.println("main2 메소드 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main2 실행");
		mav.setViewName("main");
		return mav;
	}
	
	// annotation에 2개 이상 적용 시 중괄호 사용
	@RequestMapping(value={"/main3.do", "/main4.do"}, method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView main3() {
		
		System.out.println("main3,4 메소드 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main3,4 실행");
		mav.setViewName("main");
		return mav;
	}
	
}
