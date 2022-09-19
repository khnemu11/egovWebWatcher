package egovframework.example.login.service.impl;

import java.util.List;

import egovframework.example.login.service.ManagerLoginVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("managerLoginMapper")
public interface ManagerLoginMapper {
	List<ManagerLoginVO> selectManagerLogin(ManagerLoginVO vo) throws Exception;
}
