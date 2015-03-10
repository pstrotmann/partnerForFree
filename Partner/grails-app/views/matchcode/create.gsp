<%@ page import="org.strotmann.partner.Matchcode" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'matchcode.label', default: 'Matchcode')}" />
		<title><g:message code="default.matchcode.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-matchcode" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="create-matchcode" class="content scaffold-create" role="main">
			<h1><g:message code="default.matchcode.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${matchcodeInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${matchcodeInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="list" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.mcHard.label', default: 'Query')}" />
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.mcPhone.label', default: 'Query')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
