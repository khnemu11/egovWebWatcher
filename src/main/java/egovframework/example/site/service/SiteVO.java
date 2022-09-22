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
package egovframework.example.site.service;

import org.springframework.web.multipart.MultipartFile;

import egovframework.example.cmmn.CommonVO;

/**
 * @Class Name : SampleVO.java
 * @Description : SampleVO Class
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
public class SiteVO extends CommonVO {

	private static final long serialVersionUID = 1L;
	private int userSeq;
	private String url;
	private int scenarioId;
	private int version;
	private MultipartFile file;
	private int fileSeq;
	
	public SiteVO(){}

	public SiteVO(SiteWithFileVO vo){
		super.setSeq(vo.getSiteseq());
		this.userSeq = vo.getUserSeq();
		this.url = vo.getSiteUrl();
		this.version = vo.getVersion();
		this.fileSeq = vo.getFileSeq();
	}
	
	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getScenarioId() {
		return scenarioId;
	}

	public void setScenarioId(int scenarioId) {
		this.scenarioId = scenarioId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getFileSeq() {
		return fileSeq;
	}

	public void setFileSeq(int fileSeq) {
		this.fileSeq = fileSeq;
	}

	@Override
	public String toString() {
		return "SiteVO [userSeq=" + userSeq + ", url=" + url + ", scenarioId=" + scenarioId + ", version=" + version
				+ ", file=" + file + ", fileSeq=" + fileSeq + "]";
	}

}
