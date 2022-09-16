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

import egovframework.example.file.service.FileVO;

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
public class SiteWithFileVO extends SiteVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8024452759500148006L;
	/**
	 * 
	 */
	private SiteVO siteVO;
	private FileVO fileVO;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SiteVO getSiteVO() {
		return siteVO;
	}

	public void setSiteVO(SiteVO siteVO) {
		this.siteVO = siteVO;
	}

	public FileVO getFileVO() {
		return fileVO;
	}

	public void setFileVO(FileVO fileVO) {
		this.fileVO = fileVO;
	}

	@Override
	public String toString() {
		return "SiteWithFileVO [siteVO=" + siteVO + ", fileVO=" + fileVO + ", getSiteVO()=" + getSiteVO()
				+ ", getFileVO()=" + getFileVO() + ", getUserSeq()=" + getUserSeq() + ", getUrl()=" + getUrl()
				+ ", getScenarioId()=" + getScenarioId() + ", getVersion()=" + getVersion() + ", getFile()=" + getFile()
				+ ", getFileSeq()=" + getFileSeq() + ", getSeq()=" + getSeq() + ", getCdate()=" + getCdate()
				+ ", getCtime()=" + getCtime() + ", getUdate()=" + getUdate() + ", getUtime()=" + getUtime()
				+ ", getDdate()=" + getDdate() + ", getDtime()=" + getDtime() + ", toString()=" + super.toString()
				+ ", getFirstIndex()=" + getFirstIndex() + ", getLastIndex()=" + getLastIndex()
				+ ", getRecordCountPerPage()=" + getRecordCountPerPage() + ", getSearchCondition()="
				+ getSearchCondition() + ", getSearchKeyword()=" + getSearchKeyword() + ", getSearchUseYn()="
				+ getSearchUseYn() + ", getPageIndex()=" + getPageIndex() + ", getPageUnit()=" + getPageUnit()
				+ ", getPageSize()=" + getPageSize() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
