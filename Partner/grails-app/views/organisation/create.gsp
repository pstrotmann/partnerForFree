<%@ page import="org.strotmann.partner.Organisation" %>
<%@ page import="org.strotmann.partner.Hausadresse" %>
<%@ page import="org.strotmann.partner.Lieferadresse" %>
<%@ page import="org.strotmann.partner.Postfachadresse" %>
<%@ page import="org.strotmann.partner.Bankverbindung" %>
<%@ page import="org.strotmann.partner.Kommunikation" %>
<%@ page import="org.strotmann.notiz.Notiz" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'organisation.label', default: 'Organisation')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-organisation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-organisation" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${organisationInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${organisationInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="form2"/>
					<g:render template="/hausadresse/form2" model="['hausadresseInstance':new Hausadresse()]"/>
					<g:render template="/postfachadresse/form2" model="['postfachadresseInstance':new Postfachadresse()]"/>
					<g:render template="/lieferadresse/form2" model="['lieferadresseInstance':new Lieferadresse()]"/>
					<g:render template="/bankverbindung/form2" model="['bankverbindungInstance':new Bankverbindung()]"/>
					<g:render template="/kommunikation/form2" model="['kommunikationInstance':new Kommunikation()]"/>
					<g:render template="/notiz/form2" model="['notizInstance':new Notiz()]"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
					<g:actionSubmit class="list" action="plz" value="${message(code: 'default.button.plz.label', default: 'plz bestimmen')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
