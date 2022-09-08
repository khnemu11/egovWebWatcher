package egovframework.example.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.cmmn.CommonServiceImpl;
import egovframework.example.login.service.ManagerLoginService;
import egovframework.example.login.service.ManagerLoginVO;

@Service("managerLoginService")
public class ManagerLoginServiceImpl extends CommonServiceImpl implements ManagerLoginService{
	@Autowired
	ManagerLoginDAO dao;
	
	@Override
	public List<ManagerLoginVO> selectManagerLogin(ManagerLoginVO vo) throws Exception {
		
		return dao.selectManagerLogin(vo);
	}

}
