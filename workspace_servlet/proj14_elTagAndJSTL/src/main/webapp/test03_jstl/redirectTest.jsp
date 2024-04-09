<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

이 글씨는 안보입니다.
<h1>c:redirect</h1>

<c:redirect url="member5_choose.jsp">
	<c:param name="name" value="이름" />
</c:redirect>

<%--
	<c:redirect url="member5_choose.jsp">
	두개 적어도 오류는 안 남.
 --%>

</body>
</html>