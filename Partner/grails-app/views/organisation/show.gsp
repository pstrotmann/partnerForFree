
<%@ page import="org.strotmann.partner.Organisation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organisation.label', default: 'Organisation')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-organisation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="list" controller="historie" action="domList" params="[dom:organisationInstance,domId:organisationInstance?.id,domName:entityName]"><g:message code="default.histo.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-organisation" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list organisation">
			
				<g:if test="${organisationInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="partner.name.label"/></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${organisationInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.nameZusatz}">
				<li class="fieldcontain">
					<span id="nameZusatz-label" class="property-label"><g:message code="organisation.nameZusatz.label"/></span>
					
						<span class="property-value" aria-labelledby="nameZusatz-label"><g:fieldValue bean="${organisationInstance}" field="nameZusatz"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.rechtsform}">
				<li class="fieldcontain">
					<span id="rechtsform-label" class="property-label"><g:message code="organisation.rechtsform.label"/></span>
					
						<span class="property-value" aria-labelledby="rechtsform-label"><g:fieldValue bean="${organisationInstance}" field="rechtsform"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${organisationInstance?.branche}">
				<li class="fieldcontain">
					<span id="branche-label" class="property-label"><g:message code="organisation.branche.label"/></span>
					
						<span class="property-value" aria-labelledby="branche-label"><g:fieldValue bean="${organisationInstance}" field="branche"/></span>
					
				</li>
				</g:if>
								
				<g:if test="${organisationInstance?.hausadresse}">
				<li class="fieldcontain">
					<span id="hausadresse-label" class="property-label"><g:message code="organisation.hausadresse.label"/></span>
					
						<span class="property-value" aria-labelledby="hausadresse-label"><g:link controller="hausadresse" action="show" id="${organisationInstance?.hausadresse?.id}">${organisationInstance?.hausadresse?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.bankverbindungen}">
				<li class="fieldcontain">
					<span id="bankverbindungen-label" class="property-label"><g:message code="person.bankverbindungen.label"/></span>
					
						<g:each in="${organisationInstance.bankverbindungen}" var="b">
						<span class="property-value" aria-labelledby="bankverbindung-label"><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.kommunikationen}">
				<li class="fieldcontain">
					<span id="kommunikationen-label" class="property-label"><g:message code="person.kommunikationen.label"/></span>
					
						<g:each in="${organisationInstance.kommunikationen}" var="k">
						<span class="property-value" aria-labelledby="kommunikation-label"><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${organisationInstance?.postfachadressen}">
				<li class="fieldcontain">
					<span id="postfachadresse-label" class="property-label"><g:message code="partner.postfachadresse.label"/></span>
					
						<g:each in="${organisationInstance.postfachadressen}" var="p">
						<span class="property-value" aria-labelledby="postfachadresse-label"><g:link controller="postfachadresse" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${organisationInstance?.lieferadressen}">
				<li class="fieldcontain">
					<span id="lieferadresse-label" class="property-label"><g:message code="organisation.lieferadresse.label"/></span>
					
						<g:each in="${organisationInstance.lieferadressen}" var="p">
						<span class="property-value" aria-labelledby="lieferadresse-label"><g:link controller="lieferadresse" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${organisationInstance?.partnerrollen}">
				<li class="fieldcontain">
					<span id="partnerrollen-label" class="property-label"><g:message code="person.partnerrollen.label.ist"/></span>
					
						<g:each in="${organisationInstance.partnerrollen}" var="p">
						<g:if test="${p?.objektname in p?.objektnamen}">
							<span class="property-value" aria-labelledby="partnerrolle-label"><g:link controller="${p.objektname}" action="show" id="${p.objektId}">${p?.encodeAsHTML()}</g:link></span>
						</g:if>
						<g:else>
							<span class="property-value" aria-labelledby="partnerrolle-label"><g:link action="toRueckUri" resource="${p}" ><g:fieldValue bean="${p}" field="beschreibung"/></g:link></span>
						</g:else>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${org.strotmann.partner.Partnerrolle.rollenZuObjekt(organisationInstance)}">
				<li class="fieldcontain">
					<span id="partnerrollen-label" class="property-label"><g:message code="person.partnerrollen.label.hat"/></span>
					
						<g:each in="${org.strotmann.partner.Partnerrolle.rollenZuObjekt(organisationInstance)}" var="ro">
						<g:if test="${ro.partner.instanceOf(org.strotmann.partner.Person)}">
							<span class="property-value" aria-labelledby="partnerrollen-label"><g:link controller="person" action="show" id="${ro.partner.id}">${ro.rolle}: ${ro.partner}</g:link></span>
						</g:if>
						<g:else>
							<span class="property-value" aria-labelledby="partnerrollen-label"><g:link controller="organisation" action="show" id="${ro.partner.id}">${ro.rolle}: ${ro.partner}</g:link></span>
						</g:else>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${organisationInstance?.glaeubigerId}">
				<li class="fieldcontain">
					<span id="glaeubigerId-label" class="property-label"><g:message code="organisation.glaeubigerId.label"/></span>
					
						<span class="property-value" aria-labelledby="glaeubigerId-label"><g:fieldValue bean="${organisationInstance}" field="glaeubigerId"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="person.notizen.label" default="Notizen" /></span>
					
						<g:each in="${org.strotmann.notiz.Notiz.getNotizen('Organisation',organisationInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
					
				</li>
			
			</ol>
			<g:form url="[resource:organisationInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${organisationInstance?.id}" />
					<g:link class="edit" action="edit" id="${organisationInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit method="DELETE" class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
