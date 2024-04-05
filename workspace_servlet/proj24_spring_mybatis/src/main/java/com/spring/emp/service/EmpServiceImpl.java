package com.spring.emp.service;

import java.util.List;

import com.spring.emp.dao.EmpDAO;

public class EmpServiceImpl implements EmpService {
	private EmpDAO empDAO;
	
	EmpServiceImpl(){
		System.out.println("EmpServiceImpl 생성");
	}
	
	public void setEmpDAO(EmpDAO empDAO) {
		System.out.println("EmpServiceImpl > setEmpDAO 실행");
		this.empDAO = empDAO;
	}
	
	@Override
	public List getEmpList() {
		return empDAO.selectEmp();
	}
}
