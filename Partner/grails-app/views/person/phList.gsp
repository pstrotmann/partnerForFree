
<%@ page import="org.strotmann.partner.Person" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: "/menu", params: [lang: session.user.sprache])}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-person" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:form method="put" action="join">
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'person.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="vorname" title="${message(code: 'person.vorname.label', default: 'Vorname')}" />
					
						<g:sortableColumn property="geschlecht" title="${message(code: 'person.geschlecht.label', default: 'Geschlecht')}" />
					
						<g:sortableColumn property="geburtsdatum" title="${message(code: 'person.geburtsdatum.label', default: 'Geburtsdatum')}" />
						
						<g:sortableColumn property="hausadresse" title="${message(code: 'person.hausadresse.label', default: 'Hausadresse')}" />
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${personInstanceList}" status="i" var="personInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${personInstance.id}">${fieldValue(bean: personInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: personInstance, field: "vorname")}</td>
					
						<td>${fieldValue(bean: personInstance, field: "geschlecht")}</td>
					
						<td><g:formatDate date="${personInstance.geburtsdatum}" format="dd.MM.yyyy"/></td>
						
						<td>${fieldValue(bean: personInstance, field: "hausadresse")}</td>
						
						<td><g:checkBox name="personInstanceList[${i}].checked"  /></td>
					
					</tr>
				</g:each>
				
			
				</tbody>
			</table>
			
			<fieldset class="buttons">
				<g:actionSubmit class="save" action="join" value="${message(code: 'default.button.merge.label', default: 'Join')}" />
			</fieldset>
			
		</g:form>
		</div>
	</body>
</html>