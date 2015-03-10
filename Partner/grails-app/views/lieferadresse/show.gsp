
<%@ page import="org.strotmann.partner.Lieferadresse" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lieferadresse.label', default: 'Lieferadresse')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-lieferadresse" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-lieferadresse" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list lieferadresse">
			
				<g:if test="${lieferadresseInstance?.strasse}">
				<li class="fieldcontain">
					<span id="strasse-label" class="property-label"><g:message code="lieferadresse.strasse.label" default="Strasse" /></span>
					
						<span class="property-value" aria-labelledby="strasse-label"><g:fieldValue bean="${lieferadresseInstance}" field="strasse"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lieferadresseInstance?.hausnummer}">
				<li class="fieldcontain">
					<span id="hausnummer-label" class="property-label"><g:message code="lieferadresse.hausnummer.label" default="Hausnummer" /></span>
					
						<span class="property-value" aria-labelledby="hausnummer-label"><g:fieldValue bean="${lieferadresseInstance}" field="hausnummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lieferadresseInstance?.zusatz}">
				<li class="fieldcontain">
					<span id="zusatz-label" class="property-label"><g:message code="lieferadresse.zusatz.label" default="Zusatz" /></span>
					
						<span class="property-value" aria-labelledby="zusatz-label"><g:fieldValue bean="${lieferadresseInstance}" field="zusatz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lieferadresseInstance?.postleitzahl}">
				<li class="fieldcontain">
					<span id="postleitzahl-label" class="property-label"><g:message code="lieferadresse.postleitzahl.label" default="Postleitzahl" /></span>
					
						<span class="property-value" aria-labelledby="postleitzahl-label"><g:fieldValue bean="${lieferadresseInstance}" field="postleitzahl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lieferadresseInstance?.ort}">
				<li class="fieldcontain">
					<span id="ort-label" class="property-label"><g:message code="lieferadresse.ort.label" default="Ort" /></span>
					
						<span class="property-value" aria-labelledby="ort-label"><g:fieldValue bean="${lieferadresseInstance}" field="ort"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lieferadresseInstance?.land}">
				<li class="fieldcontain">
					<span id="land-label" class="property-label"><g:message code="lieferadresse.land.label" default="Land" /></span>
					
						<span class="property-value" aria-labelledby="land-label"><g:link controller="land" action="show" id="${lieferadresseInstance?.land?.id}">${lieferadresseInstance?.land?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${lieferadresseInstance?.anfahrt}">
				<li class="fieldcontain">
					<span id="anfahrt-label" class="property-label"><g:message code="lieferadresse.anfahrt.label" default="Anfahrt" /></span>
					
						<span class="property-value" aria-labelledby="anfahrt-label"><g:fieldValue bean="${lieferadresseInstance}" field="anfahrt"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lieferadresseInstance?.partner}">
				<li class="fieldcontain">
					<span id="partner-label" class="property-label"><g:message code="lieferadresse.partner.label" default="Partner" /></span>
					
						<span class="property-value" aria-labelledby="partner-label"><g:link controller="organisation" action="show" id="${lieferadresseInstance?.partner?.id}">${lieferadresseInstance?.partner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
			</ol>
			<g:form url="[resource:lieferadresseInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${lieferadresseInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
