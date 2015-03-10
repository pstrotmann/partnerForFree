
<%@ page import="org.strotmann.mail.EmailAnhang" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'emailAnhang.label', default: 'EmailAnhang')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-emailAnhang" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-emailAnhang" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="datei" title="${message(code: 'emailAnhang.datei.label', default: 'Datei')}" />
					
						<th><g:message code="emailAnhang.eMail.label" default="E Mail" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${emailAnhangInstanceList}" status="i" var="emailAnhangInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${emailAnhangInstance.id}">${fieldValue(bean: emailAnhangInstance, field: "datei")}</g:link></td>
					
						<td>${fieldValue(bean: emailAnhangInstance, field: "eMail")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${emailAnhangInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
