<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>생산지시관리</title>
    </head>

    <body>
        <%@ include file="../mainheader.jsp" %>
            <!-- content -->
            <div id="content">

                <!-- div id="headerj" 시작 -->
                <div id="headerj">
                    생산지시관리
                </div>
                <!-- div id="headerj" 끝 -->

                <!-- updiv -->
                <div class="updiv">
                    <!-- order_menu -->
                    <div id="order_menu">

                    </div>
                    <!-- order_menu 끝 -->

                </div>
                <!-- updiv 끝 -->

                <!-- downdiv -->
                <div class="downdiv">

                    <!-- header1 div -->
                    <div id="header1_div">
                        <!-- 버튼 div -->
                        <div id="btn_wrap_div">

                            <button type="button" id="btn_add">추가</button>
                            <button type="button" id="btn_modify">수정</button>
                            <button type="button" id="btn_delete">삭제</button>
                            <button type="button" id="btn_save">저장</button>
                        </div>
                    </div>
                    <!-- header1 div 끝 -->

                    <div id="order_table_div">
                        <table id="order_table">
                            <thead id="order_table_thead">

                            </thead>
                            <tbody id="order_table_tbody">

                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- downdiv 끝 -->

            </div>
            <!-- content 끝 -->

            <script>


            </script>


    </body>

    <link rel="stylesheet" href="../css/production_order_management.css">
    <script src="../js/production_order_management.js"></script>

    </html>