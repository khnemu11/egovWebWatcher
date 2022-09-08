package egovframework.example.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.cmmn.CommonServiceImpl;
import egovframework.example.login.service.LoginService;
import egovframework.example.login.service.LoginVO;

@Service("loginService")
public class LoginServiceImpl extends CommonServiceImpl implements LoginService {
	@Autowired
	LoginDAO dao;

	@Override
	public Long selectLoginSeq(LoginVO vo) throws Exception {
		return dao.selectLoginSeq(vo);
	}

	@Override
	public List<LoginVO> selectLogin(LoginVO vo) throws Exception {
		return dao.selectLogin(vo);
	}

	@Override
	public Long selectLoginCheck(LoginVO vo) throws Exception {
		return dao.selectLoginCheck(vo);
	}

	@Override
	public int updateLoginFail(LoginVO vo) throws Exception {
		return dao.updateLoginFail(vo);
	}
	
	
}
