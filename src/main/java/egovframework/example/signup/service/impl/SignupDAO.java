package egovframework.example.signup.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.example.signup.service.SignupVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("signupDAO")
public class SignupDAO extends EgovAbstractDAO {
	
	public int insertTuser (SignupVO vo) throws Exception {
		int result = (int) insert("Signup.insertTuser", vo);
		return result;
	}
	
	public int insertTarclogin (SignupVO vo) throws Exception {
		int result = (int) insert("Signup.insertTarclogin", vo);
		return result;
	}
	
	public Long selectSignupEmail (SignupVO vo) throws Exception{
		Long result = (Long) select("Signup.selectSignupEmail", vo);
		return result;
	}
	
	public Long selectUserEmail (SignupVO vo) throws Exception{
		Long result = (Long) select("Signup.selectUserEmail", vo);
		return result;
	}
	
	public Long selectUserLoginId (SignupVO vo) throws Exception{
		Long result = (Long) select("Signup.selectUserLoginId", vo);
		return result;
	}
	
	public Long selectUserSeq (SignupVO vo) throws Exception{
		Long result = (Long) select("Signup.selectUserSeq", vo);
		return result;
	}
	
}
