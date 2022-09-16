/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.file.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.example.cmmn.CommonServiceImpl;
import egovframework.example.file.service.FileService;
import egovframework.example.file.service.FileVO;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @
 *   2009.03.16 최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *      Copyright (C) by MOPAS All right reserved.
 */

@Service("fileService")
public class FileServiceImpl extends CommonServiceImpl implements FileService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);


	@Resource(name = "fileMapper")
	private FileMapper fileDAO;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	@Override
	public void insertFile(FileVO vo) throws Exception {
		setInsert(vo);
		fileDAO.insertFile(vo);
	}
	@Override
	public void updateFile(FileVO vo) throws Exception {
		// TODO Auto-generated method stub
		setUpdate(vo);
		fileDAO.updateFile(vo);
	}

	@Override
	public void deleteFile(FileVO vo) throws Exception {
		// TODO Auto-generated method stub
		setDelete(vo);
		fileDAO.deleteFile(vo);
	}

	@Override
	public FileVO selectFile(FileVO vo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<FileVO> selectFileList(FileVO vo) throws Exception {
		// TODO Auto-generated method stub
		return fileDAO.selectFileList(vo);
	}

}
