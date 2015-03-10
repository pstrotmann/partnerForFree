
<%@ page import="org.strotmann.partner.Matchcode" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'matchcode.label', default: 'Matchcode')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-matchcode" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-matchcode" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="partnerart" title="${message(code: 'matchcode.partnerart.label', default: 'Partnerart')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'matchcode.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="geschlecht" title="${message(code: 'matchcode.geschlecht.label', default: 'Geschlecht')}" />
					
						<g:sortableColumn property="vorname" title="${message(code: 'matchcode.vorname.label', default: 'Vorname')}" />
					
						<g:sortableColumn property="strasse" title="${message(code: 'matchcode.strasse.label', default: 'Strasse')}" />
					
						<g:sortableColumn property="postleitzahl" title="${message(code: 'matchcode.postleitzahl.label', default: 'Postleitzahl')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${matchcodeInstanceList}" status="i" var="matchcodeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${matchcodeInstance.id}">${fieldValue(bean: matchcodeInstance, field: "partnerart")}</g:link></td>
					
						<td>${fieldValue(bean: matchcodeInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: matchcodeInstance, field: "geschlecht")}</td>
					
						<td>${fieldValue(bean: matchcodeInstance, field: "vorname")}</td>
					
						<td>${fieldValue(bean: matchcodeInstance, field: "strasse")}</td>
					
						<td>${fieldValue(bean: matchcodeInstance, field: "postleitzahl")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${matchcodeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
