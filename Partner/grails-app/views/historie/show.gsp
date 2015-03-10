
<%@ page import="org.strotmann.partner.Historie" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'historie.label', default: 'Historie')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-historie" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-historie" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list historie">
			
				<g:if test="${historieInstance?.userName}">
				<li class="fieldcontain">
					<span id="userName-label" class="property-label"><g:message code="historie.userName.label" default="User Name" /></span>
					
						<span class="property-value" aria-labelledby="userName-label"><g:fieldValue bean="${historieInstance}" field="userName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${historieInstance?.gueAb}">
				<li class="fieldcontain">
					<span id="gueAb-label" class="property-label"><g:message code="historie.gueAb.label" default="Gue Ab" /></span>
					
						<span class="property-value" aria-labelledby="gueAb-label"><g:formatDate date="${historieInstance?.gueAb}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${historieInstance?.domainName}">
				<li class="fieldcontain">
					<span id="domainName-label" class="property-label"><g:message code="historie.domainName.label" default="Domain Name" /></span>
					
						<span class="property-value" aria-labelledby="domainName-label"><g:fieldValue bean="${historieInstance}" field="domainName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${historieInstance?.domainId}">
				<li class="fieldcontain">
					<span id="domainId-label" class="property-label"><g:message code="historie.domainId.label" default="Domain Id" /></span>
					
						<span class="property-value" aria-labelledby="domainId-label"><g:fieldValue bean="${historieInstance}" field="domainId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${historieInstance?.feldName}">
				<li class="fieldcontain">
					<span id="feldName-label" class="property-label"><g:message code="historie.feldName.label" default="Feld Name" /></span>
					
						<span class="property-value" aria-labelledby="feldName-label"><g:fieldValue bean="${historieInstance}" field="feldName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${historieInstance?.stringInhalt}">
				<li class="fieldcontain">
					<span id="stringInhalt-label" class="property-label"><g:message code="historie.stringInhalt.label" default="String Inhalt" /></span>
					
						<span class="property-value" aria-labelledby="stringInhalt-label"><g:fieldValue bean="${historieInstance}" field="stringInhalt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${historieInstance?.charInhalt}">
				<li class="fieldcontain">
					<span id="charInhalt-label" class="property-label"><g:message code="historie.charInhalt.label" default="Char Inhalt" /></span>
					
						<span class="property-value" aria-labelledby="charInhalt-label"><g:fieldValue bean="${historieInstance}" field="charInhalt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${historieInstance?.intInhalt}">
				<li class="fieldcontain">
					<span id="intInhalt-label" class="property-label"><g:message code="historie.intInhalt.label" default="Int Inhalt" /></span>
					
						<span class="property-value" aria-labelledby="intInhalt-label"><g:fieldValue bean="${historieInstance}" field="intInhalt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${historieInstance?.longInhalt}">
				<li class="fieldcontain">
					<span id="longInhalt-label" class="property-label"><g:message code="historie.longInhalt.label" default="Long Inhalt" /></span>
					
						<span class="property-value" aria-labelledby="longInhalt-label"><g:fieldValue bean="${historieInstance}" field="longInhalt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${historieInstance?.dateInhalt}">
				<li class="fieldcontain">
					<span id="dateInhalt-label" class="property-label"><g:message code="historie.dateInhalt.label" default="Date Inhalt" /></span>
					
						<span class="property-value" aria-labelledby="dateInhalt-label"><g:formatDate date="${historieInstance?.dateInhalt}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${historieInstance?.booleanInhalt}">
				<li class="fieldcontain">
					<span id="booleanInhalt-label" class="property-label"><g:message code="historie.booleanInhalt.label" default="Boolean Inhalt" /></span>
					
						<span class="property-value" aria-labelledby="booleanInhalt-label"><g:formatBoolean boolean="${historieInstance?.booleanInhalt}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:historieInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${historieInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
