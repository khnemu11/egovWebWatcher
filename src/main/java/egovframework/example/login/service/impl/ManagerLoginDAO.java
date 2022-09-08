package egovframework.example.login.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.login.service.ManagerLoginVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("managerLoginDAO")
public class ManagerLoginDAO extends EgovAbstractDAO {
	@SuppressWarnings("unchecked")
	public List<ManagerLoginVO> selectManagerLogin(ManagerLoginVO vo) {
		return (List<ManagerLoginVO>) select("ManagerLogin.selectManagerLogin", vo);
	}
}
