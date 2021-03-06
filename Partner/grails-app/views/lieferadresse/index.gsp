
<%@ page import="org.strotmann.partner.Lieferadresse" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lieferadresse.label', default: 'Lieferadresse')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-lieferadresse" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-lieferadresse" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="strasse" title="${message(code: 'lieferadresse.strasse.label', default: 'Strasse')}" />
					
						<g:sortableColumn property="hausnummer" title="${message(code: 'lieferadresse.hausnummer.label', default: 'Hausnummer')}" />
					
						<g:sortableColumn property="zusatz" title="${message(code: 'lieferadresse.zusatz.label', default: 'Zusatz')}" />
					
						<g:sortableColumn property="postleitzahl" title="${message(code: 'lieferadresse.postleitzahl.label', default: 'Postleitzahl')}" />
					
						<g:sortableColumn property="ort" title="${message(code: 'lieferadresse.ort.label', default: 'Ort')}" />
					
						<th><g:message code="lieferadresse.land.label" default="Land" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${lieferadresseInstanceList}" status="i" var="lieferadresseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${lieferadresseInstance.id}">${fieldValue(bean: lieferadresseInstance, field: "strasse")}</g:link></td>
					
						<td>${fieldValue(bean: lieferadresseInstance, field: "hausnummer")}</td>
					
						<td>${fieldValue(bean: lieferadresseInstance, field: "zusatz")}</td>
					
						<td>${fieldValue(bean: lieferadresseInstance, field: "postleitzahl")}</td>
					
						<td>${fieldValue(bean: lieferadresseInstance, field: "ort")}</td>
					
						<td>${fieldValue(bean: lieferadresseInstance, field: "land")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${lieferadresseInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
