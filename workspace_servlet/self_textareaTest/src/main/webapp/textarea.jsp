<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="myForm" method="get" action="textInsert">
	<h1>작성하기</h1>
		제목 : <input type="text" name="title">
		<br><br>
		<textarea name="textarea" rows="40" cols="70"></textarea>
	<br><br>
	<button type="submit">작성완료</button>
</form>

<script>
function formatTextarea() {
    let textareaValue = document.querySelector("textarea").value;
    let formattedValue = textareaValue.replace(/\n/g, "<br>");
    document.querySelector("textarea").value = formattedValue;
}

document.getElementById("myForm").addEventListener("submit", formatTextarea);
</script>
</body>
</html>