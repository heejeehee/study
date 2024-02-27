<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>생산계획관리</title>
    </head>

    <body>
        <%@ include file="../mainheader.jsp" %>
            <!-- content -->
            <div id="content">

                <!-- div id="headerj" 시작 -->
                <div id="headerj">
                    생산계획관리
                </div>
                <!-- div id="headerj" 끝 -->

                <!-- updiv -->
                <div class="updiv">

                    <!-- header1 div -->
                    <div id="header1_div">
                        <!-- 버튼 div -->
                        <div id="btn_wrap_div">
                            <button type="button" id="btn_auto">계획자동생성</button>
                            <button type="button" id="btn_plancode">계획코드부여</button>
                            <button type="button" id="btn_add">추가</button>
                            <button type="button" id="btn_modify">수정</button>
                            <button type="button" id="btn_delete">삭제</button>
                            <button type="button" id="btn_save">저장</button>
                        </div>
                    </div>
                    <!-- header1 div 끝 -->

                    <div id="plan_table_div">
                        <table id="plan_table">
                            <thead id="plan_table_thead">

                            </thead>
                            <tbody id="plan_table_tbody">

                            </tbody>
                        </table>
                    </div>


                </div>
                <!-- updiv 끝 -->

            </div>
            <!-- content 끝 -->
    </body>

    <link rel="stylesheet" href="../css/production_plan_management.css">
    <script src="../js/production_plan_management.js"></script>

    </html>