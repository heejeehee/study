<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
	<h1>List Page</h1>
	
	${list}
	
	<ul>
	<c:forEach var="dto" items="${list}">
		<li>${dto}</li>
	</c:forEach>
	</ul>
</body>
</html>