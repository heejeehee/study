<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="login">
		아이디 : <input type="text" name="user_id"><br> 비밀번호 : <input
			type="password" name="user_pw"><br> 성별 : <input
			type="radio" name="gender" value="M">남 <input type="radio"
			name="gender" value="W">녀<br> 취미 : <input
			type="checkbox" name="hobby" value="축구">축구 <input
			type="checkbox" name="hobby" value="농구">농구 <input
			type="checkbox" name="hobby" value="배구">배구 <br>
		<button type="submit">로그인</button>
	</form>

	<script>
		document.querySelector("[type=submit]").addEventListener("click", function(){
			event.preventDefault(); // submit 즉 기본기능 제거
			doAjax();
		})
	
	
		function doAjax() {
			console.log("doAjax 실행")
			// ajax 객체 생성 extended markup language
			let xhr = new XMLHttpRequest();
			// 보낼 준비
			// xhr.open("get", "https://cors-anywhere.herokuapp.com/https://www.google.com");
			xhr.open("post", "login");
			// 보내기(단, 언제 끝날지 모름)
			xhr.send();

			// 다녀온 후(응답 이후)
			xhr.onload = function() {
				// 받아온 내용이 저장되는 곳
				let data = xhr.responseText;
				console.log(data);
			
//				let json = JSON.parse(data);
//	            console.log(json);
			}
		}
	</script>
</body>
</html>