/*
site.url * Copyright 2008-2009 the original author or authors.
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
package egovframework.example.file.service;

import java.io.Serializable;

import egovframework.example.cmmn.CommonVO;
import egovframework.example.site.service.SiteVO;

/**
 * @Class Name : SampleDefaultVO.java
 * @Description : SampleDefaultVO Class
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
public class FileVO extends CommonVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String url;
	private int userSeq;
	
	public FileVO() {
		
	}
	
	public FileVO(SiteVO searchVO) {
		this.setPageUnit(searchVO.getPageUnit());  
		this.setPageSize(searchVO.getPageSize());
		this.setFirstIndex(searchVO.getFirstIndex());
		this.setLastIndex(searchVO.getLastIndex());
		this.setRecordCountPerPage(searchVO.getRecordCountPerPage());
		this.setUserSeq(searchVO.getUserSeq());
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "FileVO [name=" + name + ", url=" + url + "]";
	}
}
