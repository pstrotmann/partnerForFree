<%@ page import="org.strotmann.partner.Bankverbindung" %>

<table border="1" style="width:100%">
<caption><b><g:message code="person.bankverbindung.label"/></b></caption>
<tr>
	<th><g:message code="bankverbindung.iban.label"/></th>
	<th><g:message code="bankverbindung.bic.label"/></th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: bankverbindungInstance, field: 'iban', 'error')}">
	<g:textField name="iban" value="${bankverbindungInstance?.iban}"/>
	</td>
	<td class="fieldcontain ${hasErrors(bean: bankverbindungInstance, field: 'BIC', 'error')}">
	<g:textField name="bic" value="${bankverbindungInstance?.bic}"/>
	</td>
</tr>
</table>