
<%@ page import="org.strotmann.mail.EmailAnhang" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'emailAnhang.label', default: 'EmailAnhang')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-emailAnhang" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-emailAnhang" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list emailAnhang">
			
				<g:if test="${emailAnhangInstance?.dateiname}">
				<li class="fieldcontain">
					<span id="dateiname-label" class="property-label"><g:message code="emailAnhang.dateiname.label" default="Dateiname" /></span>
					
						<span class="property-value" aria-labelledby="dateiname-label"><g:fieldValue bean="${emailAnhangInstance}" field="dateiname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${emailAnhangInstance?.eMail}">
				<li class="fieldcontain">
					<span id="eMail-label" class="property-label"><g:message code="emailAnhang.eMail.label" default="E Mail" /></span>
					
						<span class="property-value" aria-labelledby="eMail-label"><g:link controller="email" action="show" id="${emailAnhangInstance?.eMail?.id}">${emailAnhangInstance?.eMail?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:emailAnhangInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${emailAnhangInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
