package com.spring.test01;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/test01")
public class LoginController {

	private Authenticator authenticator;

    @Autowired
    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        
        List<String> userTypeList = Arrays.asList("Admin", "User");
        model.addAttribute("userType", userTypeList);
        
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLoginForm(@ModelAttribute("loginDTO") LoginDTO loginDTO, Model model) {
        try {
            authenticator.authen(loginDTO.getUserId(), loginDTO.getUserPw());

            String message = "id : " + loginDTO.getUserId() +
                             ", pw : " + loginDTO.getUserPw() +
                             ", type : " + loginDTO.getUserType();

            model.addAttribute("message", message);
            System.out.println("message : " + message);

            return "login_ok";
        } catch (UserException e) {
            model.addAttribute("error", "로그인 실패: " + e.getMessage());
            return "login";
        }
    }
}
