<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	\${100 } : ${100 }<br>
	100<br>
	\${"글씨" } : ${"글씨" }<br>
	\${    10 + 1     } : ${    10 + 1     }<br>
	\${ "10" + 1 } : ${ "10" + 1 } : el은 계산할때 문자를 숫자로 바꿔서 한다<br>
	\${null+10} : ${null+10}<br>
<%-- 	\${"null"+10} : ${"null"+10} : NumberFormatException<br> --%>
<hr>
	\${100 div 9} : ${100 div 9}<br><!-- 11.11111111111111 -->
	\${100 mod 9} : ${100 mod 9}<br>
<hr>
	\${ 10 eq 10 } : ${ 10 eq 10 }<br>
	\${ "hello" eq "hello" } : ${ "hello" eq "hello" }<br>
	\${ 10 ne 20 } : ${ 10 ne 20 }<br>
	\${ "hello" ne "h" } : ${ "hello" ne "h" }<br>
	\${ 10 lt 10 } : ${ 10 lt 10 }<br>
	\${ 100 gt 10 } : ${ 100 gt 10 }<br>
	\${ 100 le 10 } : ${ 100 le 10 }<br>
	\${ 100 ge 10 } : ${ 100 ge 10 }<br>
	
	\${ (100 gt 10) eq "true" } : ${ (100 gt 10) eq "true" }<br>
<hr>
	\${ (10 == 10) && (20 == 20) } : ${ (10 == 10) && (20 == 20) }<br>
	\${ (10 eq 10) and (20 == 20) } : ${ (10 eq 10) and (20 == 20) }<br>
	\${ (10 == 10) || (20 ne 30) } : ${ (10 == 10) || (20 ne 30) }<br>
	\${ (10 == 10) or (20 ne 30) } : ${ (10 == 10) or (20 ne 30) }<br>
	\${ !(20 == 10) } : ${ !(20 == 10) }<br>
	\${ not(20 eq 10) } : ${ not(20 eq 10) }<br>
	\${ !(20 != 10) } : ${ !(20 != 10) }<br>
	\${ not(20 ne 10) } : ${ not(20 ne 10) }<br>

	
</body>
</html>