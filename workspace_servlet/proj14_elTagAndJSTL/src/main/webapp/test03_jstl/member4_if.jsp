<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="id" value="hong" />
	<c:set var="age" value="23" />

	\${ id == 'hong' } : ${ id == 'hong' }

	<br>

	<c:if test="${ id == 'hong' }">
		${ id }님 안녕하세요.
	</c:if>

	<hr>

	<c:if test="${ (id eq 'hong') and (age eq 23) }">
		${ id }님 안녕하세요.
		${ id }님 나이는 ${ age }살 입니다.<br>
	</c:if>

	<c:if test='${ age gt 20 }'>
		age 가 20보다 큽니다.<br>
	</c:if>

	\${ id > 'ahn' } : ${ id > 'ahn' }
	<br> \${ 'abce' > 'abcd' } : ${ 'abce' > 'abcd' }
	<br> 글자비교는 글자 순서가 느린순이 크다(맨 앞자리부터 비교함)
	<br> \${ 'aa' < 'aaa' } : ${ 'aa' < 'aaa' }
	<br> 같은 글자면 글자가 많은게 크다.
	<br>

	<hr>
	<hr>

	<c:if test="${ !((age > 20) && (age < 30)) }">
	age가 20보다 큽니다의 반대<br>
	</c:if>
	<hr>
	<c:if test="${ ( (age <= 20) || (age >= 30) ) }">
	느낌표 없이 표현하기(분배법칙)
	</c:if>
	
	확인차 \${ ( (age <= 20) || (age >= 30) ) } : ${ ( (age <= 20) || (age >= 30) ) } 그냥 출력해보기<br>
	<c:if test="true"/><br>
	<c:if test="false"/><br>
	실질적으로 위 두가지가 오는 것.<br>
	el태그가 true나 false를 글자로 돌려주는 것을 이용해서 사용.<br>
	
</body>
</html>