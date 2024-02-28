<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="mypage.ProductPlanManagementDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>생산계획관리</title>
</head>

<body>
	<%@ include file="../mainheader.jsp"%>
	<!-- content -->
	<div id="content">

		<!-- div id="headerj" 시작 -->
		<div id="headerj">생산계획관리</div>
		<!-- div id="headerj" 끝 -->

		<!-- updiv -->
		<div class="updiv">

			<!-- header1 div -->
			<div id="header1_div">
				<!-- 버튼 div -->
				<div id="btn_wrap_div">
					<button type="button" id="btn_auto">계획자동생성</button>
					<button type="button" id="btn_plancode">계획코드부여</button>
					<button type="button" id="btn_add">추가</button>
					<button type="button" id="btn_modify">수정</button>
					<button type="button" id="btn_modify_end">수정완료</button>
					<button type="button" id="btn_delete">삭제</button>
					<button type="button" id="btn_save">저장</button>
				</div>
			</div>
			<!-- header1 div 끝 -->

			<div id="plan_table_div">
				<table id="plan_table">
					<thead id="plan_table_thead">

					</thead>
					<%
					List list = (List) request.getAttribute("list");
					%>

					<tbody id="plan_table_tbody">
						<%
						for (int i = 0; i < list.size(); i++) {
							ProductPlanManagementDTO item = (ProductPlanManagementDTO) list.get(i);
							%>
						<tr>
							<td><input type="checkbox"></td>
							<td></td>
							<td><%=item.getItemCode()%></td>
							<td><%=item.getItemName()%></td>
							<td><%=item.getOutgoing()%></td>
							<td><%=item.getQuantity()%></td>
							<td><%=item.getMakeAmount()%></td>
							<td><%=item.getRemainAmount()%></td>
							<td><%=item.getStartdate()%></td>
							<td><%=item.getEnddate()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>


		</div>
		<!-- updiv 끝 -->

	</div>
	<!-- content 끝 -->









	<div id="alarm_wrap">
		<div id="message_div">
			<span id="message">메세지입니다.</span>
		</div>
		<div id="alarm_btn_wrap">
			<button type="button" id="btn_cancel">닫기</button>
			<button type="button" id="btn_ok">확인</button>
		</div>
	</div>

	<div id="overlay"></div>

</body>

<link rel="stylesheet" href="css/production_plan_management.css">
<script src="js/production_plan_management.js"></script>

</html>