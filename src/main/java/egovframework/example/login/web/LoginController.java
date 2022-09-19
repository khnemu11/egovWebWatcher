package egovframework.example.login.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.login.service.LoginService;
import egovframework.example.login.service.LoginVO;
import egovframework.example.login.service.ManagerLoginService;
import egovframework.example.user.service.UserVO;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class LoginController {
	@Resource(name = "loginService")
	LoginService loginService;
	
	@Resource(name = "managerLoginService")
	ManagerLoginService managerLoginService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	
	@RequestMapping(value = "login.do")
	public String login(Model m) {
		
		
		
		return "login/login";
	}
	
	@RequestMapping(value = "loginOk.do")
	public String loginOk(LoginVO vo, HttpSession session) throws Exception {
		String returnUrl = "";
		
		if(session.getAttribute("name") != null) {
			session.removeAttribute("name");
		}
		
//		Map<String, Object> beforeInfo = new HashMap<String, Object>();
//		beforeInfo.put("loginId", loginId);
//		beforeInfo.put("password", password);
//		
//		Map<String, Object> info = new HashMap<String, Object>();
//		info.put("info", beforeInfo);
		
		
		UserVO user = (UserVO) loginService.selectLogin(vo);

		if(user != null) {
			if(user.getName().equals(vo.getLoginId()) && user.getPassword().equals(vo.getPassword())) {
				session.setAttribute("loginId", vo.getLoginId());
			}
			returnUrl = "redirect:/";
		}else {
			returnUrl = "logfail";
		}
		
		return returnUrl;
	}
	
	
	
	@RequestMapping(value = "/managerlogin.do")
	public String managerLogin(Model m) {
		
		return "login/managerlogin";
	}
}
