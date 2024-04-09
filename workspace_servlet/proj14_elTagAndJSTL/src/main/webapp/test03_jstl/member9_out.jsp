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

<h1> c:out </h1>

${ param.id } : ${ param.id }<br>
&lt;c:out value="paramid"&gt; : <c:out value="paramid"></c:out><br>
&lt;c:out value="\${ param.id }"&gt; : <c:out value="${ param.id }"></c:out><br>

<!-- 
	?id=<a href="http://naver.com">a</a> 같이 특수문자를 치환해서 문자 그 자체로 바꿔서 전달함.
	?id=&lt;a href=&#034;http://naver.com&#034;&gt;a&lt;/a&gt; 이런식으로 
-->

</body>
</html>