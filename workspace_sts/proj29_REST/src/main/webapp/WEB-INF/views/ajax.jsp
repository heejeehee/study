<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<button type="button">ajax</button>

	<script>
		document.querySelector("button").addEventListener("click", ()=>{
			let url = "/proj29/rest/ajax";
	
			// ajax 객체 생성
			let xhr = new XMLHttpRequest();
			
			// post로 ajax보낼 준비
			xhr.open("post", url);
			
			// 보내는 타입 설정(json으로 보낼테니 json으로 받아라)
			xhr.setRequestHeader("Content-Type", "application/json");
			
			// json 데이터 생성
			let data = 
			{
				"ename" : "이름",
				"sal" : 3000
			}
			let strData = JSON.stringify(data)
			
			// 보내기
			xhr.send(strData);
	
			// 다녀온 후(응답 이후)
			xhr.onload = function() {
				// 받아온 내용이 저장되는 곳
				let data = xhr.responseText;
				console.log(data);
	
				let json = JSON.parse(data);
				console.log(json);
				console.log(json.ename);
				console.log(json["sal"]);
			}
		})
	</script>
</body>
</html>