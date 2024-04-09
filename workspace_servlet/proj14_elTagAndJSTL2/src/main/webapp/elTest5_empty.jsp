<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="m2" class="java.util.ArrayList" scope="page"></jsp:useBean>

m2(ArrayList)를 생성 : null은 아니고 size() == 0<br>
\${ empty m2 } : ${ empty m2 }<br><!-- true -->

<%
	m2.add(1);
%>
\${ empty m2 } : ${ empty m2 }<br><!-- false -->

<hr>
출력할 꺼리가 있으면 empty는 false<br>
출력할 꺼리가 없으면 true<br>
\${ empty "글씨" } : ${ empty "글씨" }<br>
\${ empty null } : ${ empty null }<br>
\${ empty "" } : ${ empty "" }<br>

<hr>
\${null } : 123${null }456
<br>
<%="asdfasdf".isEmpty()%>
<br>
<%="asdfasdf".isBlank()%>
<br>
<%=m2.isEmpty() %>


</body>
</html>