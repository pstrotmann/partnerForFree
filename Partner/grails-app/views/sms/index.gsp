
<%@ page import="org.strotmann.mail.Sms" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sms.label', default: 'Sms')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-sms" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.send.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-sms" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="inhalt" title="${message(code: 'sms.inhalt.label', default: 'Inhalt')}" />
					
						<g:sortableColumn property="empfaenger" title="${message(code: 'sms.empfaenger.label', default: 'Empfaenger')}" />
					
						<g:sortableColumn property="datum" title="${message(code: 'sms.datum.label', default: 'Datum')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${smsInstanceList}" status="i" var="smsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${smsInstance.id}">${fieldValue(bean: smsInstance, field: "inhalt")}</g:link></td>
					
						<td>${fieldValue(bean: smsInstance, field: "empfaengerAufb")}</td>
					
						<td><g:formatDate date="${smsInstance.datum}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${smsInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
