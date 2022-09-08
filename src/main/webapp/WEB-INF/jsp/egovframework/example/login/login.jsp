<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%-- <%@ include file="/common/inc/common.jsp"%><html> --%>
<head>
	<%-- <%@ include file="/common/inc/head.jsp"%> --%>
	<link rel="stylesheet" href="../arc/login/login.css">
</head>
<body>
<%-- <%@ include file="/common/inc/topheader.jsp"%> --%>

<div class="container_login">
<div class="mdl-grid">
<div class = "mdl-cell mdl-cell--2-col "></div>
<div class = "mdl-cell mdl-cell--8-col" id="row_login">
<s:form method="POST" theme="simple">
				<s:if test="form.blockdate != null">
					<s:text name="errors.login.overlimit"><s:param value="form.blockdate"/></s:text>
				</s:if>
				 <div class="mdl-grid">
        <div class = "mdl-cell mdl-cell--4-col-desktop mdl-cell--2-col-tablet"></div>
        <div class = "mdl-cell mdl-cell--4-col-desktop mdl-cell--4-col-tablet mdl-cell--4-col-phone" id="login-form">
          <h3 class="content-title"><s:text name="login.title"/></h3>
          <div class="input-name"><s:text name="login.id"/></div>
          <div class="mdl-textfield mdl-js-textfield textfield">
            <s:textfield name="form.loginId" cssClass="mdl-textfield__input" id="loginId" ></s:textfield>
          </div>
          <s:fielderror theme="simple"><s:param name="form.loginId">form.loginId</s:param></s:fielderror>
          <div class="input-password"><s:text name="login.password"/></div>
          <div class="mdl-textfield mdl-js-textfield textfield">
            <s:password name="form.password" cssClass="mdl-textfield__input" id="password"/>
          </div>
          <s:fielderror theme="simple"><s:param name="form.password">form.password</s:param></s:fielderror>
		  <s:fielderror theme="simple"><s:param name="form.fail">form.fail</s:param></s:fielderror>
		  <s:fielderror theme="simple"><s:param name="form.overlimit">form.overlimit</s:param></s:fielderror>
          <s:submit id="login-button" action="login_login" cssClass="mdl-button mdl-js-button mdl-js-ripple-effect" key="login.login"/>
          <div class="sign-up">
            <a href ="../signup/signupInput.arc" id="sign-up-button"><s:text name="login.signup"/></a>
          </div>
          <div class ="forgot-password">
            <a href="../findpassword/findpasswordInput.arc"><s:text name="login.forgetPassword"/></a>
          </div>
        </div>
        <div class = "mdl-cell mdl-cell--4-col-desktop mdl-cell--2-col-tablet"></div>
      </div>
</s:form>
</div>
<div class = "mdl-cell mdl-cell--2-col "></div>
</div>
</div>
<%-- <%@ include file="/common/inc/footer.jsp"%> --%>

<script type="text/javascript"
	src="../../resources/arc/js/material.js"></script>
</body>
</html>
</html>