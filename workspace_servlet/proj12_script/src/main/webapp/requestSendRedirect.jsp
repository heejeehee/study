<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setAttribute("key1", "value1");
	
	response.sendRedirect("sessionRequest.jsp");
%>