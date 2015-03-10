<%@ page import="org.strotmann.partner.Person" %>
<%@ page import="org.strotmann.partner.Branche" %>

<table border="1" style="width:100%">
<caption><b><g:message code="person.personalData.label"/></b> </caption>
<tr>
	<th><g:message code="person.name.label"/></th>
	<th><g:message code="person.vorname.label"/></th>
	<th><g:message code="person.titel.label"/></th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: personInstance, field: 'name', 'error')}">
	<g:textField name="name" maxlength="30" pattern="${personInstance.constraints.name.matches}" required="" value="${personInstance?.name}"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: personInstance, field: 'vorname', 'error')}">
	<g:textField name="vorname" maxlength="30" pattern="${personInstance.constraints.vorname.matches}" value="${personInstance?.vorname}"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: personInstance, field: 'titel', 'error')}">
	<g:textField name="titel" maxlength="20" pattern="${personInstance.constraints.titel.matches}" value="${personInstance?.titel}"/>
	</td>
</tr>
<tr>
	<th><g:message code="person.geschlecht.label"/></th>
	<th><g:message code="person.geburtsdatum.label"/></th>
	<th><g:message code="person.persoenlicheAnrede.label"/></th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: personInstance, field: 'geschlecht', 'error')}">
	<g:select name="geschlecht" from="${personInstance.constraints.geschlecht.inList}" required="" value="${personInstance?.geschlecht}" valueMessagePrefix="person.geschlecht" noSelection="['': '']"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: personInstance, field: 'geburtsdatum', 'error')}">
	<g:datePicker name="geburtsdatum" precision="day" years="${1920..2020}" value="${personInstance?.geburtsdatum}" default="none" noSelection="['': '']" />
	</td>
	<td class="fieldcontain ${hasErrors(bean: personInstance, field: 'persoenlicheAnrede', 'error')}">
	<g:checkBox name="persoenlicheAnrede" value="${personInstance?.persoenlicheAnrede}"/>
	</td>
</tr>
<tr>
	<th><g:message code="person.nationalitaet.label"/></th>
	<th><g:message code="person.religion.label"/></th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: personInstance, field: 'nationalitaet', 'error')}">
	<g:select id="nationalitaet" name="nationalitaet.id" from="${org.strotmann.partner.Land.list()}" optionKey="id" value="${personInstance?.nationalitaet?.id}" class="many-to-one" noSelection="['null': '']"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: personInstance, field: 'religion', 'error')}">
	<g:select name="religion" from="${personInstance.constraints.religion.inList}" value="${personInstance?.religion}" valueMessagePrefix="person.religion" noSelection="['': '']"/>
	</td>
	
</tr>
<tr>
	<th><g:message code="person.beruf.label"/></th>
	<th><g:message code="person.taetigkeit.label"/></th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: personInstance, field: 'beruf', 'error')}">
	<g:select id="beruf" name="beruf.id" from="${Branche.branchenKurz(35)}" optionKey="id" value="${personInstance?.beruf?.id}" class="many-to-one" noSelection="['null': '']"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: personInstance, field: 'Tätigkeit', 'error')}">
	<g:select id="taetigkeit" name="taetigkeit.id" from="${Branche.branchenKurz(35)}" optionKey="id" value="${personInstance?.taetigkeit?.id}" class="many-to-one" noSelection="['null': '']"/>
	</td>
</tr>

</table>