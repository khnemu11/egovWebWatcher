package egovframework.example.login.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.cmmn.CommonServiceImpl;
import egovframework.example.login.service.ManagerLoginService;
import egovframework.example.login.service.ManagerLoginVO;

@Service("managerLoginService")
public class ManagerLoginServiceImpl extends CommonServiceImpl implements ManagerLoginService{
	@Resource(name = "managerLoginMapper")
	ManagerLoginMapper managerLoginDAO;

	@Override
	public List<ManagerLoginVO> selectManagerLogin(ManagerLoginVO vo) throws Exception {
		return managerLoginDAO.selectManagerLogin(vo);
	}	
}
