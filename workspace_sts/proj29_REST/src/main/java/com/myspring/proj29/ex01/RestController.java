package com.myspring.proj29.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {
	
	@RequestMapping("/rest/ajax.do")
	public String ajax1() {
//		포워드 방식
		return "ajax";
	}
	
	@RequestMapping("/rest/ajax")
	// @ResponseBody : String 또는 json으로 리턴해줌
	@ResponseBody
//	public @ResponseBody EmpDTO ajax2( 이렇게도 가능
	public EmpDTO ajax2(
			// @RequestBody : post방식으로 json을 처리
			@RequestBody EmpDTO dto
			) {
		System.out.println("dto : " + dto);
		return dto;
	}
	
	@RequestMapping("/rest/redirect")
	public String redirect() {
//		sendRedirect 방식
		return "redirect:/rest/ajax.do";
	}
	
	@RequestMapping("/rest/forward")
	public String forward() {
//		sendRedirect 방식
		return "forward:/rest/ajax.do";
	}
	
}
