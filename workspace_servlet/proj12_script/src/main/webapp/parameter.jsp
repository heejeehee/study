<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("name");
String age = request.getParameter("age");
%>

<h1>
	안녕하세요 <%=name %>님, <br>
	당신의 나이는 <%=age %>살 이군요.
</h1>
</body>
</html>