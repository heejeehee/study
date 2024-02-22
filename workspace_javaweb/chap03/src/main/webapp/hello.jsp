<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	    
    import="java.util.ArrayList"
    import="java.util.List"
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Title</title>
</head>
<body>
<%
int a = 10;
for(int i=0; i<3; i++){
%>
	<h1>Hello, JSP</h1>
<%
}
%>

<%
	out.println("<h2>subject</h2>");
%>

<!-- html주석 -->
<%-- jsp 주석 --%>

a : <%= a %><br>
a : <% out.println(a); %><br>
<!--  a : <% out.println(a); %><br> -->

<%
	String id = request.getParameter("id");
%>

id: <input type="text" value="<%= id %>"><br>
id: <input type="text" value="${id}"><br>

</body>
</html>