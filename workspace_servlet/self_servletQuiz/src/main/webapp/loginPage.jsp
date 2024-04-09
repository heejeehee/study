<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
    <h2>로그인 페이지</h2>
    <div class="container">
	    <form id="myForm" method="post" action="#">
	        <input type="text" name="userId" placeholder="아이디">
	        <br>
	        <input type="password" name="userPw" placeholder="비밀번호">
	        <div class="chkArm"><span id="chkArm"></span></div>
	        <br>
	        <button type="submit">로그인</button>
	        <button type="button" onclick="window.location.href='signUpPage.jsp'">회원가입</button>
	    </form>
    </div>
</body>
</html>