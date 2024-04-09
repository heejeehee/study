package ajaxData;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signUpForm.UserDAO;

@WebServlet("/nicknameChk")
public class nicknameAjaxServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); response.setContentType("text/html; charset=utf-8;");
		
		System.out.println("doPost 실행");
		
		// 요청 데이터 받기
        String userNickname = request.getParameter("userNickname");
        System.out.println("받은 데이터 : " + userNickname);
        String responseData = "-1";	// 응답 실패

        // 받은 닉네임과 기존 닉네임 비교
        UserDAO userDAO = new UserDAO();
        List nicknames = userDAO.nicknameChk();
        for(int i=0; i<nicknames.size(); i++) {
        	System.out.println("닉네임 체크 : " + userNickname +"\t비교 대상 : " + nicknames.get(i));
        	if(nicknames.get(i).equals(userNickname)) {	// 만약 중복된다면
        		responseData = "0";	// 중복 사용불가
        		return;
        	} else {
        		responseData = "1";	// 사용가능
        	}
        }
        
        

        // 클라이언트에 응답 전송
        response.setContentType("text/plain"); // 응답형식 : 텍스트
        response.getWriter().write(responseData);
		
	}

}
