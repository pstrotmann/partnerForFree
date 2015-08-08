
<%@ page import="org.strotmann.partner.RueckUri" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'rueckUri.label', default: 'RueckUri')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-rueckUri" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-rueckUri" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="anwendung" title="${message(code: 'rueckUri.anwendung.label', default: 'Anwendung')}" />
					
						<g:sortableColumn property="uri" title="${message(code: 'rueckUri.uri.label', default: 'Uri')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${rueckUriInstanceList}" status="i" var="rueckUriInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${rueckUriInstance.id}">${fieldValue(bean: rueckUriInstance, field: "anwendung")}</g:link></td>
					
						<td>${fieldValue(bean: rueckUriInstance, field: "uri")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${rueckUriInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
