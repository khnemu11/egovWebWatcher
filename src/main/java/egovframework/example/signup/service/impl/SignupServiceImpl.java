package egovframework.example.signup.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.cmmn.CommonServiceImpl;
import egovframework.example.signup.service.SignupService;
import egovframework.example.signup.service.SignupVO;
import egovframework.example.user.service.UserVO;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

@Service("signupService")
public class SignupServiceImpl extends CommonServiceImpl implements SignupService{
	@Resource(name = "signupMapper")
	private SignupMapper signupDAO;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	@Override
	public int insertTuser(UserVO vo) throws Exception {
		return signupDAO.insertTuser(vo);
	}

	@Override
	public int insertTarclogin(UserVO vo) throws Exception {
		return signupDAO.insertTarclogin(vo);
	}

	@Override
	public Long selectSignupEmail(SignupVO vo) throws Exception {
		return signupDAO.selectSignupEmail(vo);
	}

	@Override
	public Long selectUserEmail(SignupVO vo) throws Exception {
		return signupDAO.selectUserEmail(vo);

	}

	@Override
	public Long selectUserLoginId(SignupVO vo) throws Exception {
		return signupDAO.selectUserLoginId(vo);

	}

	@Override
	public Long selectUserSeq(SignupVO vo) throws Exception {
		return signupDAO.selectUserSeq(vo);

	}



}
