package egovframework.example.login.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.login.service.LoginVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("loginDAO")
public class LoginDAO extends EgovAbstractDAO {
	public Long selectLoginSeq(LoginVO vo) {
		return (Long) select("Login.selectLoginSeq", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<LoginVO> selectLogin(LoginVO vo) {
		return (List<LoginVO>) select("Login.selectLogin", vo);
	}
	
	public Long selectLoginCheck(LoginVO vo) {
		return (Long) select("Login.selectLoginCheck", vo);
	}
	
	public int updateLoginFail(LoginVO vo) {
		return (int) update("Login.updateLoginFail", vo);
	}
}
