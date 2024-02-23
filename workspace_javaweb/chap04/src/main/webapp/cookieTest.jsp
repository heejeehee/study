<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
.popup {
	border: 1px solid red;
	width: 300px;
	height: 100px;
	background-color: green;
	color: #fff;
}

.hide {
	display: none;
}
</style>

</head>

<body>

	<div class="popup">
		공지입니다. 아주아주 귀찮은 공지에요. <br> 
		<input type="checkbox" id="hidePopup">10초동안 열지않기.
	</div>

	<script>
		console.log(document.cookie);

		if (document.cookie != "") {
			// k=v; k2=v2; k3=v3; noShow=true;
			let cookies = document.cookie.split(";"); // 문자로 잘라서 배열로 돌려줌
			for (let i = 0; i < cookies.length; i++) {
				let cookie = cookies[i].trim(); // trim() : 앞뒤의 공백 제거 (중간 공백은 제거 안됨)

				let name = cookie.split("=")[0];
				let value = cookie.split("=")[1];

				if (name == "noShow" && value == "true") {
					document.querySelector(".popup").classList.add("hide"); // 클래스 추가하는 방법
					// document.querySelector(".popup").style.display = "none";	// css직접 주는 방법
				}
			}
		}

		document.querySelector("#hidePopup").addEventListener(
				"click",
				function() {

					if (this.checked) {

						let now = new Date(); // 현재시간
						let after_10s = now.getSeconds() + 10; // 10초 뒤 시간
						now.setSeconds(after_10s); // after_10s 로 now를 재설정

						// key
						document.cookie = "noShow=true;path=/;expires="
								+ now.toGMTString();

					}
					// TODO: 체크 해제 시 쿠키 삭제
					// document.cookie = "쿠키 내용" <= 쿠키 추가만 되는 기능
					// 쿠키를 삭제하려면
					// 만료일을 과거로 세팅한 쿠키를 추가
				})
	</script>

</body>

</html>