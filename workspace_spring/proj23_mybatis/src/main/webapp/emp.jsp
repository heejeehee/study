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
<style>
	.ename {
		cursor: pointer;
	}
</style>
<script>

let keyword = '${keyword}'
let type = '${type}'

//	window.onload = ()=>{}
//	document.addEventListener("DOMContentLoaded")
	window.addEventListener("load", ()=>{
		// class를 이용해서 선택
//		let enames = document.querySelectorAll(".ename");
		// id의 패턴을 이용해서 선택
		let enames = document.querySelectorAll("[id^=ename]");
		// data-ename의 패턴을 이용해서 선택
//		let enames = document.querySelectorAll("[data-ename^=ename]");
		for(let i=0; i<enames.length; i++){
			enames[i].addEventListener("click", (e)=>{
				// 클릭된 요소
				event.target.parentNode.parentNode.querySelector("form").submit();
			})
		}
		
		document.querySelector(".empno").addEventListener("click", ()=>{
			let frm = document.querySelector("#frm")
			frm.querySelector("[name=orderColumn]").value = "empno";
			frm.querySelector("[name=orderType]").value = "desc";
			
			frm.submit();
		})
		
		
	})
</script>

</head>
<body>
<a href="${pageContext.request.contextPath}/test03/empForm.jsp">회원가입</a>
<hr>
ename : ${ ename }<br>
<hr>
map : ${ map }<br>
<hr>

<form id="frm" method="get" action="dynamic">
	<select name="type">
		<%-- <c:if test="${ type == 1 }">
			<option value="1" selected>이름</option>
		</c:if>
		<c:if test="${ type != 1 }">
			<option value="1">이름</option>
		</c:if>
		<c:if test="${ type == 2 }">
			<option value="2" selected>연봉(이상)</option>
		</c:if>
		<c:if test="${ type != 2 }">
			<option value="2">연봉(이상)</option>
		</c:if>
		
		<%
			String selected = "";
			String type= (String) request.getAttribute("type");
			if("2".equals(type)){
				selected = " selected";
			}
		%>
		<option value="2" <%=selected %>>연봉(이상)</option> --%>

		<option value="1" ${ type == 1 ? "selected" : "" }>이름</option>
		<option value="2" ${ type == 2 ? "selected" : "" }>연봉(이상)</option>
		<option value="3" ${ type == 3 ? "selected" : "" }>연봉(이하)</option>
		<option value="4" ${ type == 4 ? "selected" : "" }>직책</option>
		<option value="5" ${ type == 5 ? "selected" : "" }>이름+직책</option>
		
	</select>
	<input type="text" name="keyword" value="${ keyword }">
	<input type="submit" value="검색">
	
	<input type="hidden" name="orderColumn" value="">
	<input type="hidden" name="orderType" value="">
	
</form>

<table border="1">
	<thead>
	<tr>
		<th class="empno">
			<c:if test="${orderColumn == 'empno'}">
				<c:if test="${orderType == 'desc'}">
					<strong>empno ↓</strong>
				</c:if>
				<c:if test="${orderType != 'desc'}">
					<strong>empno ↑</strong>
				</c:if>
			</c:if>
			<c:if test="${orderColumn != 'empno'}">
				empno
			</c:if>
		</th>
		<th class="ename">ename</th>
		<th class="job">job</th>
		<th class="sal">sal</th>
		<th class="deptno">deptno</th>
	</tr>
	<tr>
		<th class="empno">empno<a href="dynamic?typeud=1&updown=asc&type=${ type }&keyword=${ keyword }">▲</a><a href="dynamic?typeud=1&updown=desc&type=${ type }&keyword=${ keyword }">▼</a></th>
		<th class="ename">ename<a href="dynamic?typeud=2&updown=asc&type=${ type }&keyword=${ keyword }">▲</a><a href="dynamic?typeud=2&updown=desc&type=${ type }&keyword=${ keyword }">▼</a></th>
		<th class="job">job<a>▲</a><a>▼</a></th>
		<th class="sal">sal<a>▲</a><a>▼</a></th>
		<th class="deptno">deptno<a>▲</a><a>▼</a></th>
	</tr>
	</thead>
	<tbody>
		<c:if test="${ not empty list }">
			<c:forEach var="dto" items="${ list }">
				<tr>
					<td>${ dto.empno }</td>
					<form method="post" action="${pageContext.request.contextPath}/param">
						<input type="hidden" name="action" value="actionDetail">
						<input type="hidden" name="empno" value="${ dto.empno }">
						<td><span class="ename" id="ename_${ dto.empno }" data-ename="ename_${ dto.empno }">
							${ dto.ename }
						</span></td>
					</form>
					<td>${ dto.job }</td>
					<td>${ dto.sal }</td>
					<td>${ dto.deptno }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${ empty list }">
			<tr>
				<td colspan="5">조회할 내용이 없습니다.</td>
			</tr>
		</c:if>
	</tbody>
</table>

<hr>

<table border="1">
	<thead>
	<tr>
		<th>empno</th>
		<th>ename</th>
		<th>sal</th>
	</tr>
	</thead>
	<tbody>
		<c:if test="${ not empty list2 }">
			<c:forEach var="dto" items="${ list2 }">
				<tr>
					<td>${ dto.empno }</td>
					<td>${ dto.ename }</td>
					<td>${ dto.sal }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${ empty list2 }">
			<tr>
				<td colspan="3">조회할 내용이 없습니다.</td>
			</tr>
		</c:if>
	</tbody>
</table>

</body>
</html>