
<%@ page import="org.strotmann.mail.Sms" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sms.label', default: 'Sms')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-sms" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.send.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-sms" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list sms">
			
				<g:if test="${smsInstance?.inhalt}">
				<li class="fieldcontain">
					<span id="inhalt-label" class="property-label"><g:message code="sms.inhalt.label" default="Inhalt" /></span>
					
						<span class="property-value" aria-labelledby="inhalt-label"><g:fieldValue bean="${smsInstance}" field="inhalt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsInstance?.sender}">
				<li class="fieldcontain">
					<span id="sender-label" class="property-label"><g:message code="sms.sender.label" default="Sender" /></span>
					
						<span class="property-value" aria-labelledby="sender-label"><g:fieldValue bean="${smsInstance}" field="sender"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsInstance?.empfaenger}">
				<li class="fieldcontain">
					<span id="empfaenger-label" class="property-label"><g:message code="sms.empfaenger.label" default="Empfaenger" /></span>
					
						<span class="property-value" aria-labelledby="empfaenger-label"><g:fieldValue bean="${smsInstance}" field="empfaengerAufb"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsInstance?.datum}">
				<li class="fieldcontain">
					<span id="datum-label" class="property-label"><g:message code="sms.datum.label" default="Datum" /></span>
					
						<span class="property-value" aria-labelledby="datum-label"><g:formatDate date="${smsInstance?.datum}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:smsInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${smsInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
