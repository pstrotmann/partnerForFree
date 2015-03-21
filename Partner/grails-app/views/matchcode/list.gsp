
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
				<li><g:link class="create" action="create"><g:message code="default.matchcode.label" args="[entityName]" /></g:link></li>
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
						<g:sortableColumn property="name" title="${message(code: 'partner.name.label')}" />
					
						<g:sortableColumn property="vorname" title="${message(code: 'person.vorname.label')}" />
						
						<g:sortableColumn property="strasse" title="${message(code: 'hausadresse.strasse.label')}" />
						
						<g:sortableColumn property="postleitzahl" title="${message(code: 'hausadresse.postleitzahl.label')}" />
						
						<g:sortableColumn property="ort" title="${message(code: 'hausadresse.ort.label')}" />
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${matchcodeInstanceList}" status="i" var="matchcodeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>
						<g:if test="${matchcodeInstance.partnerart == 'p'}">
						<g:link controller="person" action="show" id="${matchcodeInstance.id}">${fieldValue(bean: matchcodeInstance, field: "name")}</g:link>
						</g:if>
						<g:if test="${matchcodeInstance.partnerart == 'o'}">
						<g:link controller="organisation" action="show" id="${matchcodeInstance.id}">${fieldValue(bean: matchcodeInstance, field: "name")}</g:link>
						</g:if>
						</td>
					
						<td>${fieldValue(bean: matchcodeInstance, field: "vorname")}</td>
						
						<td>${fieldValue(bean: matchcodeInstance, field: "strasse")}</td>
						
						<g:if test="${matchcodeInstance.postleitzahl == 0}">
							<td></td>
						</g:if>
						<g:else>
							<td>${fieldValue(bean: matchcodeInstance, field: "postleitzahl")}</td>
						</g:else>
						
						<td>${fieldValue(bean: matchcodeInstance, field: "ort")}</td>
												
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${matchcodeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
