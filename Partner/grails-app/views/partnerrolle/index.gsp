
<%@ page import="org.strotmann.partner.Partnerrolle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'partnerrolle.label', default: 'Partnerrolle')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-partnerrolle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-partnerrolle" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="rolle" title="${message(code: 'partnerrolle.rolle.label', default: 'Rolle')}" />
					
						<g:sortableColumn property="objektname" title="${message(code: 'partnerrolle.objektname.label', default: 'Objektname')}" />
					
						<g:sortableColumn property="objektId" title="${message(code: 'partnerrolle.objektId.label', default: 'Objekt Id')}" />
					
						<th><g:message code="partnerrolle.partner.label" default="Partner" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${partnerrolleInstanceList}" status="i" var="partnerrolleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${partnerrolleInstance.id}">${fieldValue(bean: partnerrolleInstance, field: "rolle")}</g:link></td>
					
						<td>${fieldValue(bean: partnerrolleInstance, field: "objektname")}</td>
					
						<td>${fieldValue(bean: partnerrolleInstance, field: "objektId")}</td>
					
						<td>${fieldValue(bean: partnerrolleInstance, field: "partner")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${partnerrolleInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
