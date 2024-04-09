<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="id" value="hong" />
<c:set var="age" value="23" />

\${ id == 'hong' } : ${ id == 'hong' }<br>

<c:if test="${ id eq 'hong' }">
${id }님 안녕하세요<br>
</c:if>

<c:if test="${ (id eq 'hong') and (age eq '23') }">
${id }님 나이는 ${age}입니다<br>
</c:if>

<%-- <c:if test='${age > 20 }'> --%>
<c:if test='${age gt 20 }'>
age가 20보다 큽니다<br>
</c:if>

${'acaa' > 'abzz'} : 앞 글자부터 하나씩 비교<br>
${'aa' < 'aaa'}<br>

<hr>
c:else가 없다.. 그렇다면!!!<br>

<c:if test='${ not (age gt 20) }'>
age가 20보다 큽니다의 반대<br>
</c:if>

<%-- <c:if test='${ !( (age > 20) && (age < 30) ) }'> --%>
<%-- <c:if test='${ not (   (age gt 20) and (age lt 30)     ) }'> --%>
<c:if test='${ (age <= 20) || (age >= 30) }'>
age가 20보다 큽니다의 반대<br>
</c:if>
의심나면 그냥 출력해보기 : \${ (age <= 20) || (age >= 30) } : ${ (age <= 20) || (age >= 30) }

<c:if test='true'>
<c:if test='false'>






</body>
</html>