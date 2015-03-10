
<%@ page import="org.strotmann.partner.Kommunikation" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'kommunikation.label', default: 'Kommunikation')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-kommunikation" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-kommunikation" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="art" title="${message(code: 'kommunikation.art.label', default: 'Art')}" />
					
						<g:sortableColumn property="anwahl" title="${message(code: 'kommunikation.anwahl.label', default: 'Anwahl')}" />
						
						<g:sortableColumn property="zusatz" title="${message(code: 'kommunikation.zusatz.label', default: 'Zusatz')}" />
					
						<th><g:message code="kommunikation.partner.label" default="Partner" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${kommunikationInstanceList}" status="i" var="kommunikationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${kommunikationInstance.id}">${fieldValue(bean: kommunikationInstance, field: "art")}</g:link></td>
					
						<td>${fieldValue(bean: kommunikationInstance, field: "anwahl")}</td>
						
						<td>${fieldValue(bean: kommunikationInstance, field: "zusatz")}</td>
					
						<td>${fieldValue(bean: kommunikationInstance, field: "partner")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${kommunikationInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
