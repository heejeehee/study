// 실행문
makeTable(1, "#plan_table_thead", 1, 10, "#plan_table_tbody", 20);
makeColName(1);
checkEvent(1);

// 테이블 생성
function makeTable(tableNum, theadId, x1, y, tbodyId, x2) {
    let thead = document.querySelector(theadId);

    for (let i = 1; i <= x1; i++) {
        let tr = document.createElement('tr');
        thead.appendChild(tr);
        for (let j = 1; j <= y; j++) {
            let th = document.createElement('th');
            tr.appendChild(th);
            th.setAttribute("id", `thead${tableNum}_${i}_${j}`);
        }
    }

    let tbody = document.querySelector(tbodyId)

    for (let i = 1; i <= x2; i++) {
        let tr = document.createElement('tr');
        tbody.appendChild(tr);
        for (let j = 1; j <= y; j++) {
            let td = document.createElement('td');
            tr.appendChild(td);
            td.setAttribute("id", `tbody${tableNum}_${i}_${j}`);
        }
    }

    // 체크박스 생성
    for (let i = 1; i <= x2; i++) {
        let checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.classList.add("table1_chkChild");

        document.querySelector("#tbody1_" + i + "_1").appendChild(checkbox);
        // 체크박스 중앙정렬
        document.querySelector("#tbody1_" + i + "_1").style.cssText = "text-align: center";
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