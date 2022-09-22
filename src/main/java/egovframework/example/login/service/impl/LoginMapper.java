package egovframework.example.login.service.impl;

import java.util.List;

import egovframework.example.login.service.LoginVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("loginMapper")
public interface LoginMapper {
	int selectLoginSeq(LoginVO vo) throws Exception;
	
	List<LoginVO> selectLogin(LoginVO vo) throws Exception;
	
	long selectLoginCheck(LoginVO vo) throws Exception;
		
	int updateLoginFail(LoginVO vo) throws Exception;
}
