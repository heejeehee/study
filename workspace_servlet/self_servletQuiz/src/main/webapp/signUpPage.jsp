<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<script>

        // 유효성 검사 true false
        let isIdAble = false;
        let isIdOk = false;
        let isPwAble = false;
        let isPwChkAble = false;
        let isNicknameAble = false;

        // 작성완료버튼
        window.addEventListener("load", function () {
            document.querySelector("#submitBtn").addEventListener("click", function () {
                if (isIdAble && isIdOk && isPwAble && isPwChkAble && isNicknameAble) {
                    let isDone = confirm("회원가입을 완료합니까?")
                    if (isDone) {
                        document.querySelector("#myForm").action = "insertUser"
                        document.querySelector("#myForm").submit();
                    }
                } if (!isIdAble) {
                    document.querySelector("#userId").style.cssText = "border: 2px solid red;"
                    document.querySelector("#idArm").style.cssText = "color: red;"
                    document.querySelector("#idArm").innerHTML = "아이디를 다시 확인하세요."
                    isIdAble = false;
                } if (!isIdOk) {
                    document.querySelector("#userId").style.cssText = "border: 2px solid red;"
                    document.querySelector("#idArm").style.cssText = "color: red;"
                    document.querySelector("#idArm").innerHTML = "중복검사를 완료하세요."
                    isIdOk = false;
                } if (!isPwAble) {
                    document.querySelector("#userPw").style.cssText = "border: 2px solid red;"
                    document.querySelector("#pwArm").style.cssText = "color: red;"
                    document.querySelector("#pwArm").innerHTML = "비밀번호를 다시 확인하세요."
                    isPwAble = false;
                } if (!isPwChkAble) {
                    document.querySelector("#userPwChk").style.cssText = "border: 2px solid red;";
                    document.querySelector("#pwChkArm").style.cssText = "color: red;";
                    document.querySelector("#pwChkArm").innerHTML = "비밀번호 확인이 일치하지 않습니다."
                    isPwAble = false;
                } if (!isNicknameAble) {
                    document.querySelector("#userNickname").style.cssText = "border: 2px solid red;"
                    document.querySelector("#nicknameArm").style.cssText = "color: red;"
                    document.querySelector("#nicknameArm").innerHTML = "닉네임을 확인해 주세요."
                    isNicknameAble = false;
                }
            })
        })


        // 아이디 유효성 검사
        window.addEventListener("load", function () {
            let userId = document.querySelector("#userId")
            let idArm = document.querySelector("#idArm")
            // 한글 검사 정규식
            let isKorean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
            // 특수문자 검사 정규식
            let isSpecialTxt = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;

            // 유효성 검사 전
            isIdAble = false;
            // console.log(isIdAble);

            // 아이디를 입력 후 벗어나는 순간(blur이벤트)
            userId.addEventListener("blur", function () {
                // 앞뒤 공백 제거
                let noTrimId = userId.value.trim();
                // 중간 공백 제거
                let completeUserId = removeMiddleSpace(noTrimId);

                if (isKorean.test(completeUserId)) {	// 한글이 있는경우
                    userId.style.cssText = "border: 2px solid red;"
                    idArm.style.cssText = "color: red;"
                    idArm.innerHTML = "영어 및 숫자만 입력해 주세요."
                    isIdAble = false;
                    // console.log(isIdAble);
                } else if (isSpecialTxt.test(completeUserId)) {  // 특수문자가 있는경우
                    userId.style.cssText = "border: 2px solid red;"
                    idArm.style.cssText = "color: red;"
                    idArm.innerHTML = "영어 및 숫자만 입력해 주세요."
                    isIdAble = false;
                    // console.log(isIdAble);
                } else if (completeUserId.length <= 5 || completeUserId.length >= 13) {	// 글자수
                    userId.style.cssText = "border: 2px solid red;"
                    idArm.style.cssText = "color: red;"
                    idArm.innerHTML = "6~12자의 아이디를 입력하세요."
                    isIdAble = false;
                    // console.log(isIdAble);
                } else {
                    userId.style.cssText = "";
                    idArm.style.cssText = "color: green;"
                    idArm.innerHTML = "사용할 아이디 : " + completeUserId;
                    isIdAble = true;
                    // console.log(isIdAble);
                }
            })
        })


        // 아이디 공백 제거 기능 (이 기능 적용 후에 유효성 검사하기)
        function removeMiddleSpace(inputId) {
            // 최초 아이디
            let convertId = "";
            // 띄어쓰기 기준으로 배열 생성
            let userInputId = inputId.split(' ');
            for (let i = 0; i < userInputId.length; i++) {
                convertId += userInputId[i].trim();
            }
            console.log("변환 완료 : " + convertId);
            return convertId;
        }

        // 아이디 중복검사 버튼
        window.addEventListener("load", function () {
            let duplicateChkBtn = document.querySelector("#duplicateChkBtn")

            duplicateChkBtn.addEventListener("click", function () {
            	if (isIdOk) {	// 이미 중복검사를 완료했을 때
            		alert("이미 중복검사를 완료했습니다.")
            	} else if (isIdAble) {     // 아이디 유효성 검사가 true면
                    // ajax요청 보내기 준비
                    let xhr = new XMLHttpRequest();
                    xhr.open("POST", "idChk", true);
                    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    xhr.onload = function () {	// send후 응답이 도착하면 실행되는 부분
                        if (xhr.status == 200) {
                            console.log("Response:", xhr.responseText);
                            if (xhr.responseText == 1) {
                                let isDone = confirm(document.querySelector("#userId").value + "\n사용하실 아이디가 맞습니까?")
                                if (isDone) {
                                    alert("중복검사 완료.")
                                	// 기존 input 요소 가져오기
                                    let oldInput = document.querySelector("#userId");
                                    let parentDiv = oldInput.parentNode;
                                    
                                    // 새로운 input 요소 생성
                                    let newInput = document.createElement("input");
                                    newInput.id = "canNotChange";
                                    newInput.readOnly = true;
                                    newInput.style.cssText = "background-color: #eaeaea; color: gray;";

                                    // 값을 복사
                                    newInput.value = oldInput.value;

                                    // 기존 input 요소를 숨김
                                    oldInput.style.display = "none";

                                    // 새로운 input 요소를 중복검사 버튼 앞에 추가
                                    parentDiv.insertBefore(newInput, document.querySelector("#duplicateChkBtn"));
                                    parentDiv.insertBefore(document.createTextNode("\u00A0"), document.querySelector("#duplicateChkBtn"));
                                    
                                    // 기존 경고문구 삭제
                                    document.querySelector("#idArm").style.cssText = "";
                                    document.querySelector("#idArm").innerHTML = "";

                                    isIdOk = true;
                                    console.log(isIdOk);
                                }
                            } else if (xhr.responseText == 0) {
                                document.querySelector("#userId").style.cssText = "border: 2px solid red;"
                                document.querySelector("#idArm").style.cssText = "color: red;"
                                document.querySelector("#idArm").innerHTML = "중복된 아이디입니다."
                                isIdOk = false;
                            } else {
                                document.querySelector("#userId").style.cssText = "border: 2px solid red;"
                                document.querySelector("#idArm").style.cssText = "color: red;"
                                document.querySelector("#idArm").innerHTML = "다시 시도해 주세요."
                                isIdOk = false;
                            }
                        } else {
                            console.log(xhr.status)
                            alert("서버 오류")
                            window.location.reload();
                        }
                    }
                    // 보내기
                    console.log("userId=", document.querySelector("#userId").value)
                    xhr.send("userId=" + document.querySelector("#userId").value)
                } else {	// 아이디 유효성 검사가 false면
                    alert("올바른 아이디를 입력하세요.")
                    userId.style.cssText = "border: 2px solid red;"
                    idArm.style.cssText = "color: red;"
                    isIdAble = false;
                }
                
            })
        })

        //////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////

        // 비밀번호 유효성 검사
        window.addEventListener("load", function () {
            let userPw = document.querySelector("#userPw")
            let userPwChk = document.querySelector("#userPwChk")
            let pwArm = document.querySelector("#pwArm")
            // 특수문자 검사 정규식
            let isSpecialTxt = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
            // 대문자 검사 정규식
            let upperAlpha = /[A-Z]/;
            // 소문자 검사 정규식
            let lowerAlpha = /[a-z]/

            // 유효성 검사 전
            isPwAble = false;
            isPwChkAble = false;

            // 비밀번호
            userPw.addEventListener("keyup", function () {

                if (userPw.value.length <= 7 || userPw.value.length >= 25) {	// 글자수
                    userPw.style.cssText = "border: 2px solid red;"
                    pwArm.style.cssText = "color: red;"
                    pwArm.innerHTML = "8~24자의 비밀번호를 입력하세요."

                    isPwAble = false;
                } else if (!isSpecialTxt.test(userPw.value)) {   // 특수문자가 없는경우
                    userPw.style.cssText = "border: 2px solid red;"
                    pwArm.style.cssText = "color: red;"
                    pwArm.innerHTML = "하나 이상의 특수문자를 사용해야 합니다."

                    isPwAble = false;
                } else if (!upperAlpha.test(userPw.value)) {     // 대문자가 없는경우
                    userPw.style.cssText = "border: 2px solid red;"
                    pwArm.style.cssText = "color: red;"
                    pwArm.innerHTML = "영어 대문자가 포함되어야 합니다."

                    isPwAble = false;
                } else if (!lowerAlpha.test(userPw.value)) {     // 소문자가 없는경우
                    userPw.style.cssText = "border: 2px solid red;"
                    pwArm.style.cssText = "color: red;"
                    pwArm.innerHTML = "영어 소문자가 포함되어야 합니다."

                    isPwAble = false;
                } else {
                    userPw.style.cssText = "border: 2px solid green;";
                    pwArm.style.cssText = "color: green;";
                    pwArm.innerHTML = "비밀번호 사용 가능.";

                    isPwAble = true;
                    console.log(isPwAble);
                }
                // 조작되는 순간 비밀번호 확인란 확인
                if (userPw.value != userPwChk.value) {
                    userPwChk.style.cssText = "border: 2px solid red;";
                    pwChkArm.style.cssText = "color: red;";
                    pwChkArm.innerHTML = "비밀번호 불일치";

                    isPwChkAble = false;
                } else if(userPw.value == 0) {
               	 	userPwChk.style.cssText = "border: 2px solid red;";
                 	pwChkArm.style.cssText = "color: red;";
                 	pwChkArm.innerHTML = "비밀번호를 입력후 시도하세요.";

                 	isPwChkAble = false;
            	} else {
                    userPwChk.style.cssText = "border: 2px solid green;";
                    pwChkArm.style.cssText = "color: green;";
                    pwChkArm.innerHTML = "비밀번호 일치";

                    isPwChkAble = true;
                    console.log(isPwChkAble);
                }
            })

            // 비밀번호 확인
            userPwChk.addEventListener("keyup", function () {
                if (userPw.value != userPwChk.value) {
                    userPwChk.style.cssText = "border: 2px solid red;";
                    pwChkArm.style.cssText = "color: red;";
                    pwChkArm.innerHTML = "비밀번호 불일치";

                    isPwChkAble = false;
                } else if(userPw.value == 0) {
               	 	userPwChk.style.cssText = "border: 2px solid red;";
                 	pwChkArm.style.cssText = "color: red;";
                 	pwChkArm.innerHTML = "비밀번호를 입력후 시도하세요.";

                 	isPwChkAble = false;
            	} else {
                    userPwChk.style.cssText = "border: 2px solid green;";
                    pwChkArm.style.cssText = "color: green;";
                    pwChkArm.innerHTML = "비밀번호 일치";

                    isPwChkAble = true;
                    console.log(isPwChkAble);
                }
            })

        })

        //////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////

        // 닉네임 중복검사
        window.addEventListener("load", function () {
            let userNickname = document.querySelector("#userNickname")
            let nicknameArm = document.querySelector("#nicknameArm")
            // 특수문자 정규식
            let isSpecialTxt = /[ `!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;

            isNicknameAble = false;

            userNickname.addEventListener("keyup", function () {
            	// 앞뒤 공백 제거
                let noTrimNickname = userNickname.value.trim();
                // 중간 공백 제거
                let completeUserNickname = removeMiddleSpace(noTrimNickname);
            	
            	
            	if(!(completeUserNickname.length >= 2 && completeUserNickname.length <= 8)){	// 글자수
            		userNickname.style.cssText = "border: 2px solid red;"
                    nicknameArm.style.cssText = "color: red;"
                    nicknameArm.innerHTML = "닉네임은 2글자 이상, 8글자 이하여야 합니다."
                    isNicknameAble = false;
            	} else if(isSpecialTxt.test(completeUserNickname)) {	// 특수문자 유무
            		userNickname.style.cssText = "border: 2px solid red;"
                    nicknameArm.style.cssText = "color: red;"
                    nicknameArm.innerHTML = "특수문자 사용이 불가능합니다."
                    isNicknameAble = false;
            	} else {	// 위 조건을 모두 통과할 경우
	                // ajax요청 보내기 준비
	                let xhr = new XMLHttpRequest();
	                xhr.open("POST", "nicknameChk", true);
	                xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	                xhr.onload = function () {	// send후 응답이 도착하면 실행되는 부분
	                    if (xhr.status == 200) {
	                        console.log("Response:", xhr.responseText);
	                        if (xhr.responseText == 1) {
	                            userNickname.style.cssText = "border: 2px solid green;"
	                            nicknameArm.style.cssText = "color: green;"
	                            nicknameArm.innerHTML = "&lt;" + completeUserNickname + "&gt;"+ " 사용 가능한 닉네임입니다."
	                            isNicknameAble = true;
	                            console.log(isNicknameAble);
	                        } else if (xhr.responseText == 0) {
	                            userNickname.style.cssText = "border: 2px solid red;"
	                            nicknameArm.style.cssText = "color: red;"
	                            nicknameArm.innerHTML = "중복된 닉네임입니다."
	                            isNicknameAble = false;
	                        } else {
	                            userNickname.style.cssText = "border: 2px solid red;"
	                            nicknameArm.style.cssText = "color: red;"
	                            nicknameArm.innerHTML = "다시 시도해 주세요."
	                            isNicknameAble = false;
	                        }
	                    } else {
	                        console.log(xhr.status)
	                        alert("서버 오류")
	                        window.location.reload();
	                    }
	                }
	                // 보내기
	                console.log("userNickname=", completeUserNickname)
	                xhr.send("userNickname=" + completeUserNickname)
            		
            	}

            })
        })


    </script>

<body>
	<h2>회원가입 페이지</h2>
	<div class="container">
		<form id="myForm" method="post" action="#">
			<div class="idTxt">
				<input id="userId" type="text" name="userId" placeholder="아이디">
				<button type="button" id="duplicateChkBtn">중복검사</button>
			</div>
			<div class="idArm">
				<span id="idArm"></span>
			</div>
			<div class="pwTxt1">
				<input id="userPw" type="password" name="userPw" placeholder="비밀번호">
				&nbsp; <span id="pwArm"></span>
			</div>
			<div class="pwTxt2">
				<input id="userPwChk" type="password" placeholder="비밀번호 확인">
				&nbsp; <span id="pwChkArm"></span>
			</div>
			<div class="nicknameTxt">
				<input id="userNickname" type="text" name="userNickname"
					placeholder="닉네임">
			</div>
			<div class="nicknameArm">
				<span id="nicknameArm"></span>
			</div>
			<br>
			<div class="btnWrap">
				<button type="button" id="submitBtn">작성완료</button>
				<button type="button" onclick="window.location.href='loginPage.jsp'">가입취소</button>
			</div>
		</form>
	</div>
</body>

</html>