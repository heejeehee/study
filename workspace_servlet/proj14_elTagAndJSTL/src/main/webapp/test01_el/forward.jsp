<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setAttribute("addr", "천안시");
	session.setAttribute("addr2", "동남구");
	
	request.setAttribute("name", "리퀘스트");
	session.setAttribute("name", "세션");
	
	
	
	String url = "member2_request.jsp";
	
// 	request.setAttribute("url2", url);

%>
<jsp:forward page="<%=url %>"></jsp:forward>
<%-- <jsp:forward page="${ url2 }"></jsp:forward> --%> <!-- 이건 가능 -->
<%-- <jsp:forward page="${ <%=url %> }"></jsp:forward> 같이 사용할 수 없음. --%>