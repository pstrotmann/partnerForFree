
<%@ page import="org.strotmann.partner.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><a href="${createLink(uri: '/matchcode/create')}"><g:message code="default.mcSuch.label"/></a></li>
				<li><g:link class="list" controller="historie" action="domList" params="[dom:personInstance,domId:personInstance?.id,domName:entityName]"><g:message code="default.histo.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-person" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list person">
			
				<g:if test="${personInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="person.name.label"/></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${personInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.titel}">
				<li class="fieldcontain">
					<span id="titel-label" class="property-label"><g:message code="person.titel.label"/></span>
					
						<span class="property-value" aria-labelledby="titel-label"><g:fieldValue bean="${personInstance}" field="titel"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.vorname}">
				<li class="fieldcontain">
					<span id="vorname-label" class="property-label"><g:message code="person.vorname.label"/></span>
					
						<span class="property-value" aria-labelledby="vorname-label"><g:fieldValue bean="${personInstance}" field="vorname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.geschlecht}">
				<li class="fieldcontain">
					<span id="geschlecht-label" class="property-label"><g:message code="person.geschlecht.label"/></span>
					
						<span class="property-value" aria-labelledby="geschlecht-label"><g:fieldValue bean="${personInstance}" field="geschlecht"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.geburtsdatum}">
				<li class="fieldcontain">
					<span id="geburtsdatum-label" class="property-label"><g:message code="person.geburtsdatum.label"/></span>
					
						<span class="property-value" aria-labelledby="geburtsdatum-label"><g:formatDate date="${personInstance?.geburtsdatum}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${personInstance?.persoenlicheAnrede}">
    			<li class="fieldcontain">
					<span id="persoenlicheAnrede-label" class="property-label"><g:message code="person.persoenlicheAnrede.label"/></span>

						<span class="property-value" aria-labelledby="persoenlicheAnrede-label"><g:formatBoolean boolean="${personInstance?.persoenlicheAnrede}" true="persönlich" false="formal"/></span>
					  
    			</li>
				</g:if>
				
				<g:if test="${personInstance?.nationalitaet}">
				<li class="fieldcontain">
					<span id="nationalitaet-label" class="property-label"><g:message code="person.nationalitaet.label"/></span>
					
						<span class="property-value" aria-labelledby="nationalitaet-label">${personInstance?.nationalitaet?.encodeAsHTML()}</span>
					
				</li>
				</g:if>
				
				<g:if test="${personInstance?.religion}">
				<li class="fieldcontain">
					<span id="religion-label" class="property-label"><g:message code="person.religion.label"/></span>
					
						<span class="property-value" aria-labelledby="religion-label">${personInstance?.religion?.encodeAsHTML()}</span>
					
				</li>
				</g:if>
				
				<g:if test="${personInstance?.beruf}">
				<li class="fieldcontain">
					<span id="beruf-label" class="property-label"><g:message code="person.beruf.label"/></span>
					
						<span class="property-value" aria-labelledby="beruf-label"><g:fieldValue bean="${personInstance}" field="beruf"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${personInstance?.taetigkeit}">
				<li class="fieldcontain">
					<span id="beruf-label" class="property-label"><g:message code="person.taetigkeit.label"/></span>
					
						<span class="property-value" aria-labelledby="taetigkeit-label"><g:fieldValue bean="${personInstance}" field="taetigkeit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.hausadresse}">
				<li class="fieldcontain">
					<span id="hausadresse-label" class="property-label"><g:message code="person.hausadresse.label"/></span>
					
						<span class="property-value" aria-labelledby="hausadresse-label"><g:link controller="hausadresse" action="show" id="${personInstance?.hausadresse?.id}">${personInstance?.hausadresse?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${personInstance?.bankverbindungen}">
				<li class="fieldcontain">
					<span id="bankverbindungen-label" class="property-label"><g:message code="person.bankverbindungen.label"/></span>
					
						<g:each in="${personInstance.bankverbindungen}" var="b">
						<span class="property-value" aria-labelledby="bankverbindung-label"><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.kommunikationen}">
				<li class="fieldcontain">
					<span id="kommunikationen-label" class="property-label"><g:message code="person.kommunikationen.label"/></span>
					
						<g:each in="${personInstance.kommunikationen}" var="k">
						<span class="property-value" aria-labelledby="kommunikation-label"><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${personInstance?.lastschriftmandate}">
				<li class="fieldcontain">
					<span id="lastschriftmandat-label" class="property-label"><g:message code="person.lastschriftmandate.label"/></span>
					
						<g:each in="${personInstance.lastschriftmandate}" var="l">
						<span class="property-value" aria-labelledby="lastschriftmandat-label"><g:link controller="lastschriftmandat" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${personInstance?.partnerrollen}">
				<li class="fieldcontain">
					<span id="partnerrollen-label" class="property-label"><g:message code="person.partnerrollen.label.ist"/></span>
					
						<g:each in="${personInstance.partnerrollen}" var="p">
						<g:if test="${p?.objektname in p?.objektnamen}">
							<span class="property-value" aria-labelledby="partnerrolle-label"><g:link controller="${p.objektname}" action="show" id="${p.objektId}">${p?.encodeAsHTML()}</g:link></span>
						</g:if>
						<g:else>
							<span class="property-value" aria-labelledby="partnerrolle-label"><g:link action="toRueckUri" resource="${p}" ><g:fieldValue bean="${p}" field="beschreibung"/></g:link></span>
						</g:else>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${org.strotmann.partner.Partnerrolle.rollenZuObjekt(personInstance)}">
				<li class="fieldcontain">
					<span id="partnerrollen-label" class="property-label"><g:message code="person.partnerrollen.label.hat"/></span>
					
						<g:each in="${org.strotmann.partner.Partnerrolle.rollenZuObjekt(personInstance)}" var="ro">
						<g:if test="${ro.partner.instanceOf(org.strotmann.partner.Person)}">
							<span class="property-value" aria-labelledby="partnerrollen-label"><g:link controller="person" action="show" id="${ro.partner.id}">${ro.rolle}: ${ro.partner}</g:link></span>
						</g:if>
						<g:else>
							<span class="property-value" aria-labelledby="partnerrollen-label"><g:link controller="organisation" action="show" id="${ro.partner.id}">${ro.rolle}: ${ro.partner}</g:link></span>
						</g:else>
						</g:each>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="notizen-label" class="property-label"><g:message code="person.notizen.label"/></span>
					
						<g:each in="${org.strotmann.notiz.Notiz.getNotizen('Person',personInstance.id)}" var="n">
						<span class="property-value" aria-labelledby="notizen-label"><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></span>
						</g:each>
					
				</li>
			
			</ol>
			<g:form url="[resource:personInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${personInstance?.id}" />
					<g:link class="edit" action="edit" id="${personInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
