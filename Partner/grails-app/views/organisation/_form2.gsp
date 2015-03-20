<%@ page import="org.strotmann.partner.Organisation" %>
<%@ page import="org.strotmann.partner.Branche" %>
<table border="1" style="width:100%">
<caption><b><g:message code="organisation.data.label"/></b> </caption>
<tr>
	<th><g:message code="partner.name.label"/></th>
	<th><g:message code="organisation.nameZusatz.label"/></th>
	
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'name', 'error')}">
	<g:textField name="name" maxlength="80" pattern="${organisationInstance.constraints.name.matches}" required="" value="${organisationInstance?.name}"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'nameZusatz', 'error')}">
	<g:textField name="nameZusatz" maxlength="50" pattern="${organisationInstance.constraints.nameZusatz.matches}" value="${organisationInstance?.nameZusatz}"/>
	</td>
	
</tr>

<tr>
	<th><g:message code="organisation.rechtsform.label" default="Rechtsform" /></th>
	<th><g:message code="organisation.branche.label" default="Branche" /></th>
	
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'rechtsform', 'error')}">
	<g:select name="rechtsform" from="${organisationInstance.constraints.rechtsform.inList}" value="${organisationInstance?.rechtsform}" valueMessagePrefix="organisation.rechtsform" noSelection="['': '']"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'branche', 'error')}">
	<g:select id="branche" name="branche.id" from="${Branche.branchenKurz(65)}" optionKey="id" value="${personInstance?.branche?.id}" class="many-to-one" noSelection="['null': '']"/>
	</td>
</tr>

</table>