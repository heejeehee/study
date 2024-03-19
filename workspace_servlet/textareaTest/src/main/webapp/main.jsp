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
	int result = dao.mainSelect();
%>
<h1> 작업지시서 목록 </h1>
<form id="myForm" method="get" action="#">
	<table border="1">
		<tr>
			<th>번호</th><th>작업명</th>
		</tr>
		<% 
			if(result == 1){
				for(int i=0; i<dao.seqs.size(); i++){
					int seq = dao.seqs.get(i);
					String title = dao.titles.get(i);
		%>
		<tr>
			<th><%=seq %></th>
			<td><a href="textDetail?seq=<%=seq %>"><%=title %></a></td>
		</tr>
		<% 		} %>
		<%	} else { %>
				<tr><th colspan="2">표시할 내용이 없습니다!</th></tr>
		<% 	
			}
		%>
	</table>
	<br><br>
	<button type="button" onclick="window.location.href='textarea.jsp'">작업작성</button>
</form>
</body>
</html>