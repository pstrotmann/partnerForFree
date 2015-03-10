
<%@ page import="org.strotmann.benutzer.Benutzer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'benutzer.label', default: 'Benutzer')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-benutzer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-benutzer" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'benutzer.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="passwort" title="${message(code: 'benutzer.passwort.label', default: 'Passwort')}" />
					
						<g:sortableColumn property="sprache" title="${message(code: 'benutzer.sprache.label', default: 'Sprache')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${benutzerInstanceList}" status="i" var="benutzerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${benutzerInstance.id}">${fieldValue(bean: benutzerInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: benutzerInstance, field: "passwort")}</td>
					
						<td>${fieldValue(bean: benutzerInstance, field: "sprache")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${benutzerInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
