<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="textarea.TextareaDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	TextareaDAO dao = new TextareaDAO();
	dao.mainSelect();
	List<String> titles = dao.getList();
%>
<h1> 작업지시서 </h1>
<form id="myForm" method="get" action="#">
	<table border="1">
		<tr>
			<th>작업명</th>
		</tr>
		<% 
			if(titles != null){
				for(int i=0; i<titles.size(); i++){
					String title = titles.get(i);
		%>
		<tr>
			<td><a href="textDetail?title=<%=title %>"><%=title %></a></td>
		</tr>
		<% 		} %>
		<%	} else { %>
				<tr><th>표시할 내용이 없습니다!</th></tr>
		<% 	
			}
		%>
	</table>
	<br><br>
	<button type="button" onclick="window.location.href='textarea.jsp'">작업작성</button>
</form>
</body>
</html>