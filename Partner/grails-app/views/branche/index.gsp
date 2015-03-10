
<%@ page import="org.strotmann.partner.Branche" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'branche.label', default: 'Branche')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-branche" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-branche" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="kode" title="${message(code: 'branche.kode.label', default: 'Kode')}" />
					
						<g:sortableColumn property="bezeichnung" title="${message(code: 'branche.bezeichnung.label', default: 'Bezeichnung')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${brancheInstanceList}" status="i" var="brancheInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${brancheInstance.id}">${fieldValue(bean: brancheInstance, field: "kode")}</g:link></td>
					
						<td>${fieldValue(bean: brancheInstance, field: "bezeichnung")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${brancheInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
