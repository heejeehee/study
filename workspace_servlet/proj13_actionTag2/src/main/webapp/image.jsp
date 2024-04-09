<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<img style="width: 100px; height: 100px;" src="https://cdn.discordapp.com/attachments/1182477407911944254/1219836481963823104/KakaoTalk_20231228_154355904.png?ex=660cc040&is=65fa4b40&hm=92cdbb212dc534016d525ae5bec6623f6a3e0a9188815e71b9f3758319fcd981&">

	<div>
		이미지 이름 : <%= request.getParameter("name") %>
	</div>

</body>
</html>