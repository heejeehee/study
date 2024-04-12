package com.myspring.proj27.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.proj27.emp.dao.EmpDAO;

@Service	// controller에서 @autowired해서 쓸 수 있게 만들어줌
public class EmpService {
	
	@Autowired	// @repository로 bean등록이 되어있으므로, 사용하도록 @Autowired해줌
	EmpDAO empDAO;
	
	public List listEmp() {
		return empDAO.selectEmpList();
	}
	
}
