
<%@ page import="org.strotmann.partner.Lastschriftmandat" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lastschriftmandat.label', default: 'Lastschriftmandat')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		<style>
		a.cupid-blue {
		  background-color: #d7e5f5;
		  background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #d7e5f5), color-stop(100%, #cbe0f5));
		  background-image: -webkit-linear-gradient(top, #d7e5f5, #cbe0f5);
		  background-image: -moz-linear-gradient(top, #d7e5f5, #cbe0f5);
		  background-image: -ms-linear-gradient(top, #d7e5f5, #cbe0f5);
		  background-image: -o-linear-gradient(top, #d7e5f5, #cbe0f5);
		  background-image: linear-gradient(top, #d7e5f5, #cbe0f5);
		  border-top: 1px solid #abbbcc;
		  border-left: 1px solid #a7b6c7;
		  border-bottom: 1px solid #a1afbf;
		  border-right: 1px solid #a7b6c7;
		  border-radius: 12px;
		  -webkit-box-shadow: inset 0 1px 0 0 white;
		  box-shadow: inset 0 1px 0 0 white;
		  text-decoration: none;
		  color: #1a3e66;
		  font: normal 11px/1 "Lucida Grande", "Lucida Sans Unicode", "Lucida Sans", Geneva, Verdana, sans-serif;
		  padding: 6px 10px 7px 10px;
		  text-align: center;
		  text-shadow: 0 1px 1px #fff;
		  width: 150px; }
		a.cupid-blue:hover {
		    background-color: #ccd9e8;
		    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #ccd9e8), color-stop(100%, #c1d4e8));
		    background-image: -webkit-linear-gradient(top, #ccd9e8, #c1d4e8);
		    background-image: -moz-linear-gradient(top, #ccd9e8, #c1d4e8);
		    background-image: -ms-linear-gradient(top, #ccd9e8, #c1d4e8);
		    background-image: -o-linear-gradient(top, #ccd9e8, #c1d4e8);
		    background-image: linear-gradient(top, #ccd9e8, #c1d4e8);
		    border-top: 1px solid #a1afbf;
		    border-left: 1px solid #9caaba;
		    border-bottom: 1px solid #96a3b3;
		    border-right: 1px solid #9caaba;
		    -webkit-box-shadow: inset 0 1px 0 0 #f2f2f2;
		    box-shadow: inset 0 1px 0 0 #f2f2f2;
		    color: #163659;
		    cursor: pointer; }
		a.cupid-blue:active {
		    border: 1px solid #8c98a7;
		    -webkit-box-shadow: inset 0 0 4px 2px #abbccf, 0 0 1px 0 #eeeeee;
		    box-shadow: inset 0 0 4px 2px #abbccf, 0 0 1px 0 #eeeeee; }
		</style>
	</head>
	<body>
		<a href="#show-lastschriftmandat" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-lastschriftmandat" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list lastschriftmandat">
			
				<g:if test="${lastschriftmandatInstance?.schuldner}">
				<li class="fieldcontain">
					<span id="schuldner-label" class="property-label"><g:message code="lastschriftmandat.schuldner.label" default="Schuldner" /></span>
					
						<span class="property-value" aria-labelledby="schuldner-label"><g:link controller="organisation" action="show" id="${lastschriftmandatInstance?.schuldner?.id}">${lastschriftmandatInstance?.schuldner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${lastschriftmandatInstance?.mandatTyp}">
				<li class="fieldcontain">
					<span id="mandatTyp-label" class="property-label"><g:message code="lastschriftmandat.mandatTyp.label" default="Mandat Typ" /></span>
					
						<span class="property-value" aria-labelledby="mandatTyp-label"><g:fieldValue bean="${lastschriftmandatInstance}" field="mandatTypKlar"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lastschriftmandatInstance?.mandatsReferenz}">
				<li class="fieldcontain">
					<span id="mandatsReferenz-label" class="property-label"><g:message code="lastschriftmandat.mandatsReferenz.label" default="Mandats Referenz" /></span>
					
						<span class="property-value" aria-labelledby="mandatsReferenz-label"><g:fieldValue bean="${lastschriftmandatInstance}" field="mandatsReferenz"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${lastschriftmandatInstance?.glaeubiger}">
				<li class="fieldcontain">
					<span id="glaeubiger-label" class="property-label"><g:message code="lastschriftmandat.glaeubiger.label" default="Glaeubiger" /></span>
					
						<span class="property-value" aria-labelledby="glaeubiger-label">
						<g:link controller="organisation" action="show" id="${lastschriftmandatInstance?.glaeubiger?.id}">
							${lastschriftmandatInstance?.glaeubiger?.encodeAsHTML()} 
							${lastschriftmandatInstance?.glaeubiger?.glaeubigerId.encodeAsHTML()}
						</g:link>
						</span>
					
				</li>
				
				</g:if>
			
				<g:if test="${lastschriftmandatInstance?.gueltigAb}">
				<li class="fieldcontain">
					<span id="gueltigAb-label" class="property-label"><g:message code="lastschriftmandat.gueltigAb.label" default="Gueltig Ab" /></span>
					
						<span class="property-value" aria-labelledby="gueltigAb-label"><g:formatDate date="${lastschriftmandatInstance?.gueltigAb}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lastschriftmandatInstance?.gueltigBis}">
				<li class="fieldcontain">
					<span id="gueltigBis-label" class="property-label"><g:message code="lastschriftmandat.gueltigBis.label" default="Gueltig Bis" /></span>
					
						<span class="property-value" aria-labelledby="gueltigBis-label"><g:formatDate date="${lastschriftmandatInstance?.gueltigBis}" format="dd.MM.yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lastschriftmandatInstance?.abweichenderSchuldner}">
				<li class="fieldcontain">
					<span id="abweichenderSchuldner-label" class="property-label"><g:message code="lastschriftmandat.abweichenderSchuldner.label" default="Abweichender Schuldner" /></span>
					
						<span class="property-value" aria-labelledby="abweichenderSchuldner-label"><g:link controller="partner" action="show" id="${lastschriftmandatInstance?.abweichenderSchuldner?.id}">${lastschriftmandatInstance?.abweichenderSchuldner?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${lastschriftmandatInstance?.bankverbindung}">
				<li class="fieldcontain">
					<span id="bankverbindung-label" class="property-label"><g:message code="lastschriftmandat.bankverbindung.label" default="Bankverbindung" /></span>
					
						<span class="property-value" aria-labelledby="bankverbindung-label"><g:link controller="bankverbindung" action="show" id="${lastschriftmandatInstance?.bankverbindung?.id}">${lastschriftmandatInstance?.bankverbindung?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:lastschriftmandatInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${lastschriftmandatInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<a id="pdf-link" class="cupid-blue" href="#pdf-link" onClick="javascript:window.open('<g:createLink action="renderFormPDF" id="${lastschriftmandatInstance?.id}"/>','_blank','width=1000, height=1200')">Drucken</a>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
