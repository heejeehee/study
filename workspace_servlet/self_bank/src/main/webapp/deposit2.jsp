<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="account.Account2Servlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="account2">
	
	입금할 금액 : <input type="number" id="deposit" name="deposit">원
	<br><br>
	<button type="submit">입금</button>
</form>
</body>
</html>