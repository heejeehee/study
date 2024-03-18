<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form id="myForm" method="post" action="#">
        <table>
            <tr>
                <td><input type="text" name=userId placeholder="아이디"></td>
                <td rowspan="2"><button type="submit">로그인</button></td>
            </tr>
            <tr>
                <td><input type="password" name=userPw placeholder="비밀번호"></td>
            </tr>
        </table>
        <br>
        <button type="button" id="insertUser" onclick="location.href='insertUser.jsp'">회원가입</button>
    </form>
</body>
</html>