
<%@ page import="org.strotmann.mail.EmailEmpfaenger" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'emailEmpfaenger.label', default: 'EmailEmpfaenger')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-emailEmpfaenger" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-emailEmpfaenger" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list emailEmpfaenger">
			
				<g:if test="${emailEmpfaengerInstance?.emailAdresse}">
				<li class="fieldcontain">
					<span id="emailAdresse-label" class="property-label"><g:message code="emailEmpfaenger.emailAdresse.label" default="Email Adresse" /></span>
					
						<span class="property-value" aria-labelledby="emailAdresse-label"><g:fieldValue bean="${emailEmpfaengerInstance}" field="emailAdresse"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${emailEmpfaengerInstance?.eMail}">
				<li class="fieldcontain">
					<span id="eMail-label" class="property-label"><g:message code="emailEmpfaenger.eMail.label" default="E Mail" /></span>
					
						<span class="property-value" aria-labelledby="eMail-label"><g:link controller="email" action="show" id="${emailEmpfaengerInstance?.eMail?.id}">${emailEmpfaengerInstance?.eMail?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${emailEmpfaengerInstance?.partner}">
				<li class="fieldcontain">
					<span id="partner-label" class="property-label"><g:message code="emailEmpfaenger.partner.label" default="Partner" /></span>
					
						<span class="property-value" aria-labelledby="partner-label"><g:link controller="partner" action="show" id="${emailEmpfaengerInstance?.partner?.id}">${emailEmpfaengerInstance?.partner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:emailEmpfaengerInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${emailEmpfaengerInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
