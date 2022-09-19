package egovframework.example.signup.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.signup.service.SignupService;
import egovframework.example.user.service.UserVO;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class SignupController {
	@Resource(name = "signupService")
	SignupService signupService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	
	@RequestMapping("/signup.do")
	public String signupInput(Model m) {
		
		
		return "signup/signupInputForUser";
	}
	
	
	@RequestMapping(value = "/signupOk.do", method=RequestMethod.POST)
	public String registerOk(UserVO user) throws Exception {
		String returnUrl = "";
		int i = signupService.insertTuser(user);
		int j = signupService.insertTarclogin(user);
		if(i > 0 && j > 0) {
			return "redirect:/login.do";
		}else {
			returnUrl = "signupfail";
		}
		return returnUrl;
	}
}
