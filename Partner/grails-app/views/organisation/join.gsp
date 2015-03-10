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
			</ul>
		</div>
		<div id="show-organisation" class="content scaffold-show" role="main">
			<h1><g:message code="default.pMerge.label" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:form method="put" action="joinZwei">
			<table>
				<thead>
					<tr>
						<th></th>
						<th>Organisation 1</th>
						<th></th>
						<th>Organisation 2</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Name</td>
						<td><g:fieldValue bean="${organisationInstance1}" field="name"/></td>
						<td><g:checkBox name="organisationInstance1.name"/></td>
						<td><g:fieldValue bean="${organisationInstance2}" field="name"/></td>
						<td><g:checkBox name="organisationInstance2.name"/></td>
					</tr>
					<tr>
						<td>nameZusatz</td>
						<td><g:fieldValue bean="${organisationInstance1}" field="nameZusatz"/></td>
						<td><g:checkBox name="organisationInstance1.nameZusatz"/></td>
						<td><g:fieldValue bean="${organisationInstance2}" field="nameZusatz"/></td>
						<td><g:checkBox name="organisationInstance2.nameZusatz"/></td>
					</tr>
					<tr>
						<td>rechtsform</td>
						<td><g:fieldValue bean="${organisationInstance1}" field="rechtsform"/></td>
						<td><g:checkBox name="organisationInstance1.rechtsform"/></td>
						<td><g:fieldValue bean="${organisationInstance2}" field="rechtsform"/></td>
						<td><g:checkBox name="organisationInstance2.rechtsform"/></td>
					</tr>
					<tr>
						<td>hausadresse</td>
						<td><g:link controller="hausadresse" action="show" id="${organisationInstance1?.hausadresse?.id}">${organisationInstance1?.hausadresse?.encodeAsHTML()}</g:link></td>
						<td><g:checkBox name="organisationInstance1.hausadresse"/></td>
						<td><g:link controller="hausadresse" action="show" id="${organisationInstance2?.hausadresse?.id}">${organisationInstance2?.hausadresse?.encodeAsHTML()}</g:link></td>
						<td><g:checkBox name="organisationInstance2.hausadresse"/></td>
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