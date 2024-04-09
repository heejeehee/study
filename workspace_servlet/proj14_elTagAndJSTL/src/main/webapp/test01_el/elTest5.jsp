<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 뭔가 있으면 false 없으면 true --%>
<jsp:useBean id="m2" class="java.util.ArrayList" scope="page"></jsp:useBean>

m2(ArrayList)를 생성 : null은 아니고 size() = 0 인 상태<br>
\${ empty m2 } : ${ empty m2 }<br><%-- true --%>

<%
	m2.add(1);
%>
m2.add(1) 이후에는 false<br>
\${ empty m2 } : ${ empty m2 }<br><%-- false --%>

<hr>
출력할 거리가 있으면 empty는 false<br>
출력할 거리가 있으면 empty는 true<br>
\${ empty "글씨" } : ${ empty "글씨" }<br><%-- false --%>
\${ empty null } : ${ empty null }<br><%-- false --%>
\${ empty "" } : ${ empty "" }<br><%-- false --%>

<hr>
\${ null } : [${ null }]<br>

<%=
	"asdafsdf".isEmpty()
%>
<br>
<%=
	"asdafsdf".isBlank()
%>
<br>
<%=m2.isEmpty() %>
</body>
</html>