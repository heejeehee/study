<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>elTag를 이용한 emp Table 출력</h1>
	<table border="1">
		<tr>
			<th>사원번호</th><th>사원명</th><th>급여</th>
		</tr>
		<c:forEach var="data" items="${ list }">
		<tr>
			<td>${ data.empno }</td><td>${ data.ename }</td><td>${ data.sal }</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>