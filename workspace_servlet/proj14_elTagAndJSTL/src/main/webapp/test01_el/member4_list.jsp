<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="memberList" class="java.util.ArrayList" />

<jsp:useBean id="m1" class="sec01.ex01.bean.MemberBean"></jsp:useBean>
<jsp:setProperty property="id" name="m1" value="id1"/>
<%
	sec01.ex01.bean.MemberBean m2 = new sec01.ex01.bean.MemberBean();
	m2.setId("id2");
	
	memberList.add(m1);
	memberList.add(m2);
%>
<hr>
<%
	sec01.ex01.bean.MemberBean bean = (sec01.ex01.bean.MemberBean)memberList.get(0);
	out.print( bean.getId() );
%>
<hr>
<%= ((sec01.ex01.bean.MemberBean)memberList.get(0)).getId() %>
<hr>
\${ memberList[0].id } : ${ memberList[0].id }<br>
\${ memberList[0]["id"] } : ${ memberList[0]["id"] }<br>
<br>
\${ memberList[1].id } : ${ memberList[1].id }<br>


</body>
</html>