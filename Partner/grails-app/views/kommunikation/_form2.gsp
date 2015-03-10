<%@ page import="org.strotmann.partner.Kommunikation" %>

<table border="1" style="width:100%">
<caption><b><g:message code="person.kommunikationen.label"/></b></caption>
<tr>
	<th><g:message code="kommunikation.art.label" default="Art" /></th>
	<th><g:message code="kommunikation.anwahl.label" default="Anwahl" /></th>
	<th><g:message code="kommunikation.zusatz.label" default="Zusatz" /></th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: kommunikationInstance, field: 'art', 'error')}">
	<g:select name="art" from="${kommunikationInstance.constraints.art.inList}" value="${kommunikationInstance?.art}" valueMessagePrefix="kommunikation.art" noSelection="['': '']"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: kommunikationInstance, field: 'anwahl', 'error')}">
	<g:textField name="anwahl" value="${kommunikationInstance?.anwahl}"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: kommunikationInstance, field: 'zusatz', 'error')}">
	<g:textField name="zusatz" value="${kommunikationInstance?.zusatz}"/>
	</td>
</tr>
</table>
