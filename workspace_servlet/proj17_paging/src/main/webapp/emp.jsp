<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>emp목록</h3>
<hr>

<table border="1">
	<thead>
		<tr>
			<c:if test="${ list.get(0).lv != 0}">
				<th>레벨</th>
			</c:if>
			<th>사원번호</th>
			<th>이름</th>
			<th>직속상관번호</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${ list }">
			<tr>
				<c:if test="${ vo.lv != 0}">
					<td>${ vo.lv }</td>
				</c:if>
				<td>${ vo.empno }</td>
				<c:if test="${ vo.lv == 1}">
					<td style="padding-left: ${ (vo.lv - 1) * 15 }px;">${ vo.ename }</td>
				</c:if>
				<c:if test="${ vo.lv != 1}">
					<td style="padding-left: ${ (vo.lv - 1) * 15 }px;">ㄴ${ vo.ename }</td>
				</c:if>
				<td>${ vo.mgr   }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>

<!-- 
	rowNum은 112가 올 것임
	전체수 112일 경우 : (112 / 5) + (112 % 5) = 22 + 1 = 23 페이지 ( last page가 됨 )
	나머지 있으면 한번 더돌고 끝내고
	없으면 바로 끝내면 됨.
-->
<c:if test="${ (rowNum % 5) == 0 }">
		<c:forEach var="i" begin="1" end="${ rowNum / 5 }">
			<a href="emp?page=${ i }">${ i }</a>
		</c:forEach>
</c:if>
<c:if test="${ (rowNum % 5) != 0 }">
		<c:forEach var="i" begin="1" end="${ ( rowNum / 5 ) + 1 }">
			<a href="emp?page=${ i }">${ i }</a>
		</c:forEach>
</c:if>

<hr>

<!-- 5개씩 나누기 -->

<c:set var="page" value="${ param.page }"></c:set>
<c:set var="startPage" value="${ page - ( ( page - 1 ) % 5 ) }"></c:set>
<c:if test="${ (rowNum % 5) == 0 }">
	<c:set var="endPage" value="${ ( rowNum / 5 ) }"></c:set>
	<fmt:formatNumber var="cvEndPage" type="number" maxFractionDigits="0" value="${ endPage }" />
</c:if>
<c:if test="${ (rowNum % 5) != 0 }">
	<c:set var="endPage" value="${ ( rowNum / 5 ) + 1 }"></c:set>
	<fmt:formatNumber var="cvEndPage" type="number" maxFractionDigits="0" value="${ endPage }" />
</c:if>

<c:if test="${ startPage - 1 <= 0}">
<a href="emp?page=1">&lt;&lt;</a>
</c:if>
<c:if test="${ startPage - 1 > 0}">
<a href="emp?page=${ startPage - 1 }">&lt;&lt;</a>
</c:if>



<c:if test="${ startPage + 5 <= endPage}">
	<c:forEach var="i" begin="0" end="4">
		<a href="emp?page=${ startPage + i }">${ startPage + i }</a>
	</c:forEach>
</c:if>
<c:if test="${ startPage + 5 > endPage}">
	<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
		<a href="emp?page=${ i }">${ i }</a>
	</c:forEach>
</c:if>



<c:if test="${ startPage + 5 >= endPage}">
<a href="emp?page=${ cvEndPage }">&gt;&gt;</a>
</c:if>
<c:if test="${ startPage + 5 < endPage}">
<a href="emp?page=${ startPage + 5 }">&gt;&gt;</a>
</c:if>


</body>
</html>