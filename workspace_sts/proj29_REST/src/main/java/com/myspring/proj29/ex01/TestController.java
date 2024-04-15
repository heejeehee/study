package com.myspring.proj29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 여기서 return 하는 모든 것들은 viewResolver를 거치지 않고 바로 브라우저로 이동함.
// @RestController : @Controller + @ResponseBody
@RestController
public class TestController {

	@RequestMapping("/test/hello")
	public String hello() {
		return "Hello";
	}

	@RequestMapping("/test/member")
	public EmpDTO member() {
		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpno(1110);
		empDTO.setEname("홍박사");
		empDTO.setSal(2800);

		return empDTO;
	}

	@RequestMapping("/test/memberList")
	public List memberList() {

		List list = new ArrayList();

		for (int i = 0; i < 3; i++) {
			EmpDTO empDTO = new EmpDTO();
			empDTO.setEmpno(i * 1000);
			empDTO.setEname("홍박사" + i);
			empDTO.setSal((i + 1000) * i);
			list.add(empDTO);
		}

		return list;
	}
	
	@RequestMapping("/test/memberMap")
	public Map memberMap() {
		
		Map map = new HashMap();

		List list = new ArrayList();

		for (int i = 0; i < 3; i++) {
			EmpDTO empDTO = new EmpDTO();
			empDTO.setEmpno(i * 1000);
			empDTO.setEname("홍박사" + i);
			empDTO.setSal((i + 1000) * i);
			list.add(empDTO);
		}
		
		map.put("total", 140);
		map.put("list", list);

		return map;
	}

	@RequestMapping("/test/notice/{num}")
	public int notice(
//			HttpServletRequest request
			@PathVariable("num") // 중괄호 중에 num을 뽑아서 int값에 넣는다.
			int num
			) {
//		int num = Integer.parseInt(request.getParameter("num"));
		return num;
	}
	
	@RequestMapping("/test/notice2/{num}/{str}")
	public String notice2(
			@PathVariable("num") int num,
			@PathVariable("str") String str1
			) {
		return str1;
	}
	
	@RequestMapping("/test/info")
	public EmpDTO info(
			// @ModelAttribute : getParameter로 받을 수 있는걸 분석
//			@ModelAttribute EmpDTO dto
			// @RequestBody : json만 받아줌, json으로 넘어온 데이터를 dto에 넣어줌
			@RequestBody EmpDTO dto
			) {
		System.out.println("dto : " + dto);
		
		return dto;
	}

}
