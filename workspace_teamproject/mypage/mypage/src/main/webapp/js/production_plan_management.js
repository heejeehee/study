// 실행문
makeTable(1, "#plan_table_thead", 1, 10);
makeColName(1);
checkEvent(1);

// 테이블 생성
function makeTable(tableNum, theadId, x, y) {
    let thead = document.querySelector(theadId);

    for (let i = 1; i <= x; i++) {
        let tr = document.createElement('tr');
        thead.appendChild(tr);
        for (let j = 1; j <= y; j++) {
            let th = document.createElement('th');
            tr.appendChild(th);
            th.setAttribute("id", `thead${tableNum}_${i}_${j}`);
        }
    }
}

// 1줄 추가
function addRow() {
	console.log()
    let tbody = document.getElementById("plan_table_tbody"); // 테이블 ID를 적절히 변경해주세요
    let newRow = tbody.insertRow(tbody.rows.length);
    
    let cell1 = newRow.insertCell(0);
    cell1.className = "checkboxcell";
    cell1.style.textAlign = "center";
    cell1.innerHTML = '<input type="checkbox" class="table1_chkChild">';
    
    let cell2 = newRow.insertCell(1);
    cell2.className = "table1_plancode";
    cell2.innerHTML = '';
    
    for (let i = 2; i <= 9; i++) {
        let cell = newRow.insertCell(i);
        cell.innerHTML = "";
    }
}


// 컬럼명 생성
function makeColName(tableNum) {
    let checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.classList.add("table1_chkAll")
    document.querySelector(`#thead${tableNum}_1_1`).appendChild(checkbox);
    document.querySelector(`#thead${tableNum}_1_2`).appendChild(document.createTextNode("생산계획코드"))
    document.querySelector(`#thead${tableNum}_1_3`).appendChild(document.createTextNode("품목코드"))
    document.querySelector(`#thead${tableNum}_1_4`).appendChild(document.createTextNode("제품명"))
    document.querySelector(`#thead${tableNum}_1_5`).appendChild(document.createTextNode("납품처"))
    document.querySelector(`#thead${tableNum}_1_6`).appendChild(document.createTextNode("납품요구수량"))
    document.querySelector(`#thead${tableNum}_1_7`).appendChild(document.createTextNode("생산계획수량"))
    document.querySelector(`#thead${tableNum}_1_8`).appendChild(document.createTextNode("예상보유재고"))
    document.querySelector(`#thead${tableNum}_1_9`).appendChild(document.createTextNode("착수일"))
    document.querySelector(`#thead${tableNum}_1_10`).appendChild(document.createTextNode("완료일"))
}

// 전체선택 이벤트
function checkEvent(tableNum) {

    document.querySelector(`.table${tableNum}_chkAll`).addEventListener("click", function (e) {
        if (document.querySelector(`.table${tableNum}_chkAll`).checked == true) {
            document.querySelectorAll(`.table${tableNum}_chkChild`).forEach(function (chkChild) {
                chkChild.checked = true;
            })
        } else {
            document.querySelectorAll(`.table${tableNum}_chkChild`).forEach(function (chkChild) {
                chkChild.checked = false;
            })
        }
    })

    let checkboxes = document.querySelectorAll(`.table${tableNum}_chkChild`);

    checkboxes.forEach(function (checkbox) {
        checkbox.addEventListener("click", function (e) {
            let allbox = checkboxes.length;
            let nowbox = 0;

            checkboxes.forEach(function (checkbox) {
                if (checkbox.checked) {
                    nowbox++;
                }
            });

            if (allbox === nowbox) {
                document.querySelector(`.table${tableNum}_chkAll`).checked = true;
            } else {
                document.querySelector(`.table${tableNum}_chkAll`).checked = false;
            }
        });
    });

}

// 알람기능
function showAlarm(message, callback) {
    let alarm = document.querySelector("#alarm_wrap");
    let overlay = document.querySelector("#overlay");
    let txt = document.querySelector("#message");
    let btnOk = document.querySelector("#btn_ok");
    let btnCancel = document.querySelector("#btn_cancel");

    txt.innerHTML = "<span id='message'>" + message + "</span>"

    alarm.style.cssText = "display: block;"
    overlay.style.cssText = "display: block;"
    
    // 이전에 할당된 이벤트 리스너 제거
    btnOk.removeEventListener("click", btnOkClickHandler);
    btnCancel.removeEventListener("click", btnCancelClickHandler);

    // 새로운 이벤트 리스너 추가
    btnOk.addEventListener("click", btnOkClickHandler);
    btnCancel.addEventListener("click", btnCancelClickHandler);

    function btnOkClickHandler() {
        hideAlarm();
        callback(true);
    }

    function btnCancelClickHandler() {
        hideAlarm();
        callback(false);
    }
}

function hideAlarm(){
    let alarm = document.querySelector("#alarm_wrap");
    let overlay = document.querySelector("#overlay");
    
    alarm.style.cssText = "display: none;"
    overlay.style.cssText = "display: none;"
}


// 랜덤코드생성
function randomNumber() {
   	let randomNumber = Math.floor(Math.random() * 100000000);
    return randomNumber.toString().padStart(8, '0');
}

// 버튼클릭기능
window.addEventListener("load", function(){
	
	console.log("123")
    document.querySelector("#btn_auto").addEventListener("click", function () {
	    showAlarm("계획을 자동으로 생성하시겠습니까?", function (result) {
	        if (result) {
	            console.log("클릭");
	            window.location.href = "http://127.0.0.1:8080/mypage/ppms";
	        } else {
	            hideAlarm();
	        }
	    });
	});

    document.querySelector("#btn_plancode").addEventListener("click", function(){
        showAlarm("계획코드를 부여합니다.", function(result){
            if(result){
                console.log("클릭");
                if(document.getElementById("plan_table").getElementsByTagName("tr").length > 1){
					let planCodeTable = document.getElementById("plan_table").getElementsByClassName("table1_plancode");
					for(i=0; i<planCodeTable.length; i++){
						planCodeTable[i].innerHTML = randomNumber();
					}
				} else {
					showAlarm("코드를 부여할 계획이 없습니다! <br>계획을 생성한 뒤 시도하세요.",function(){})
				}
            } else {
                hideAlarm();
            }
        });
    })

    document.querySelector("#btn_add").addEventListener("click", function(){
        showAlarm("계획을 추가합니다.", function(result){
            if(result){
                console.log("클릭")
                addRow();
            } else {
                hideAlarm();
            }
        });        
    })

    document.querySelector("#btn_modify").addEventListener("click", function(){
        showAlarm("선택한 계획을 수정합니다.", function(result){
            if(result){
                document.querySelector("#btn_modify").style.cssText = "display: none;"
                document.querySelector("#btn_modify_end").style.cssText = "display: inline-block;"
            } else {
                hideAlarm();
            }
        }); 
    })
    
    document.querySelector("#btn_modify_end").addEventListener("click", function(){
        showAlarm("수정을 완료합니다.", function(result){
            if(result){
                document.querySelector("#btn_modify").style.cssText = "display: inline-block;"
                document.querySelector("#btn_modify_end").style.cssText = "display: none;"
            } else {
                hideAlarm();
            }
        });
    })

    document.querySelector("#btn_delete").addEventListener("click", function(){
        showAlarm("선택한 계획을 삭제합니다.", function(result){
            if(result){
                console.log("클릭")
            } else {
                hideAlarm();
            }
        });
    })

    document.querySelector("#btn_save").addEventListener("click", function(){
        showAlarm("계획을 저장합니다.", function(result){
            if(result){
                console.log("클릭")
            } else {
                hideAlarm();
            }
        });
    })
    
})



