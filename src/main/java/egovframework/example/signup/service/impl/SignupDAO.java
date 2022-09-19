package egovframework.example.signup.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.example.signup.service.SignupVO;
import egovframework.example.user.service.UserVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("signupDAO")
public class SignupDAO extends EgovAbstractDAO {
	
	public int insertTuser (UserVO vo) throws Exception {
		int result = (int) insert("signupDAO.insertTuser", vo);
		return result;
	}
	
	public int insertTarclogin (UserVO vo) throws Exception {
		int result = (int) insert("signupDAO.insertTarclogin", vo);
		return result;
	}
	
	public Long selectSignupEmail (SignupVO vo) throws Exception{
		Long result = (Long) select("signupDAO.selectSignupEmail", vo);
		return result;
	}
	
	public Long selectUserEmail (SignupVO vo) throws Exception{
		Long result = (Long) select("signupDAO.selectUserEmail", vo);
		return result;
	}
	
	public Long selectUserLoginId (SignupVO vo) throws Exception{
		Long result = (Long) select("signupDAO.selectUserLoginId", vo);
		return result;
	}
	
	public Long selectUserSeq (SignupVO vo) throws Exception{
		Long result = (Long) select("signupDAO.selectUserSeq", vo);
		return result;
	}
	
}
