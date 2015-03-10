<%@ page import="org.strotmann.partner.Postfachadresse" %>

<table border="1" style="width:100%">
<caption><b>Postfachadresse</b></caption>

<tr>
	<th><g:message code="postfachadresse.postfach.label" default="Postfach" /></th>
	<th><g:message code="postfachadresse.postleitzahl.label" default="Postleitzahl" /></th>
	<th><g:message code="postfachadresse.ort.label" default="Ort" /> </th>
</tr>
<tr>
	<td class="fieldcontain ${hasErrors(bean: postfachadresseInstance, field: 'postfach', 'error')} ">
	<g:field name="postfach" type="number" value="${postfachadresseInstance.postfach}" />
	</td>
	<td class="fieldcontain ${hasErrors(bean: postfachadresseInstance, field: 'postleitzahl', 'error')} ">
	<g:field name="postleitzahl" type="number"  min="0" max="99999" value="${postfachadresseInstance.postleitzahl}" />
	</td>
	<td class="fieldcontain  ${hasErrors(bean: postfachadresseInstance, field: 'ort', 'error')} ">
	<g:textField name="ort" maxlength="50" pattern="${postfachadresseInstance.constraints.ort.matches}" value="${postfachadresseInstance?.ort}"/>
	</td>
</tr>

</table>