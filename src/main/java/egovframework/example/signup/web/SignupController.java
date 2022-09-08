package egovframework.example.signup.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.signup.service.SignupService;

@Controller
public class SignupController {
	@Resource(name = "signupService")
	SignupService signupService;
	
	@RequestMapping("/signup.do")
	public String signup(Model m) {
		
		
		return "signup/signupInput";
	}
}
