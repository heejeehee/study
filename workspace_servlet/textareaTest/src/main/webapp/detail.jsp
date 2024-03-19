<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#wrap {
	display: block;
}
#modWrap {
	display: none;
}
#doModify {
	display: inline-block;
}
#endModify {
	display: none;
}
</style>
<body>
<form id="myForm" method="get" action="textUpdate">
<div id="wrap">
	<div><h3>작업지시서 제목 : <%=request.getAttribute("title") %></h3></div>
	<div>작업지시서 내용</div>
	<hr>
	<div><%=request.getAttribute("text_info") %></div>
</div>
<div id="modWrap">
	<input type="hidden" name="seq" value=<%=request.getAttribute("seq")%>>
	작업지시서 제목 : <input type="text" name="title" value="<%=request.getAttribute("title") %>">
	<br><br>
	<textarea name="text_info" rows="40" cols="70" value="<%=request.getAttribute("text_info") %>"><%=request.getAttribute("text_info") %></textarea>
</div>
	<br><br>
	<button type="button" id="doModify">수정하기</button>
	<button type="submit" id="endModify">수정완료</button>
	<button type="button" onclick="window.location.href='main.jsp'">목록으로</button>
</form>
<script>
	document.querySelector("#doModify").addEventListener("click", function(){
		let isModify = confirm("수정합니까?");
		if(isModify){
			document.querySelector("#wrap").style.cssText = "display: none;";
			document.querySelector("#modWrap").style.cssText = "display: block;";
			document.querySelector("#doModify").style.cssText = "display: none;";
			document.querySelector("#endModify").style.cssText = "display: inline-block;";
			let textareaValue = document.querySelector("textarea").value;
	        let formattedValue = textareaValue.replace(/<br>/g, "\n");
	        document.querySelector("textarea").value = formattedValue;
		}
	})
	document.querySelector("#endModify").addEventListener("click", function(){
		let isModify = confirm("수정을 완료합니까?");
		if(isModify){
			document.querySelector("#wrap").style.cssText = "display: block;";
			document.querySelector("#modWrap").style.cssText = "display: none;";
			document.querySelector("#doModify").style.cssText = "display: inline-block;";
			document.querySelector("#endModify").style.cssText = "display: none;";
		}
	})
	
	
	function formatTextarea() {
    let textareaValue = document.querySelector("textarea").value;
    let formattedValue = textareaValue.replace(/\n/g, "<br>");
    document.querySelector("textarea").value = formattedValue;
	}
	
	document.getElementById("myForm").addEventListener("submit", formatTextarea);
</script>
</body>
</html>