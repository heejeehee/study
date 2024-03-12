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
    <form id="myForm" method="get" action="empinsert">
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
            <tr>
                <td><input type="number" name="empno"></td>
                <td><input type="text" name="ename"></td>
                <td><input type="text" name="job"></td>
                <td><input type="number" name="mgr"></td>
                <td><input type="date" name="hiredate"></td>
                <td><input type="number" name="sal"></td>
                <td><input type="number" name="comm"></td>
                <td><input type="number" name="deptno"></td>                
            </tr>
        </table>
        <br>
        <button type="submit">추가완료</button>
    </form>
</body>
</html>