<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="myForm" action="upload" method="post" enctype="multipart/form-data" accept-charset="utf-8">
	<input type="text" name="id" placeholder="아이디"><br>
	<input type="password" name="pw" placeholder="비밀번호"><br>
	프로필사진 : <input type="file" name="profile"><br>
	<br>
	<button type="submit">등록</button>
</form>
</body>
</html>