<%@ page import="org.strotmann.notiz.Notiz" %>

<table border="1" style="width:100%">
<caption><b><g:message code="entity.notiz"/></b></caption>
<tr>
	<th><g:message code="notiz.text.label"/></th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: notizInstance, field: 'notiztext', 'error')}">
	<g:textArea name="notiztext" value="${notizInstance?.notiztext}" rows="2" cols="80"/>
	</td>
</tr>
</table>