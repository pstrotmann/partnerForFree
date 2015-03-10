
<%@ page import="org.strotmann.benutzer.Benutzer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'benutzer.label', default: 'Benutzer')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-benutzer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-benutzer" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list benutzer">
			
				<g:if test="${benutzerInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="benutzer.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${benutzerInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${benutzerInstance?.passwort}">
				<li class="fieldcontain">
					<span id="passwort-label" class="property-label"><g:message code="benutzer.passwort.label" default="Passwort" /></span>
					
						<span class="property-value" aria-labelledby="passwort-label"><g:fieldValue bean="${benutzerInstance}" field="passwort"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${benutzerInstance?.sprache}">
				<li class="fieldcontain">
					<span id="sprache-label" class="property-label"><g:message code="benutzer.sprache.label" default="Sprache" /></span>
					
						<span class="property-value" aria-labelledby="sprache-label"><g:fieldValue bean="${benutzerInstance}" field="sprache"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:benutzerInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${benutzerInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
