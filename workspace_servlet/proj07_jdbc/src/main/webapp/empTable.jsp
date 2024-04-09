<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="example01.emp.EmpDTO"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form id="myForm" method="get" action="emps">
        <table border="1">
            <tr>
                <th>empno</th>
                <th>ename</th>
                <th>상세보기</th>
            </tr>
            <%
            List list = (List) request.getAttribute("list");
            if(list != null){
            for(int i=0; i<list.size(); i++){
            	EmpDTO item = (EmpDTO) list.get(i);            	
            %>
            <tr>
                <td><%=item.getEmpno()%></td>
                <td><%=item.getEname()%></td>
                <input type="hidden" name="empno" value=<%=item.getEmpno()%>>
                <td><button type="button" class="detailBtn">상세보기</button></td>
            </tr>
            <%
            }
            } else {
            %>
            	<th colspan="2">표시할 내용이 없습니다!</th>
            <%
            }
            %>
        </table>
        <br>
        <button type="button" id="addBtn">사원추가</button>
    </form>
    
    <script>
		function btnClick(event) {
		    let tr = event.target.parentNode.parentNode;
		    let empno = tr.querySelector("input[name='empno']").value;
		    window.location.href = "empdetail?empno=" + empno;
		}
		
		let detailBtns = document.querySelectorAll(".detailBtn");
		detailBtns.forEach(function(detailBtn){
		    detailBtn.addEventListener("click", btnClick);
		})
		
		
		
		document.querySelector("#addBtn").addEventListener("click", function(){
			window.location.href = "empInsert.jsp"			
		})
		
		

		
	</script>
</body>
</html>