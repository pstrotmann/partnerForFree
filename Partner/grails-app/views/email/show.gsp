
<%@ page import="org.strotmann.mail.Email" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'email.label', default: 'Email')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-email" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<g:if test="${!emailInstance.gesendet}">
					<li><g:link class="create" action="send" id="${emailInstance.id}"><g:message code="default.send.label" args="['eMail']" /></g:link></li>
				</g:if>
			</ul>
		</div>
		<div id="show-email" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list email">
			
				<g:if test="${emailInstance?.sendedatum}">
				<li class="fieldcontain">
					<span id="datum-label" class="property-label"><g:message code="eMail.sendedatum.label" default="Sendedatum" /></span>
					
						<span class="property-value" aria-labelledby="datum-label"><g:formatDate date="${emailInstance?.sendedatum}" /></span>
					
				</li>
				</g:if>
				
				<g:if test="${emailInstance?.sender}">
				<li class="fieldcontain">
					<span id="sender-label" class="property-label"><g:message code="email.sender.label" default="Sender" /></span>
					
						<span class="property-value" aria-labelledby="sender-label"><g:fieldValue bean="${emailInstance}" field="sender"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${emailInstance?.emailBetreff}">
				<li class="fieldcontain">
					<span id="emailBetreff-label" class="property-label"><g:message code="email.emailBetreff.label" default="Betreff" /></span>
					
						<span class="property-value" aria-labelledby="emailBetreff-label"><g:fieldValue bean="${emailInstance}" field="emailBetreff"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${emailInstance?.emailText}">
				<li class="fieldcontain">
					<span id="emailText-label" class="property-label"><g:message code="email.emailText.label" default="Text" /></span>
					
						<span class="property-value" aria-labelledby="emailText-label"><g:fieldValue bean="${emailInstance}" field="emailText"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${emailInstance?.anhaenge}">
				<li class="fieldcontain">
					<span id="anhaenge-label" class="property-label"><g:message code="email.anhaenge.label" default="Anhänge" /></span>
					
						<g:each in="${emailInstance.anhaenge}" var="a">
						<span class="property-value" aria-labelledby="anhaenge-label"><g:link controller="emailAnhang" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${emailInstance?.emailEmpfaengers}">
				<li class="fieldcontain">
					<span id="Empfänger-label" class="property-label"><g:message code="email.emailEmpfaengers.label" default="Empfänger" /></span>
					
						<g:each in="${emailInstance.emailEmpfaengers}" var="e">
						<span class="property-value" aria-labelledby="Empfänger-label"><g:link controller="emailEmpfaenger" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="emailGesendet-label" class="property-label"><g:message code="email.emailGesendet.label" default="Gesendet" /></span>
					
						<span class="property-value" aria-labelledby="emailGesendet-label"><g:formatBoolean boolean="${emailInstance.gesendet}" true="Ja" false="Nein" /></span>
					
				</li>
				
			
			</ol>
			<g:form url="[resource:emailInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:if test="${!emailInstance.gesendet}">
						<g:link class="edit" action="edit" resource="${emailInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					</g:if>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
