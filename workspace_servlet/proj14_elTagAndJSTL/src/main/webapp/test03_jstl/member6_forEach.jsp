<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.List"
	import="java.util.ArrayList"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List dataList = new ArrayList();
	dataList.add("번호0");
	dataList.add("번호1");
	dataList.add("번호2");
	dataList.add("번호3");
	dataList.add("번호4");
	dataList.add("번호5");
	dataList.add("번호6");
	dataList.add("번호7");
	dataList.add("번호8");
	dataList.add("번호9");
%>
dataList : <%=dataList %><br>
<!-- list라는 key값으로 page에 scope해 줬다. -->
<c:set var="list" value="<%=dataList %>"></c:set>

<hr>

<fieldset>
	<legend>반복</legend>
	<div>
		<c:forEach var="i" begin="1" end="5">
			<strong> i : </strong> ${ i }<br>
		</c:forEach>
	</div>
</fieldset>

<hr>

<h3>step</h3>
<c:forEach var="i" begin="1" end="10" step="4">
	<strong> i : </strong> ${ i }<br>
</c:forEach>

<hr>

<h3>varStatus</h3>
<c:forEach var="i" begin="1" end="10" step="4" varStatus="loop">
	<strong> i : </strong> ${ i }<br>
	loop.index : ${ loop.index }<br>
	loop.count : ${ loop.count }<br>
	loop.first : ${ loop.first }<br>
	loop.last : ${ loop.last }<br>
	<c:if test="${ not loop.last }">,<br></c:if>
</c:forEach>

<hr>

<h3>dataList 모두 출력</h3>
<c:forEach var="data" items="${ list }">
	${ data }<br>
</c:forEach>

<hr>

<h3>items와 begin, end 같이 사용</h3>
<c:forEach var="data" items="${ list }" begin="2" end="5">
	${ data }<br>
</c:forEach>

<hr>

<h3>end가 items의 갯수보다 큰 경우</h3>
<c:forEach var="data" items="${ list }" begin="2" end="500">
	${ data }<br>
</c:forEach>

<hr>

<h3>begin이 end보다 큰 경우</h3>
<!-- 오류는 안나지만 아무것도 안나옴 -->
<c:forEach var="data" items="${ list }" begin="5" end="2">
	${ data }<br>
</c:forEach>

<hr>

추가정보 : begin, end는 음수가 안 됨! JspTagException<br>

<hr>

<%-- 
	<c:forEach var="1.이놈은" items="${ 3.이건 외부에서 온것 }">
		${ 2.이놈이고 }<br>
	</c:forEach> 
--%>


</body>
</html>