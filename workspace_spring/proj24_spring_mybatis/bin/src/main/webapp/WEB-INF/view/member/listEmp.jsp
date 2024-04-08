<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>listEmp.jsp</h1>
${ msg }
<hr>
${ list[0].empno } : ${ list[0].ename }<br>
${ list[1].empno } : ${ list[1].ename }<br>
${ list[2].empno } : ${ list[2].ename }<br>
<hr>
</body>
</html>