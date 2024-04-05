package com.spring.member.dao;

import javax.sql.DataSource;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberDAO {
	
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
