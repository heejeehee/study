<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	아이디 : ${ userID }<br>
	닉네임 : ${ userName }
	
	<hr>
	
	info.userID : ${ info.userID }<br>
	info.userName : ${ info.userName }<br>
	
	<hr>
	
	memberDTO 만 전달할 때 : ${ memberDTO.userID }<br>
	memberDTO 만 전달할 때 : ${ memberDTO.userName }<br>
	
</body>
</html>