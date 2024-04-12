<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>ListEmp</title>
</head>
<body>

ename : ${list[0].ename}<br>
empno : ${list[0].empno}<br>

<hr>

<c:forEach var="list" items="${ list }">
	${list.ename}
	${list.empno}<br>
</c:forEach>

</body>
</html>
