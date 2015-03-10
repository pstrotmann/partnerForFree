<%@ page import="org.strotmann.partner.Hausadresse" %>
<%@ page import="org.strotmann.partner.Land" %>
<table border="1" style="width:100%">
<caption><b><g:message code="person.hausadresse.label"/></b></caption>

<tr>
	<th><g:message code="hausadresse.strasse.label"/></th>
	<th><g:message code="hausadresse.hausnummer.label"/> </th>
	<th><g:message code="hausadresse.zusatz.label"/></th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'strasse', 'error')}">
	<g:textField name="strasse" maxlength="50" pattern="${hausadresseInstance.constraints.strasse.matches}" value="${hausadresseInstance?.strasse}"/>
	</td>
	<td class="fieldcontain  ${hasErrors(bean: hausadresseInstance, field: 'hausnummer', 'error')}">
	<g:field name="hausnummer" type="number" min="0" max="99999" value="${hausadresseInstance.hausnummer}" />
	</td>
	<td class="fieldcontain  ${hasErrors(bean: hausadresseInstance, field: 'zusatz', 'error')}">
	<g:textField name="zusatz" maxlength="10" value="${hausadresseInstance?.zusatz}"/>
	</td>
</tr>

<tr>
	<th><g:message code="hausadresse.postleitzahl.label"/></th>
	<th><g:message code="hausadresse.ort.label" default="Ort" /> </th>
	<th><g:message code="hausadresse.land.label" default="Land" /> </th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'postleitzahl', 'error')} ">
	<g:field name="postleitzahl" type="number"  min="0" max="99999" value="${hausadresseInstance.postleitzahl}" />
	</td>
	<td class="fieldcontain  ${hasErrors(bean: hausadresseInstance, field: 'ort', 'error')} ">
	<g:textField name="ort" maxlength="50" pattern="${hausadresseInstance.constraints.ort.matches}" value="${hausadresseInstance?.ort}"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'land', 'error')}">
	<g:select id="land" name="land.id" from="${org.strotmann.partner.Land.list()}" optionKey="id" value="${hausadresseInstance?.land?.id}" class="many-to-one" noSelection="['null': '']"/>
	</td>
</tr>

<tr>
	<g:set var="labelName" value="${message(code: 'person.hausadresse.label')}" />
	<th><g:message code="default.auswaehlen.label" args="[labelName]"/></th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'hausadresse', 'error')}">
	<g:select id="hausadresse" name="hausadresse.id" from="${org.strotmann.partner.Hausadresse.getMiniList()}" optionKey="id" value="${personInstance?.hausadresse?.id}" class="many-to-one" noSelection="['null': '']"/>
	</td>
</tr>

</table>

