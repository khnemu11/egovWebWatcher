package egovframework.example.signup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.cmmn.CommonServiceImpl;
import egovframework.example.signup.service.SignupService;
import egovframework.example.signup.service.SignupVO;

@Service("signupService")
public class SignupServiceImpl extends CommonServiceImpl implements SignupService{
	@Autowired
	SignupDAO dao;

	@Override
	public int insertTuser(SignupVO vo) throws Exception {
		return dao.insertTuser(vo);
	}

	@Override
	public int insertTarclogin(SignupVO vo) throws Exception {
		return dao.insertTarclogin(vo);
	}

	@Override
	public Long selectSignupEmail(SignupVO vo) throws Exception {
		return dao.selectSignupEmail(vo);
	}

	@Override
	public Long selectUserEmail(SignupVO vo) throws Exception {
		return dao.selectUserEmail(vo);
	}

	@Override
	public Long selectUserLoginId(SignupVO vo) throws Exception {
		return dao.selectUserLoginId(vo);
	}

	@Override
	public Long selectUserSeq(SignupVO vo) throws Exception {
		return dao.selectUserSeq(vo);
	}

}
