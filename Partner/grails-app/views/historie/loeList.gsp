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
				<li><g:link class="list" controller="${flash.domName}" action="list"><g:message code="default.list.label" args="[flash.domName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-historie" class="content scaffold-list" role="main">
			<h1><g:message code="default.domLoe.label" args="[flash.domName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th>Feldnamen</th>
						
						<th>Inhalte</th>
						
						<th>gelöscht von</th>
					
						<th>am</th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${historieInstanceList}" status="i" var="historieInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link class="list" controller="historie" action="domList" params="[domId:historieInstance?.domainId,domName:flash.domName]">${fieldValue(bean: historieInstance, field: "feldName")}</g:link></td>
						
						<td>${fieldValue(bean: historieInstance, field: "stringInhalt")}</td>
						
						<td>${fieldValue(bean: historieInstance, field: "userName")}</td>
					
						<td><g:formatDate date="${historieInstance.gueAb}" /></td>					
						
					
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