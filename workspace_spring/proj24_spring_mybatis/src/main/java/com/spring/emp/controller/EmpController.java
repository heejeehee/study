package com.spring.emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.emp.service.EmpService;

public class EmpController extends MultiActionController{
	
	private EmpService empService;
	
	public void setEmpService(EmpService empService) {
		System.out.println("EmpController > setEmpService 실행");
		this.empService = empService;
	}
	
	public ModelAndView listMembers(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("EmpController > listMembers 실행");
		
		List list = empService.getEmpList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "hello spring");	// key value
		mav.addObject("list", list);	// key value
		mav.setViewName("listEmp");		// 보낼곳 jsp명
		
		return mav;
	}
}