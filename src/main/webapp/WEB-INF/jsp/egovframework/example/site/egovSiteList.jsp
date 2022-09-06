<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	/**
* @Class Name : egovSampleList.jsp
* @Description : Sample List 화면
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
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Web Watcher</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</head>
<body>
	<!-- Always shows a header, even in smaller screens. -->
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
			<div class="mdl-layout__header-row">
				<!-- Title -->
				<span class="mdl-layout-title">Title</span>
				<!-- Add spacer, to align navigation to the right -->
				<div class="mdl-layout-spacer"></div>
				<!-- Navigation. We hide it in small screens. -->
				<nav class="mdl-navigation mdl-layout--large-screen-only">
					<a class="mdl-navigation__link" href="">Link</a> <a
						class="mdl-navigation__link" href="">Link</a> <a
						class="mdl-navigation__link" href="">Link</a> <a
						class="mdl-navigation__link" href="./egovSampleList.do">sample</a>
				</nav>
			</div>
		</header>
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title">Title</span>
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="">Link</a> <a
					class="mdl-navigation__link" href="">Link</a> <a
					class="mdl-navigation__link" href="">Link</a> <a
					class="mdl-navigation__link" href="">Link</a>
			</nav>
		</div>
		<main class="mdl-layout__content">
			<div class="page-content">
				<!-- 여기까지 해더, page content 내부에 로직을 짜면 됨/ 해더가 jsp 전체를 감싸는 구조라 분리 불가 -->





				<div style="height: 200px">site sample</div>
				<div id="table">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						summary="SEQ, url">
						<caption style="visibility: hidden">카테고리ID, 케테고리명, 사용여부,
							Description, 등록자 표시하는 테이블</caption>
						<colgroup>
							<col width="40" />
							<col width="100" />
						</colgroup>
						<tr>
							<th align="center">No</th>
							<th align="center">url</th>
						</tr>
						<c:forEach var="result" items="${resultList}" varStatus="status">
							<tr>
							<%-- 	<td align="center" class="listtd"><c:out
										value="${paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count)}" /></td>
							 --%>	
<%-- 							 	<td align="center" class="listtd"><a
									href="javascript:fn_egov_select('<c:out value="${result.id}"/>')"><c:out
											value="${result.id}" /></a></td> --%>
								<td align="left" class="listtd"><c:out
										value="${result.seq}" />&nbsp;</td>
								<td align="center" class="listtd"><c:out
										value="${result.url}" />&nbsp;</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- /List -->
<%-- 				<div id="paging">
					<ui:pagination paginationInfo="${paginationInfo}" type="image"
						jsFunction="fn_egov_link_page" />
					<form:hidden path="pageIndex" />
				</div>
				<div id="sysbtn">
					<ul>
						<li><span class="btn_blue_l"> <a
								href="javascript:fn_egov_addView();"><spring:message
										code="button.create" /></a> <img
								src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
								style="margin-left: 6px;" alt="" />
						</span></li>
					</ul>
				</div> --%>





				<!-- 여기부터 푸터-->
			</div>
		</main>
		<footer class="mdl-mega-footer">
			<div class="mdl-mega-footer__middle-section">

				<div class="mdl-mega-footer__drop-down-section">
					<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
						checked>
					<h1 class="mdl-mega-footer__heading">Features</h1>
					<ul class="mdl-mega-footer__link-list">
						<li><a href="#">About</a></li>
						<li><a href="#">Terms</a></li>
						<li><a href="#">Partners</a></li>
						<li><a href="#">Updates</a></li>
					</ul>
				</div>

				<div class="mdl-mega-footer__drop-down-section">
					<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
						checked>
					<h1 class="mdl-mega-footer__heading">Details</h1>
					<ul class="mdl-mega-footer__link-list">
						<li><a href="#">Specs</a></li>
						<li><a href="#">Tools</a></li>
						<li><a href="#">Resources</a></li>
					</ul>
				</div>

				<div class="mdl-mega-footer__drop-down-section">
					<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
						checked>
					<h1 class="mdl-mega-footer__heading">Technology</h1>
					<ul class="mdl-mega-footer__link-list">
						<li><a href="#">How it works</a></li>
						<li><a href="#">Patterns</a></li>
						<li><a href="#">Usage</a></li>
						<li><a href="#">Products</a></li>
						<li><a href="#">Contracts</a></li>
					</ul>
				</div>

				<div class="mdl-mega-footer__drop-down-section">
					<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
						checked>
					<h1 class="mdl-mega-footer__heading">FAQ</h1>
					<ul class="mdl-mega-footer__link-list">
						<li><a href="#">Questions</a></li>
						<li><a href="#">Answers</a></li>
						<li><a href="#">Contact us</a></li>
					</ul>
				</div>

			</div>

			<div class="mdl-mega-footer__bottom-section">
				<div class="mdl-logo">Title</div>
				<ul class="mdl-mega-footer__link-list">
					<li><a href="#">Help</a></li>
					<li><a href="#">Privacy & Terms</a></li>
				</ul>
			</div>
		</footer>
	</div>
</body>
</html>