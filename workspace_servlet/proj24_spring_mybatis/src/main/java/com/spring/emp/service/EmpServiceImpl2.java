package com.spring.emp.service;

import java.util.List;

import com.spring.emp.dao.EmpDAO;

public class EmpServiceImpl2 implements EmpService {
	
	private EmpDAO empDAO;
	
	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}
	
	@Override
	public List getEmpList() {
		return null;
	}
}
