<%@ page import="org.strotmann.partner.Lieferadresse" %>
<table border="1" style="width:100%">
<caption><b><g:message code="organisation.lieferadresse.label"/></b></caption>

<tr>
	<th><g:message code="hausadresse.strasse.label"/></th>
	<th><g:message code="hausadresse.hausnummer.label"/> </th>
	<th><g:message code="hausadresse.zusatz.label"/></th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'strasse', 'error')}">
	<g:textField name="strasse" maxlength="50" pattern="${lieferadresseInstance.constraints.strasse.matches}" value="${lieferadresseInstance?.strasse}"/>
	</td>
	<td class="fieldcontain  ${hasErrors(bean: lieferadresseInstance, field: 'hausnummer', 'error')}">
	<g:field name="hausnummer" type="number" min="0" max="99999" value="${lieferadresseInstance.hausnummer}" />
	</td>
	<td class="fieldcontain  ${hasErrors(bean: lieferadresseInstance, field: 'zusatz', 'error')}">
	<g:textField name="zusatz" maxlength="10" value="${lieferadresseInstance?.zusatz}"/>
	</td>
</tr>

<tr>
	<th><g:message code="hausadresse.postleitzahl.label"/></th>
	<th><g:message code="hausadresse.ort.label"/> </th>
	<th><g:message code="hausadresse.land.label"/> </th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'postleitzahl', 'error')} ">
	<g:field name="postleitzahl" type="number"  min="0" max="99999" value="${lieferadresseInstance.postleitzahl}" />
	</td>
	<td class="fieldcontain  ${hasErrors(bean: lieferadresseInstance, field: 'ort', 'error')} ">
	<g:textField name="ort" maxlength="50" pattern="${lieferadresseInstance.constraints.ort.matches}" value="${lieferadresseInstance?.ort}"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'land', 'error')}">
	<g:select id="land" name="land.id" from="${org.strotmann.partner.Land.list()}" optionKey="id" value="${lieferadresseInstance?.land?.id}" class="many-to-one" noSelection="['null': '']"/>
	</td>
</tr>

<tr>
	<g:set var="labelName" value="${message(code: 'organisation.lieferadresse.label')}" />
	<th><g:message code="default.auswaehlen.label" args="[labelName]"/></th>
</tr>

<tr>
	<td class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'lieferadresse', 'error')}">
	<g:select id="lieferadresse" name="lieferadresse.id" from="${Lieferadresse.list()}" optionKey="id" value="${personInstance?.lieferadresse?.id}" class="many-to-one" noSelection="['null': '']"/>
	</td>
</tr>

<tr>
	<th><g:message code="lieferadresse.anfahrt.label"/> </th>
</tr>

<tr>
	<td class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'anfahrt', 'error')} ">
	<g:textArea name="anfahrt" value="${lieferadresseInstance?.anfahrt}" rows="5" cols="80"/>
	</td>
</tr>

</table>


