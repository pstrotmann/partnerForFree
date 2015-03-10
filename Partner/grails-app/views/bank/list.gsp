<%@ page import="org.strotmann.partner.Bank" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bank.label', default: 'Bank')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-bank" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.matchcode.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-bank" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						<g:sortableColumn property="bic" title="${message(code: 'bank.bic.label', default: 'Bic')}" />
					
						<g:sortableColumn property="blz" title="${message(code: 'bank.blz.label', default: 'Blz')}" />
						
						<g:sortableColumn property="bankname" title="${message(code: 'bank.bankname.label', default: 'Bankname')}" />
					
						<g:sortableColumn property="plz" title="${message(code: 'bank.plz.label', default: 'Plz')}" />
						
						<g:sortableColumn property="ort" title="${message(code: 'bank.ort.label', default: 'Ort')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${bankInstanceList}" status="i" var="bankInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${bankInstance.id}">${fieldValue(bean: bankInstance, field: "bic")}</g:link></td>
					
						<td>${fieldValue(bean: bankInstance, field: "blz")}</td>
						
						<td>${fieldValue(bean: bankInstance, field: "bankname")}</td>
					
						<td>${fieldValue(bean: bankInstance, field: "plz")}</td>
						
						<td>${fieldValue(bean: bankInstance, field: "ort")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bankInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>