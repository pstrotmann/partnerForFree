<%@ page import="org.strotmann.partner.Historie" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'historie.label', default: 'Historie')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-historie" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<g:if test="${flash.dom}">
					<li><g:link controller="${flash.domName}" action="show" id="${flash.domId}"><g:message code="default.akt.label" args="[flash.domName]"/></g:link></li>
				</g:if>
				<g:else>
					<li><g:link class="create" controller="historie" action="loeList" params="[domName:flash.domName]"><g:message code="default.loe.label" args="[flash.domName]"/></g:link></li>
				</g:else>
			</ul>
		</div>
		<div id="list-historie" class="content scaffold-list" role="main">
			<h1><g:message code="default.histo.label" args="[flash.domName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th>erfasst durch</th>
					
						<th>gültig ab</th>
						
						<th>gültig bis</th>
					
						<th>Feldname</th>
					
						<th>Feldinhalt</th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${historieInstanceList}" status="i" var="historieInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${historieInstance.id}">${fieldValue(bean: historieInstance, field: "userName")}</g:link></td>
					
						<td><g:formatDate date="${historieInstance.gueAb}" /></td>
						
						<td><g:formatDate date="${historieInstance.gueBis}" /></td>
											
						<td>${fieldValue(bean: historieInstance, field: "feldName")}</td>
					
						<td>${fieldValue(bean: historieInstance, field: "feldinhalt")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${historieInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>