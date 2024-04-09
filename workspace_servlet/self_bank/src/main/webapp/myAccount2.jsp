<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="account2">
	현재 잔액 : <%=request.getAttribute("account") %>원
	<br><br>
	<button type="button" onclick="location.href='deposit2.jsp'">입금하기</button>
	<button type="button" onclick="location.href='withdraw2.jsp'">출금하기</button>
</form>
</body>
</html>