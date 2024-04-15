package com.myspring.proj29.ex01;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// class를 controller bean으로 등록함

// @RestController
// @Controller + @ResponseBody

@RequestMapping("/human/*")
// class 공통 접속 주소
public class ParamController {

	@Autowired
	// 해당 변수 파일에 맞는 bean을 찾아서 new해서 주입까지 해 준다
	EmpDTO empDTO;
	
	@RequestMapping(
			// value와 {}로 두개 이상의 주소를 연결 가능
			value= {"/a", "/b", "/a/{name}"},
			// method 제한, 없으면 모두 다 허용, {}로 두개 이상의 제한 가능
			method = {RequestMethod.GET, RequestMethod.POST}
			)
	@ResponseBody
	// json으로 돌려줌
	public EmpDTO paramTest(
			HttpServletRequest req,
			HttpServletResponse resp,
			Model model,
			@RequestParam("id") String id,
			// String id = req.getParameter("id")
			// 단 id가 null인 경우 400 Bad Request
			String idSame,
			// @RequestParam("idSame") key와 변수가 같다면 생략가능 (윗줄과 동일)
			@RequestParam(value="id2", required=false) String id2,
			// 필수로 넣지 않아도 됨
			@RequestParam Map map,
			// 뭐든 map에 key, value로 담아준다
			@ModelAttribute EmpDTO dto1,
			// getParameter가 가능한 것을 알아서 dto에 넣음
			@ModelAttribute("dto3") EmpDTO dto2,
			// model.addAttribute("dto3",dto2)와 동일
			EmpDTO dtoSame,
			// 바로 윗줄과 동일
			@PathVariable("name") String name,
			// 주소 중 key에 해당하는 글씨 ("/a/{name}")
			@RequestBody EmpDTO dto5
			// 'get방식과 get방식이 아닌것' 으로 구분 후 넘어온 json을 분석해서 dto5에 넣음
			) {
		
		return null;
	}
	
}
