
<%@ page import="org.strotmann.partner.Bankverbindung" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bankverbindung.label', default: 'Bankverbindung')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-bankverbindung" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-bankverbindung" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="iban" title="${message(code: 'bankverbindung.iban.label', default: 'Iban')}" />
					
						<th><g:message code="bankverbindung.partner.label" default="Partner" /></th>
						
						<th><g:message code="bankverbindung.bic.label" default="BIC" /></th>
						
						<th><g:message code="bankverbindung.adr.label" default=" " /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${bankverbindungInstanceList}" status="i" var="bankverbindungInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${bankverbindungInstance.id}">${fieldValue(bean: bankverbindungInstance, field: "iban")}</g:link></td>
					
						<td>${fieldValue(bean: bankverbindungInstance, field: "partner")}</td>
						
						<td>${fieldValue(bean: bankverbindungInstance, field: "bic")}</td>
						
						<td>${fieldValue(bean: bankverbindungInstance, field: "nameUndAdresse")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bankverbindungInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
