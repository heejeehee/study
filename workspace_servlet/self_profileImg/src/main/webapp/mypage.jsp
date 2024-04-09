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


<table border="1">
	<tr>
		<th>이름</th><td>${ list[0] }<td><td rowspan="2"><img src="http://localhost:8080/self_profileImg/download?fileName=${ list[2] }"></td>
	</tr>
	<tr>
		<th>비번</th><td>${ list[1] }<td>
	</tr>
</table>

</body>
</html>