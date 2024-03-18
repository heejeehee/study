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
                <th>job</th>
                <th>mgr</th>
                <th>hiredate</th>
                <th>sal</th>
                <th>comm</th>
                <th>deptno</th>
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
                <td><%=item.getJob()%></td>
                <td><%=item.getMgr()%></td>
                <td><%=item.getHiredate()%></td>
                <td><%=item.getSal()%></td>
                <td><%=item.getComm()%></td>
                <td><%=item.getDeptno()%></td>
            </tr>
            <input type="hidden" name="empno" value=<%=item.getEmpno()%>>
            <%
            }
            } else {
            %>
            	<th colspan="8">표시할 내용이 없습니다!</th>
            <%
            }
            %>
        </table>
        <br>
        <button type="button" id="updateBtn">수정하기</button>
        <button type="button" id="updateDoneBtn">수정완료</button>       
        <button type="button" id="deleteBtn">삭제하기</button>
    </form>
    
    <script>
        document.getElementById("updateBtn").addEventListener("click", function() {
        	console.log("클릭");
        	let isUpdate = confirm("수정합니까?");
        	if(isUpdate){
            var rows = document.querySelectorAll("table tr:not(:first-child)");
	            rows.forEach(function(row) {
	                var cells = row.querySelectorAll("td");
	                cells.forEach(function(cell, index) {
	                    var cellText = cell.innerText;
	                    var input = document.createElement("input");
	                    input.setAttribute("type", "text");
	                    input.setAttribute("value", cellText.trim());
	                    input.setAttribute("name", "empInfo" + index);
	                    if (index === 0) { // 첫 번째 칸일 때
	                        input.setAttribute("readonly", "readonly"); // readonly 속성 추가
	                    }
	                    cell.innerHTML = "";
	                    cell.appendChild(input);
	                });
	            });
		        document.getElementById("updateDoneBtn").addEventListener("click", function(){
			        document.getElementById("myForm").action = "empupdate"
			        document.getElementById("myForm").submit();	        	
		        })
        	}
        });
        
        document.querySelector("#deleteBtn").addEventListener("click", function(){
        	let isDel = confirm("삭제합니까?");
        	if(isDel){
        		document.getElementById("myForm").action = "empdelete"
			    document.getElementById("myForm").submit();
        	}
        })
        
    </script>
</body>
</html>