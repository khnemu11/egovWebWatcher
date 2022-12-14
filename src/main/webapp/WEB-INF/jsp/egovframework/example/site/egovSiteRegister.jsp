<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator"
	uri="http://www.springmodules.org/tags/commons-validator"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	/**
* @Class Name : egovSampleRegister.jsp
* @Description : Sample Register 화면
* @Modification Information
*
*   수정일         수정자                   수정내용
*  -------    --------    ---------------------------
*  2009.02.01            최초 생성
*
* author 실행환경 개발팀
* since 2009.02.01
*
* Copyright (C) 2009 by MOPAS  All right reserved.
*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:set var="registerFlag" value="${siteVO.seq==0 ? 'create' : 'modify'}" />
<c:set var="userSeq" value="${userSeq}" />
<title>Sample <c:if test="${registerFlag == 'create'}">
		<spring:message code="button.create" />
	</c:if> <c:if test="${registerFlag == 'modify'}">
		<spring:message code="button.modify" />
	</c:if>
</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/sample.css'/>" />
<!--For Commons Validator Client Side-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script>
<validator:javascript formName="siteVO" staticJavascript="false"
	xhtml="true" cdata="false" />

<script type="text/javaScript" language="javascript" defer="defer">
        /* 글 목록 화면 function */
        $(document).ready(function(){
        		var text = '${error == 'error' ? "error" :"none"}';
        		console.log(text);
        		if(text == "error"){
        			alert("중복된 파일 이름이 존재합니다.");
        		}
        });
        	
       
        document.addEventListener('keydown', function(event) {
			if (event.keyCode === 13) {
			event.preventDefault();
			};
		}, true); //form 내용 발송 시 엔터키를 누르면 화면이 다시 리로드 되는 것을 막아 엔터로 form을 발송하는 것을 막는 키
        
        function fn_egov_selectList() {
           	document.detailForm.action = "<c:url value='/egovSiteList.do'/>";
           	document.detailForm.submit();
        }
        
        /* 글 삭제 function */
        function fn_egov_delete() {
           	document.detailForm.action = "<c:url value='/deleteSite.do'/>";
           	document.detailForm.submit();
        }
        
        /* 글 등록 function */
        function fn_egov_save() {
        	frm = document.detailForm;
        	if(!validateSiteVO(frm)){
                return;
            } else {
            	var action = '/addSite/';
            	console.log(action);
            	var url = ".."
            	url = url + action;
            	url = url + ${userSeq};
            	url=url+".do"
            	
            	frm.action = url;
            	frm.method = "POST";
                frm.submit();
            }
        }
        
        function fn_egov_edit(siteSeq) {
        	frm = document.detailForm;
        	if(!validateSiteVO(frm)){
                return;
            }else{
            	var action = '/updateSite/';
            	console.log(action);
            	var url = ".."
            	url = url + action;
            	url = url + ${userSeq};
            	url=url+".do"
            	url=url+"?siteSeq=";
            	url=url+siteSeq;
            	frm.action = url;
            	frm.method = "POST";
                frm.submit();
            }
        }
    </script>
</head>
<body
	style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">

	<form:form commandName="siteVO" id="detailForm" name="detailForm"
		enctype="multipart/form-data">
		<div id="content_pop">
			<!-- 타이틀 -->
			<div id="title">
				<ul>
					<li><img
						src="<c:url value='/images/egovframework/example/title_dot.gif'/>"
						alt="" /> <c:if test="${registerFlag == 'create'}">
							<spring:message code="button.create" />
						</c:if> <c:if test="${registerFlag == 'modify'}">
							<spring:message code="button.modify" />
						</c:if></li>
				</ul>
			</div>
			<!-- // 타이틀 -->
			<div id="table">
				<table width="100%" border="1" cellpadding="0" cellspacing="0"
					style="bordercolor: #D3E2EC; bordercolordark: #FFFFFF; BORDER-TOP: #C2D0DB 2px solid; BORDER-LEFT: #ffffff 1px solid; BORDER-RIGHT: #ffffff 1px solid; BORDER-BOTTOM: #C2D0DB 1px solid; border-collapse: collapse;">
					<colgroup>
						<col width="150" />
						<col width="?" />
					</colgroup>
					<%-- 					<c:if test="${registerFlag == 'modify'}">
						<tr>
							<td class="tbtd_caption"><label for="seq"><spring:message
										code="site.seq" /></label></td>
							<td class="tbtd_content"><form:input path="seq"
									cssClass="essentiality" maxlength="10" readonly="true" /></td>
						</tr>
					</c:if> --%>
					<tr>
						<td class="tbtd_caption"><label for="url"><spring:message
									code="site.url" /></label></td>
						<td class="tbtd_content"><form:input path="url"
								value="${siteVO.url}" maxlength="30" cssClass="txt" /> &nbsp; <form:errors
								path="url" /></td>

						<td class="tbtd_caption"><label for="file"><spring:message
									code="site.file" /></label></td>
						<td class="tbtd_content"><form:input path="file" type="file"
								maxlength="30" cssClass="txt" /> &nbsp; <form:errors
								path="file" /> <c:if test="${registerFlag == 'modify'}">
								<spring:message code="site.currFile" arguments="${fileName}" />
							</c:if></td>
					</tr>
				</table>
			</div>
			<div id="sysbtn">
				<ul>
					<li><span class="btn_blue_l"> <a
							href="javascript:fn_egov_selectList();"><spring:message
									code="button.list" /></a> <img
							src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
							style="margin-left: 6px;" alt="" />
					</span></li>
					<li><span class="btn_blue_l"> <c:if
								test="${registerFlag == 'create'}">
								<a href="javascript:fn_egov_save();"> <spring:message
										code="button.create" />
								</a>
							</c:if> <c:if test="${registerFlag == 'modify'}">
								<a href="javascript:fn_egov_edit(${siteVO.seq});"> <spring:message
										code="button.modify" />
								</a>
							</c:if><img
							src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
							style="margin-left: 6px;" alt="" />
					</span></li>
					<%-- 	<c:if test="${registerFlag == 'modify'}">
						<li><span class="btn_blue_l"> <a
								href="javascript:fn_egov_delete();"><spring:message
										code="button.delete" /></a> <img
								src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
								style="margin-left: 6px;" alt="" />
						</span></li>
					</c:if> --%>
					<li><span class="btn_blue_l"> <a
							href="javascript:document.detailForm.reset();"><spring:message
									code="button.reset" /></a> <img
							src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
							style="margin-left: 6px;" alt="" />
					</span></li>
				</ul>
			</div>
		</div>
		<%-- 		<!-- 검색조건 유지 -->
		<input type="hidden" name="searchCondition"
			value="<c:out value='${searchVO.searchCondition}'/>" />
		<input type="hidden" name="searchKeyword"
			value="<c:out value='${searchVO.searchKeyword}'/>" />
		<input type="hidden" name="pageIndex"
			value="<c:out value='${searchVO.pageIndex}'/>" /> --%>
	</form:form>
</body>
</html>