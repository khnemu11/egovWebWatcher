package egovframework.example.login.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.cmmn.CommonServiceImpl;
import egovframework.example.login.service.LoginService;
import egovframework.example.login.service.LoginVO;

@Service("loginService")
public class LoginServiceImpl extends CommonServiceImpl implements LoginService {
	@Resource(name = "loginMapper")
	private LoginMapper loginDAO;

	@Override
	public long selectLoginSeq(LoginVO vo) throws Exception {
		return loginDAO.selectLoginSeq(vo);
	}

	@Override
	public List<LoginVO> selectLogin(LoginVO vo) throws Exception {
		return loginDAO.selectLogin(vo);
	}

	@Override
	public long selectLoginCheck(LoginVO vo) throws Exception {
		return loginDAO.selectLoginCheck(vo);
	}

	@Override
	public int updateLoginFail(LoginVO vo) throws Exception {
		setUpdate(vo);
		return loginDAO.updateLoginFail(vo);
	}


}
