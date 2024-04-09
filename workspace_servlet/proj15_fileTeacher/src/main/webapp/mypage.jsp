<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

프사<br>
<img width="100" height="100" style="border-radius: 50% 50%;border:1px solid black;" src="download.do?fileName=${signupDTO.filename }"><br>
<br>
아이디 : <span>${signupDTO.id }</span><br>
비번 : <span>${signupDTO.pw }</span><br>

</body>
</html>