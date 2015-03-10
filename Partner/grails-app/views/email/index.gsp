
<%@ page import="org.strotmann.mail.Email" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'email.label', default: 'Email')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-email" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-email" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="emailBetreff" title="${message(code: 'email.emailBetreff.label', default: 'Email Betreff')}" />
					
						<g:sortableColumn property="emailText" title="${message(code: 'email.emailText.label', default: 'Email Text')}" />
						
						<g:sortableColumn property="sendedatum" title="${message(code: 'email.sendedatum.label', default: 'Sendedatum')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${emailInstanceList}" status="i" var="emailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${emailInstance.id}">${fieldValue(bean: emailInstance, field: "emailBetreff")}</g:link></td>
					
						<td>${fieldValue(bean: emailInstance, field: "emailText")}</td>
						
						<td><g:formatDate date="${emailInstance?.sendedatum}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${emailInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
