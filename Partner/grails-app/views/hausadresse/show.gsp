
<%@ page import="org.strotmann.partner.Hausadresse" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'hausadresse.label', default: 'Hausadresse')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-hausadresse" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" ><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-hausadresse" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list hausadresse">
			
				<g:if test="${hausadresseInstance?.strasse}">
				<li class="fieldcontain">
					<span id="strasse-label" class="property-label"><g:message code="hausadresse.strasse.label" default="Strasse" /></span>
					
						<span class="property-value" aria-labelledby="strasse-label"><g:fieldValue bean="${hausadresseInstance}" field="strasse"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hausadresseInstance?.hausnummer}">
				<li class="fieldcontain">
					<span id="hausnummer-label" class="property-label"><g:message code="hausadresse.hausnummer.label" default="Hausnummer" /></span>
					
						<span class="property-value" aria-labelledby="hausnummer-label"><g:fieldValue bean="${hausadresseInstance}" field="hausnummer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hausadresseInstance?.zusatz}">
				<li class="fieldcontain">
					<span id="zusatz-label" class="property-label"><g:message code="hausadresse.zusatz.label" default="Zusatz" /></span>
					
						<span class="property-value" aria-labelledby="zusatz-label"><g:fieldValue bean="${hausadresseInstance}" field="zusatz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hausadresseInstance?.postleitzahl}">
				<li class="fieldcontain">
					<span id="postleitzahl-label" class="property-label"><g:message code="hausadresse.postleitzahl.label" default="Postleitzahl" /></span>
					
						<span class="property-value" aria-labelledby="postleitzahl-label"><g:fieldValue bean="${hausadresseInstance}" field="postleitzahl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${hausadresseInstance?.ort}">
				<li class="fieldcontain">
					<span id="ort-label" class="property-label"><g:message code="hausadresse.ort.label" default="Ort" /></span>
					
						<span class="property-value" aria-labelledby="ort-label"><g:fieldValue bean="${hausadresseInstance}" field="ort"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${hausadresseInstance?.land}">
				<li class="fieldcontain">
					<span id="land-label" class="property-label"><g:message code="land.postleitzahl.label" default="Land" /></span>
					
						<span class="property-value" aria-labelledby="land-label"><g:fieldValue bean="${hausadresseInstance}" field="land"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="bewohner-label" class="property-label"><g:message code="hausadresse.bewohner.label" default="Bewohner" /></span>
					
						<g:each in="${hausadresseInstance.bewohner}" var="b">
						<g:if test="${b.instanceOf(org.strotmann.partner.Person)}">
						<span class="property-value" aria-labelledby="bewohner-label"><g:link controller="person" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:if>
						<g:else>
						<span class="property-value" aria-labelledby="bewohner-label"><g:link controller="organisation" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:else>
						</g:each>
					
				</li>
			
			</ol>
			<g:form url="[resource:hausadresseInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${hausadresseInstance?.id}" />
					<g:link class="edit" action="edit" id="${hausadresseInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
