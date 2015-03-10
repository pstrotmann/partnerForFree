
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
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-historie" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="userName" title="${message(code: 'historie.userName.label', default: 'User Name')}" />
					
						<g:sortableColumn property="gueAb" title="${message(code: 'historie.gueAb.label', default: 'Gue Ab')}" />
					
						<g:sortableColumn property="domainName" title="${message(code: 'historie.domainName.label', default: 'Domain Name')}" />
					
						<g:sortableColumn property="domainId" title="${message(code: 'historie.domainId.label', default: 'Domain Id')}" />
					
						<g:sortableColumn property="feldName" title="${message(code: 'historie.feldName.label', default: 'Feld Name')}" />
					
						<g:sortableColumn property="stringInhalt" title="${message(code: 'historie.stringInhalt.label', default: 'String Inhalt')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${historieInstanceList}" status="i" var="historieInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${historieInstance.id}">${fieldValue(bean: historieInstance, field: "userName")}</g:link></td>
					
						<td><g:formatDate date="${historieInstance.gueAb}" /></td>
					
						<td>${fieldValue(bean: historieInstance, field: "domainName")}</td>
					
						<td>${fieldValue(bean: historieInstance, field: "domainId")}</td>
					
						<td>${fieldValue(bean: historieInstance, field: "feldName")}</td>
					
						<td>${fieldValue(bean: historieInstance, field: "stringInhalt")}</td>
					
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
