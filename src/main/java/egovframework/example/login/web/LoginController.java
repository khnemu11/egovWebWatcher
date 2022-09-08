package egovframework.example.login.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.login.service.LoginService;
import egovframework.example.login.service.ManagerLoginService;

@Controller
public class LoginController {
	@Resource(name = "loginService")
	LoginService loginService;
	
	@Resource(name = "managerLoginService")
	ManagerLoginService managerLoginService;
	
	
	@RequestMapping(value = "login.do")
	public String login(Model m) {
		
		return "login/login";
	}
	
	
	@RequestMapping(value = "/managerlogin.do")
	public String managerLogin(Model m) {
		
		return "login/managerlogin";
	}
}
