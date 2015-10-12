
<%@ page import="org.strotmann.partner.Lastschriftmandat" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lastschriftmandat.label', default: 'Lastschriftmandat')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-lastschriftmandat" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-lastschriftmandat" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="mandatsReferenz" title="${message(code: 'lastschriftmandat.mandatsReferenz.label', default: 'Mandats Referenz')}" />
						
						<g:sortableColumn property="mandatTyp" title="${message(code: 'lastschriftmandat.mandatTyp.label', default: 'Typ')}" />
						
						<th><g:message code="lastschriftmandat.abweichenderSchuldner.label" default="Schuldner" /></th>
						
						<th><g:message code="lastschriftmandat.glaeubiger.label" default="Glaeubiger" /></th>
					
						<th><g:message code="lastschriftmandat.glaeubigerId.label" default="Id" /></th>
					
						<g:sortableColumn property="gueltigAb" title="${message(code: 'lastschriftmandat.gueltigAb.label', default: 'Gueltig Ab')}" />
					
						<g:sortableColumn property="gueltigBis" title="${message(code: 'lastschriftmandat.gueltigBis.label', default: 'Gueltig Bis')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${lastschriftmandatInstanceList}" status="i" var="lastschriftmandatInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${lastschriftmandatInstance.id}">${fieldValue(bean: lastschriftmandatInstance, field: "mandatsReferenz")}</g:link></td>
					
						<td>${fieldValue(bean: lastschriftmandatInstance, field: "mandatTypKlar")}</td>
						
						<td>${fieldValue(bean: lastschriftmandatInstance, field: "schuldner")}</td>
						
						<td>${fieldValue(bean: lastschriftmandatInstance, field: "glaeubiger")}</td>
					
						<td>${fieldValue(bean: lastschriftmandatInstance, field: "glaeubiger.glaeubigerId")}</td>
					
						<td><g:formatDate date="${lastschriftmandatInstance.gueltigAb}" format="dd.MM.yyyy"/></td>
					
						<td><g:formatDate date="${lastschriftmandatInstance.gueltigBis}" format="dd.MM.yyyy"/></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${lastschriftmandatInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
