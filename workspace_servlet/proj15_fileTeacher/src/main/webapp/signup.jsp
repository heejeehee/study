<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원가입</h1>
<hr>
<form method="post"
	  action="signup"
	  enctype="multipart/form-data">
	
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="text" name="pw"><br>
	이미지 : <input type="file" name="img_file" accept=".jpg, .png, .bmp"><br>
	<br>
	<input type="submit" value="가입하기">
	
</form>
</body>
</html>