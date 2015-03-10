
<%@ page import="org.strotmann.partner.Partnerrolle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'partnerrolle.label', default: 'Partnerrolle')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-partnerrolle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-partnerrolle" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list partnerrolle">
			
				<g:if test="${partnerrolleInstance?.partner.instanceOf(org.strotmann.partner.Person)}">
				<li class="fieldcontain">
					<span id="partner-label" class="property-label"><g:message code="partnerrolle.person.label" default="Person" /></span>
					<span class="property-value" aria-labelledby="person-label"><g:link controller="person" action="show" id="${partnerrolleInstance?.partner?.id}">${partnerrolleInstance?.partner?.encodeAsHTML()}</g:link></span>
				</li>
				</g:if>
				<g:if test="${partnerrolleInstance?.partner.instanceOf(org.strotmann.partner.Organisation)}">
				<li class="fieldcontain">
					<span id="partner-label" class="property-label"><g:message code="partnerrolle.person.label" default="Organisation" /></span>
					<span class="property-value" aria-labelledby="organisation-label"><g:link controller="organisation" action="show" id="${partnerrolleInstance?.partner?.id}">${partnerrolleInstance?.partner?.encodeAsHTML()}</g:link></span>
				</li>
				</g:if>
			
				<g:if test="${partnerrolleInstance?.rolle}">
				<li class="fieldcontain">
					<span id="rolle-label" class="property-label"><g:message code="partnerrolle.rolle.label" default="Rolle" /></span>
					
						<span class="property-value" aria-labelledby="rolle-label"><g:fieldValue bean="${partnerrolleInstance}" field="rolle"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerrolleInstance?.objektname}">
				<li class="fieldcontain">
					<span id="objektname-label" class="property-label"><g:message code="partnerrolle.objektname.label" default=" " /></span>
					
						<span class="property-value" aria-labelledby="objektname-label"><g:fieldValue bean="${partnerrolleInstance}" field="objektname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${partnerrolleInstance?.objektId}">
				<li class="fieldcontain">
					<span id="objektId-label" class="property-label"><g:message code="partnerrolle.objektId.label" default=" " /></span>
					
						<span class="property-value" aria-labelledby="objektId-label"><g:link controller="${partnerrolleInstance?.objektname}" action="show" id="${partnerrolleInstance?.objektId}">${partnerrolleInstance?.objekt}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:partnerrolleInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${partnerrolleInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
