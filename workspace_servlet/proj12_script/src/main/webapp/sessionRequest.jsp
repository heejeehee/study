<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String forward = (String) request.getAttribute("key1");
	String sendRd = (String) request.getAttribute("key2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	포워드방식 : <%=forward %> <br>
	리다이렉트방식 : <%=sendRd %>
</body>
</html>