package com.spring.alphaknow.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("project_login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Login.getConnection();
            String sql = "SELECT DEPARTMENT_CODE, EMPLOYEE_NAME FROM employee WHERE EMPLOYEE_KEY=? AND EMPLOYEE_PW=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userId);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(30 * 60); // 세션 유지 시간 30분 설정

                int departmentCode = rs.getInt("DEPARTMENT_CODE");
                String userName = rs.getString("EMPLOYEE_NAME");

                // userType이 "1"인 경우 "admin", 그 외는 "user"로 세션에 저장
                if ("1".equals(String.valueOf(departmentCode))) {
                    session.setAttribute("userType", "admin");
                } else {
                    session.setAttribute("userType", "user");
                }

                session.setAttribute("userName", userName);
                response.sendRedirect("mainPage.jsp");

                System.out.println("userName" + userName + "userType");
            } else {
                // 로그인 실패: 로그인 페이지로 리디렉션
                request.setAttribute("errorMessage", "아이디와 비밀번호가 일치하지 않습니다.");
                request.getRequestDispatcher("project_login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("project_login.jsp");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}