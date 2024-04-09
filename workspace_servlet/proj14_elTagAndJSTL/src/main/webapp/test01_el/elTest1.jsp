<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	\${ 100 } : ${ 100 }<br>
	\${ "글씨" } : ${ "글씨" }<br>
	\${ 10+1     } : ${ 10+1          }<br>
	\${ "10"+1 } : ${ "10"+1 } //(el은 계산할 때 문자를 숫자로 바꿔서 계산한다.)<br>
	\${ null + 10 } : ${ null + 10 } //(null은 0으로 바뀜)<br>
<%--\${ "null" + 10 } : ${ "null" + 10 } //(java.lang.NumberFormatException: For input string: "null")<br> 
		"null"이라는 글자는 숫자로 바꿀 수 없다.--%>
		
<%-- 	\${ 100 div 9 } : ${ 100 div 9 }<br>  11.11111111111111 --%>
	\${ 100 mod 9 } : ${ 100 mod 9 }<br>
	
	\${ (100 gt 10) eq "true" } : ${ (100 gt 10) eq "true" } // true, false의 결과가 글씨 판정<br>

</body>
</html>