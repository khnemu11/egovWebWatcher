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
package egovframework.example.site.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.core.tools.picocli.CommandLine.Parameters;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.file.service.FileService;
import egovframework.example.file.service.FileVO;
import egovframework.example.site.service.EgovSiteService;
import egovframework.example.site.service.SiteVO;
import egovframework.example.site.service.SiteWithFileVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
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

@Controller
public class EgovSiteController {

	private static final Log log = LogFactory.getLog(EgovSiteController.class);
	/** EgovSampleService */
	@Resource(name = "siteService")
	private EgovSiteService siteService;
	@Resource(name = "fileService")
	private FileService fileService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * 글 목록을 조회한다. (pageing)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 SampleDefaultVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
//	@RequestMapping(value = "/egovSiteList.do")
//	public String selectSiteList(@ModelAttribute("searchVO") SiteVO searchVO, ModelMap model,
//			HttpServletRequest request) throws Exception {
//
//		/** EgovPropertyService.sample */
//		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
//		searchVO.setPageSize(propertiesService.getInt("pageSize"));
//
//		/** pageing setting */
//		PaginationInfo paginationInfo = new PaginationInfo();
//		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
//		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
//		paginationInfo.setPageSize(searchVO.getPageSize());
//
//		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
//		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
//		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
//
//		FileVO fileSearchVO = new FileVO(searchVO);
//
//		List<?> siteList = siteService.selectSiteList(searchVO);
//		List<?> fileList = fileService.selectFileList(fileSearchVO);
//
//		model.addAttribute("resultList", siteList);
//		model.addAttribute("fileList", fileList);
//
//		int totCnt = siteService.selectSiteListTotCnt(searchVO);
//		paginationInfo.setTotalRecordCount(totCnt);
//		model.addAttribute("paginationInfo", paginationInfo);
//
//		return "site/egovSiteList";
//	}

	@RequestMapping(value = "/egovSiteList/{userSeq}.do")
	public String selectSiteListBySeq(@PathVariable int userSeq, @ModelAttribute("searchVO") SiteWithFileVO searchVO,
			ModelMap model) throws Exception {
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));
		// searchVO.setSearchKeyword(String.valueOf(userSeq));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		searchVO.setUserSeq(userSeq);
		System.out.println(searchVO.toString());

		List<?> siteWithFile = siteService.selectSiteWithFileList(searchVO);
		System.out.println(siteWithFile.toString());
		model.addAttribute("resultList", siteWithFile);
		model.addAttribute("userSeq", userSeq);
		int totCnt = siteService.selectSiteListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "site/egovSiteList";
	}

	/**
	 * 글 등록 화면을 조회한다.
	 * 
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "egovSampleRegister"
	 * @exception Exception
	 */
//	@RequestMapping(value = "/reAddSiteForm.do", method = RequestMethod.GET)
//	public String reAddSiteView(Model model, HttpServletRequest request) throws Exception {
//		try {
//			log.info("re add form start");
//			Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
//			if (map != null) {
//				SiteVO vo = (SiteVO) map.get("siteVO");
//				log.info(vo.getFile().getOriginalFilename());
//				model.addAttribute("siteVO", vo);
//			}
//		} catch (Exception e) {
//			log.info(e.getStackTrace());
//		}
//
//		return "site/egovSiteRegister";
//	}

	@RequestMapping(value = "/addSiteForm/{userSeq}.do", method = RequestMethod.GET)
	public String addSiteView(@PathVariable int userSeq, @ModelAttribute("siteVO") SiteVO vo, Model model)
			throws Exception {
		try {
			log.info("add form start");
			model.addAttribute("siteVO", vo);
			model.addAttribute("userSeq", userSeq);
		} catch (Exception e) {
			log.info(e.getStackTrace());
		}

		return "site/egovSiteRegister";
	}

	@RequestMapping(value = "/updateSiteForm/{userSeq}.do", method = RequestMethod.GET)
	public String updateSiteView(@PathVariable int userSeq, @RequestParam(value = "siteSeq") int siteSeq,
			@ModelAttribute("siteVO") SiteVO vo, Model model) throws Exception {
		try {
			log.info("update form start");
			log.info(siteSeq);
			SiteWithFileVO searchVO = new SiteWithFileVO();
			searchVO.setSiteseq(siteSeq);
			
			SiteWithFileVO siteWithFileVO = siteService.selectSite(searchVO);
			SiteVO siteVO = new SiteVO(siteWithFileVO);
			log.info("site vo : "+siteVO.toString());
			model.addAttribute("siteVO", siteVO);
			model.addAttribute("userSeq", userSeq);
			model.addAttribute("fileName", siteWithFileVO.getFileName());

		} catch (Exception e) {
			log.info(e.getStackTrace());
		}

		return "site/egovSiteRegister";
	}
	@RequestMapping(value = "/updateSite/{userSeq}.do", method = RequestMethod.POST)
	public String updateSite(@PathVariable int userSeq, @RequestParam(value = "siteSeq") int siteSeq, @ModelAttribute("siteVO") SiteVO vo, BindingResult bindingResult,
			Model model, SessionStatus status, HttpServletRequest request) throws Exception {
		log.info("input siteVo : "+vo.toString());;
		beanValidator.validate(vo, bindingResult);
		
		
		if (bindingResult.hasErrors()) {
			log.info(bindingResult.toString());
			log.info("ready for redirect edit form");
			log.info("name : " + vo.getFile().getOriginalFilename());

			SiteWithFileVO searchVO = new SiteWithFileVO();
			searchVO.setSiteseq(siteSeq);
			SiteWithFileVO siteWithFileVO = siteService.selectSite(searchVO);
			vo.setSeq(siteWithFileVO.getSiteseq());
			model.addAttribute("siteVO", vo);
			model.addAttribute("userSeq",userSeq);
			model.addAttribute("fileName",siteWithFileVO.getFileName());
			
			return "site/egovSiteRegister";
		}
		
		vo.setUserSeq(userSeq);
		vo.setSeq(siteSeq);
		
		String path = "./scenario";
		String absolutePath = request.getServletContext().getRealPath(path);
		Path paths = Paths.get(absolutePath);
		File directory = new File(absolutePath);

		log.info("directory is exist" + Files.exists(paths));

		if (!Files.exists(paths)) {
			directory.mkdir();
			log.info("make folder");
		}

		if (vo.getFile() != null) {
			log.info(absolutePath);

			FileVO searchVO = new FileVO();
			searchVO.setName(vo.getFile().getOriginalFilename());

			File file = new File(absolutePath, vo.getFile().getOriginalFilename());

			if (file.exists()) {
				log.info("file is exist");
				file.delete();
			}

			vo.getFile().transferTo(new File(absolutePath, vo.getFile().getOriginalFilename()));
			
			SiteWithFileVO searchSiteWithFileVO = new SiteWithFileVO();
			searchSiteWithFileVO.setSiteseq(siteSeq);
			SiteWithFileVO siteWithFileVO = siteService.selectSite(searchSiteWithFileVO);
			
			FileVO fileVO = new FileVO();
			fileVO.setName(vo.getFile().getOriginalFilename());
			fileVO.setUrl(absolutePath + "\\" + fileVO.getName());
			fileVO.setSeq(siteWithFileVO.getFileSeq());
			fileService.updateFile(fileVO);

			int fileSeq = fileService.selectFileByName(fileVO).getSeq();
			vo.setFileSeq(fileSeq);
			siteService.updateSite(vo);
		}

		return "redirect:../egovSiteList/" + userSeq + ".do";
	}
	/**
	 * 글을 등록한다.
	 * 
	 * @param sampleVO - 등록할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addSite/{userSeq}.do", method = RequestMethod.POST)
	public String addSite(@PathVariable int userSeq, @ModelAttribute("siteVO") SiteVO vo, BindingResult bindingResult,
			Model model, SessionStatus status, HttpServletRequest request) throws Exception {
		beanValidator.validate(vo, bindingResult);

		if (bindingResult.hasErrors()) {
			log.info(bindingResult.toString());
			log.info("ready for redirect add form");
			log.info("name : " + vo.getFile().getOriginalFilename());
			model.addAttribute("siteVO", vo);
			return "site/egovSiteRegister";
		}
		vo.setUserSeq(userSeq);
		String path = "./scenario";
		String absolutePath = request.getServletContext().getRealPath(path);
		Path paths = Paths.get(absolutePath);
		File directory = new File(absolutePath);

		System.out.println("directory is exist" + Files.exists(paths));

		if (!Files.exists(paths)) {
			directory.mkdir();
			System.out.println("make folder");
		}

		if (vo.getFile() != null) {
			System.out.println(absolutePath);

			FileVO searchVO = new FileVO();
			searchVO.setName(vo.getFile().getOriginalFilename());

			File file = new File(absolutePath, vo.getFile().getOriginalFilename());

			System.out.println();

			if (file.exists()) {
				System.out.println("file is exist");
				file.delete();
			}

			vo.getFile().transferTo(new File(absolutePath, vo.getFile().getOriginalFilename()));

			FileVO fileVO = new FileVO();
			fileVO.setName(vo.getFile().getOriginalFilename());
			fileVO.setUrl(absolutePath + "\\" + fileVO.getName());
			fileService.insertFile(fileVO);

			int fileSeq = fileService.selectFileByName(fileVO).getSeq();
			vo.setFileSeq(fileSeq);
			siteService.insertSite(vo);
		}

		return "redirect:../egovSiteList/" + userSeq + ".do";
	}

	/**
	 * 글 수정화면을 조회한다.
	 * 
	 * @param id       - 수정할 글 id
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "egovSampleRegister"
	 * @exception Exception
	 */
//	@RequestMapping("/updateSampleView.do")
//	public String updateSampleView(@RequestParam("selectedId") String id, @ModelAttribute("searchVO") SampleDefaultVO searchVO, Model model) throws Exception {
//		SampleVO sampleVO = new SampleVO();
//		sampleVO.setId(id);
//		// 변수명은 CoC 에 따라 sampleVO
//		model.addAttribute(selectSample(sampleVO, searchVO));
//		return "sample/egovSampleRegister";
//	}

	/**
	 * 글을 조회한다.
	 * 
	 * @param sampleVO - 조회할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return @ModelAttribute("sampleVO") - 조회한 정보
	 * @exception Exception
	 */
//	public SampleVO selectSample(SampleVO sampleVO, @ModelAttribute("searchVO") SampleDefaultVO searchVO) throws Exception {
//		return sampleService.selectSample(sampleVO);
//	}

//	/**
//	 * 글을 수정한다.
//	 * @param sampleVO - 수정할 정보가 담긴 VO
//	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
//	 * @param status
//	 * @return "forward:/egovSampleList.do"
//	 * @exception Exception
//	 */
//	@RequestMapping("/updateSample.do")
//	public String updateSample(@ModelAttribute("searchVO") SampleDefaultVO searchVO, SampleVO sampleVO, BindingResult bindingResult, Model model, SessionStatus status)
//			throws Exception {
//
//		beanValidator.validate(sampleVO, bindingResult);
//
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("sampleVO", sampleVO);
//			return "sample/egovSampleRegister";
//		}
//
//		sampleService.updateSample(sampleVO);
//		status.setComplete();
//		return "forward:/egovSampleList.do";
//	}
//
//	/**
//	 * 글을 삭제한다.
//	 * @param sampleVO - 삭제할 정보가 담긴 VO
//	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
//	 * @param status
//	 * @return "forward:/egovSampleList.do"
//	 * @exception Exception
//	 */
	@RequestMapping("/deleteSite/{seq}.do")
	public String deleteSite(@PathVariable int seq, @ModelAttribute("searchVO") SiteWithFileVO vo, SessionStatus status)
			throws Exception {
		vo.setSiteseq(seq);
		SiteWithFileVO target = siteService.selectSite(vo);
		log.info(target.toString());
		siteService.deleteSite(target);
		FileVO fileVO = new FileVO();
		fileVO.setSeq(target.getFileSeq());
		fileService.deleteFile(fileVO);

		return "redirect:/egovSiteList/" + target.getUserSeq() + ".do";
	}

	@RequestMapping(value = "/attach/{seq}.do", method = RequestMethod.GET)
	public String downloadAttach(@PathVariable int seq, HttpServletResponse response) throws Exception {
		System.out.println("download is start");

		FileVO searchVO = new FileVO();
		searchVO.setSeq(seq);

		FileVO file = fileService.selectFile(searchVO);
		// String encodedName = new String(file.getName().getBytes("UTF-8"),
		// "iso-8859-1");

		File down = new File(file.getUrl(), "");
		log.info("filename : " + file.getName());
		log.info(down.toString());
		log.info(down.exists());

		response.setContentType("application/octet-stream");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"");

		BufferedInputStream in = new BufferedInputStream(new FileInputStream(down));
		FileCopyUtils.copy(in, response.getOutputStream());
		in.close();
		response.getOutputStream().flush();
		response.getOutputStream().close();

		return "redirect:../egovSiteList/1.do";
	}
}
