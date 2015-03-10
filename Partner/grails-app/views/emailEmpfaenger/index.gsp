
<%@ page import="org.strotmann.mail.EmailEmpfaenger" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'emailEmpfaenger.label', default: 'EmailEmpfaenger')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-emailEmpfaenger" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-emailEmpfaenger" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="emailAdresse" title="${message(code: 'emailEmpfaenger.emailAdresse.label', default: 'Email Adresse')}" />
					
						<th><g:message code="emailEmpfaenger.eMail.label" default="E Mail" /></th>
					
						<th><g:message code="emailEmpfaenger.partner.label" default="Partner" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${emailEmpfaengerInstanceList}" status="i" var="emailEmpfaengerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${emailEmpfaengerInstance.id}">${fieldValue(bean: emailEmpfaengerInstance, field: "emailAdresse")}</g:link></td>
					
						<td>${fieldValue(bean: emailEmpfaengerInstance, field: "eMail")}</td>
					
						<td>${fieldValue(bean: emailEmpfaengerInstance, field: "partner")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${emailEmpfaengerInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
