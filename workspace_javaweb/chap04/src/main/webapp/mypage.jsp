<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	// 키가 없으면 null 리턴
	// 대문자 Boolean 은 null값을 담을 수 있음
	Boolean isLogon = (Boolean)session.getAttribute("isLogon");

	if(isLogon == null 
	|| isLogon == false){
		response.sendRedirect("cookieTest.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	내 신상 정보, 민감한 정보 표시되는 중...
</body>
</html>