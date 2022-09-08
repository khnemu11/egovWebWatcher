<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- <%@ include file="/common/inc/common.jsp"%> --%>

<html>
<head>
	<%-- <%@ include file="/common/inc/head.jsp"%> --%>
	<link rel="stylesheet" href="../arc/signup/signup.css">
	<script>
		function refresh(){
			document.getElementById("captchaImg").src = "<s:url action='signupInput_captcha'/>";
			return false;
		}
	</script>
</head>
<body>

<%-- <jsp:include page="/common/inc/topheader.jsp"></jsp:include> --%>
  <div class="container-login">
    <s:form method="POST" namespace="/signup" theme="simple">
      <s:if test="form.blockdate != null">
        <s:text name="errors.login.overlimit"><s:param value="form.blockdate"/></s:text>
      </s:if>
      <div class="mdl-grid">
        <div class = "mdl-cell mdl-cell--4-col-desktop mdl-cell--2-col-tablet"></div>
        <div class = "mdl-cell mdl-cell--4-col-desktop mdl-cell--4-col-tablet mdl-cell--4-col-phone" id="login-form">
          <h3 class="content-title"><s:text name="signup.title" /></h3>
          <div class="mdl-textfield mdl-js-textfield textfield">
            <!-- email check -->
				<div class="input-name"><s:text name="user.email"/><span><s:text name="common.lbl.required"/></span></div>
				<s:if test="fieldErrors.containsKey('form.email')">
					<div class="mdl-textfield mdl-js-textfield textfield redBox">
				</s:if>
				<s:else>
					<div class="mdl-textfield mdl-js-textfield textfield">
				</s:else>
					<s:textfield name="form.email" cssClass="mdl-textfield__input" id="email" ></s:textfield>
				</div>
				<s:fielderror theme="simple"><s:param>form.email</s:param></s:fielderror>
          </div>

          <div class="input-password">SECURITY CODE *</div>
          <div>
			<img id="captchaImg" src="<s:url action='signupInput_captcha'/>" alt="Captcha Image" height="45" >
		</div>
          <div class="mdl-textfield mdl-js-textfield textfield">
          <!-- code check -->
				<div class="input-name"></div>
				<s:if test="fieldErrors.containsKey('form.captcha')">
					<div class="mdl-textfield mdl-js-textfield textfield redBox">
				</s:if>
				<s:else>
					<div class="mdl-textfield mdl-js-textfield textfield">
				</s:else>
					<s:textfield name="form.captcha" cssClass="mdl-textfield__input" id="code" ></s:textfield>
				</div>
				<s:fielderror theme="simple"><s:param>form.captcha</s:param></s:fielderror>
          </div>

          <s:submit id="login-button" action="signupInput_send" cssClass="mdl-button mdl-js-button mdl-js-ripple-effect" value="SEND"/>

        </div>
        <div class = "mdl-cell mdl-cell--4-col-desktop mdl-cell--2-col-tablet"></div>
      </div>
    </s:form>
  </div>
  <input type="hidden" id="lang_url" value="/arc/signup/signupInput.arc">
  <%-- <jsp:include page="/common/inc/footer.jsp" /> --%>


</body>
</html>