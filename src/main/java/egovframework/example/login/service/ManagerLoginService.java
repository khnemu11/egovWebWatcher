package egovframework.example.login.service;

import java.util.List;

public interface ManagerLoginService {
	public List<ManagerLoginVO> selectManagerLogin(ManagerLoginVO vo) throws Exception;
}
