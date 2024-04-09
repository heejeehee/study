<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Member6.jsp</h1>

<%
	System.out.println("useBean 실행 전");
%>

<jsp:useBean id="m" class="sec01.ex01.bean.MemberBean" scope="page" />
<jsp:useBean id="m2" class="sec01.ex01.bean.MemberBean" scope="request" />

<%
	System.out.println("useBean 실행 후");
%>

<jsp:setProperty name="m" property="*"></jsp:setProperty>

<hr>
<jsp:getProperty property="id" name="m"/>

<hr>
<%
   /* useBean이 하는 일 1
	  java 변수 선언      */
	out.println(m.getId());
%>

<hr>
<%
   /* useBean이 하는 일 2 -->
	  scope영역에 setAttribute 해 준다 */
    sec01.ex01.bean.MemberBean mreq = (sec01.ex01.bean.MemberBean)request.getAttribute("m2");	// null
	// scope가 page인 경우 pageContext.
    sec01.ex01.bean.MemberBean m3 = (sec01.ex01.bean.MemberBean)pageContext.getAttribute("m");
	out.println("mreq : " + m2.getId());
	out.println("m3 : " + m3.getId());
%> 

<%-- 
   scope
   종류			java변수			jsp에서java	변수범위
   page			this			pageContext	해당 jsp에 들어오는 순간 태어나서 jsp를 벗어나는 순간 사라짐
   request		HttpServlet		request		request요청이 발생한 순간 태어나서 응답 나갈때 삭제
   session		Httpsession		session		브라우저(세션쿠키)의 생명주기와 생을 같이 함
   application	ServletContext	application	톰캣(WAS)과 생명주기를 같이 함
--%>



</body>
</html>