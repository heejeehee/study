<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>LoginPage</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">

	아이디 : <input type="text" name="userId"><br>
	패스워드 : <input type="password" name="userPw"><br>
	
	<select name="userType">
		<c:forEach var="type" items="${userType}">
			<option value="${type}">${type}</option>
		</c:forEach>
	</select>
	
	<br>
	
	<input type="submit" value="로그인">
	
</form>

</body>
</html>
