<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<script>
    // 아이디 중복확인 버튼
    window.addEventListener("load", function(){
        document.querySelector("#idChk").addEventListener("click", function(event){
			doIdChk();
		})
		
		function doIdChk(){
			console.log("doIdChk 실행");
			let userId = document.getElementsByName("userId")[0].value;
			
            let xhr = new XMLHttpRequest();
            xhr.open("get", "idChk?userId="+userId);
            xhr.send();
            
            // 다녀온 후(응답 이후)
            xhr.onload = function () {
                // 받아온 내용이 저장되는 곳
                let data = xhr.responseText;
                console.log(data);
                if(data == 1){
                    document.querySelector("idChkArm").style.cssText="color: green;"
                    document.querySelector("idChkArm").innerHTML="사용 가능한 아이디입니다."
                } else {
                    document.querySelector("idChkArm").style.cssText="color: red;"
                    document.querySelector("idChkArm").innerHTML="사용 불가능한 아이디입니다."
                }
            }
		}
    })

    // 비밀번호 확인
    window.addEventListener("load",function(){
        document.querySelector("#userPw").addEventListener("change", function(){
            if(document.getElementsByName("userPw")[0].value == ""
            || document.getElementsByName("pwChk")[0].value == "") {
                document.querySelector("#pwChkArm").style.cssText = "color: red;"
                document.querySelector("#pwChkArm").innerHTML = "비밀번호를 입력하세요.";
            } else if(document.getElementsByName("userPw")[0].value == document.getElementsByName("pwChk")[0].value){
                document.querySelector("#pwChkArm").style.cssText = "color: green;"
                document.querySelector("#pwChkArm").innerHTML = "비밀번호가 일치합니다.";
            } else {
                document.querySelector("#pwChkArm").style.cssText = "color: red;"
                document.querySelector("#pwChkArm").innerHTML = "비밀번호가 불일치합니다.";
            }
        })
        document.querySelector("#pwChk").addEventListener("change", function(){
            if(document.getElementsByName("userPw")[0].value == ""
            || document.getElementsByName("pwChk")[0].value == "") {
                document.querySelector("#pwChkArm").style.cssText = "color: red;"
                document.querySelector("#pwChkArm").innerHTML = "비밀번호를 입력하세요.";
            } else if(document.getElementsByName("userPw")[0].value == document.getElementsByName("pwChk")[0].value){
                document.querySelector("#pwChkArm").style.cssText = "color: green;"
                document.querySelector("#pwChkArm").innerHTML = "비밀번호가 일치합니다.";
            } else {
                document.querySelector("#pwChkArm").style.cssText = "color: red;"
                document.querySelector("#pwChkArm").innerHTML = "비밀번호가 불일치합니다.";
            }
        })
    })

    // 닉네임 중복확인
    window.addEventListener("load", function(){
        document.querySelector("#userName").addEventListener("change", function(event){
			doNameChk();
		})
		
		function doNameChk(){
			console.log("doNameChk 실행");
			let userName = document.querySelector("#userName").value;
			
            let xhr = new XMLHttpRequest();
            xhr.open("get", "nameChk?userName="+userName);
            xhr.send();
            
            // 다녀온 후(응답 이후)
            xhr.onload = function () {
                // 받아온 내용이 저장되는 곳
                let data = xhr.responseText;
                console.log(data);
                if(data == 1){
                    document.querySelector("nameChk").style.cssText="color: green;"
                    document.querySelector("nameChk").innerHTML="사용 가능한 닉네임입니다."
                } else {
                    document.querySelector("nameChk").style.cssText="color: red;"
                    document.querySelector("nameChk").innerHTML="사용 불가능한 닉네임입니다."
                }
            }
		}
    })
</script>

<body>
    <form id="myForm" method="post" action="insertuser">
        <div class="container">
            <div class="userId">
                <input type="text" name="userId" placeholder="사용할 아이디를 입력하세요.">
                <input type="hidden" id="idok" name="idok" value="N">
                <button type="button" id="idChk">중복확인</button>
            </div>
            <div class="idChk"><span id="idChkArm">.</span></div>
            <div class="userPw"><input type="password" id="userPw" name="userPw" placeholder="사용할 비밀번호를 입력하세요."></div>
            <div class="pwChk"><input type="password" id="pwChk" name="pwChk" placeholder="입력한 비밀번호를 입력하세요."></div>
            <div class="pwChkArm"><span id="pwChkArm"></span></div>
            <br>
            <div class="userName"><input type="text" id="userName" name="userName" placeholder="닉네임을 입력하세요."></div>
            <div class="nameChk"><span id="nameChk">.</span></div>
            <div class="buttonWrap">
                <button type="submit">가입하기</button>
                <button type="button" onclick="location.href='login.jsp'">가입취소</button>
            </div>
        </div>
    </form>
</body>

</html>