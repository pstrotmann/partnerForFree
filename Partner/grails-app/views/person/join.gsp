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
			</ul>
		</div>
		<div id="show-person" class="content scaffold-show" role="main">
			<h1><g:message code="default.pMerge.label" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:form method="put" action="joinZwei">
			<table>
				<thead>
					<tr>
						<th></th>
						<th>Person 1</th>
						<th></th>
						<th>Person 2</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Name</td>
						<td><g:fieldValue bean="${personInstance1}" field="name"/></td>
						<td><g:checkBox name="personInstance1.name"/></td>
						<td><g:fieldValue bean="${personInstance2}" field="name"/></td>
						<td><g:checkBox name="personInstance2.name"/></td>
					</tr>
					<tr>
						<td>Titel</td>
						<td><g:fieldValue bean="${personInstance1}" field="titel"/></td>
						<td><g:checkBox name="personInstance1.titel"/></td>
						<td><g:fieldValue bean="${personInstance2}" field="titel"/></td>
						<td><g:checkBox name="personInstance2.titel"/></td>
					</tr>
					<tr>
						<td>Vorname</td>
						<td><g:fieldValue bean="${personInstance1}" field="vorname"/></td>
						<td><g:checkBox name="personInstance1.vorname"/></td>
						<td><g:fieldValue bean="${personInstance2}" field="vorname"/></td>
						<td><g:checkBox name="personInstance2.vorname"/></td>
					</tr>
					<tr>
						<td>Geschlecht</td>
						<td><g:fieldValue bean="${personInstance1}" field="geschlecht"/></td>
						<td><g:checkBox name="personInstance1.geschlecht"/></td>
						<td><g:fieldValue bean="${personInstance2}" field="geschlecht"/></td>
						<td><g:checkBox name="personInstance2.geschlecht"/></td>
					</tr>
					<tr>
						<td>Anrede</td>
						<td><g:formatBoolean boolean="${personInstance1?.persoenlicheAnrede}" true="persönlich" false="formal"/></td>
						<td><g:checkBox name="personInstance1.anrede"/></td>
						<td><g:formatBoolean boolean="${personInstance2?.persoenlicheAnrede}" true="persönlich" false="formal"/></td>
						<td><g:checkBox name="personInstance2.anrede"/></td>
					</tr>
					<tr>
						<td>Geburtsdatum</td>
						<td><g:formatDate date="${personInstance1?.geburtsdatum}" format="dd.MM.yyyy"/></td>
						<td><g:checkBox name="personInstance1.geburtsdatum"/></td>
						<td><g:formatDate date="${personInstance2?.geburtsdatum}" format="dd.MM.yyyy"/></td>
						<td><g:checkBox name="personInstance2.geburtsdatum"/></td>
					</tr>
					<tr>
						<td>Hausadresse</td>
						<td><g:link controller="hausadresse" action="show" id="${personInstance1?.hausadresse?.id}">${personInstance1?.hausadresse?.encodeAsHTML()}</g:link></td>
						<td><g:checkBox name="personInstance1.hausadresse"/></td>
						<td><g:link controller="hausadresse" action="show" id="${personInstance2?.hausadresse?.id}">${personInstance2?.hausadresse?.encodeAsHTML()}</g:link></td>
						<td><g:checkBox name="personInstance2.hausadresse"/></td>
					</tr>
				</tbody>
			</table>
			<fieldset class="buttons">
				<g:actionSubmit class="save" action="joinZwei" value="${message(code: 'default.button.merge.label', default: 'Join')}" />
			</fieldset>
			</g:form>
		</div>
	</body>
</html>