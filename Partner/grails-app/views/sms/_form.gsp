<%@ page import="org.strotmann.mail.Sms" %>



<div class="fieldcontain ${hasErrors(bean: smsInstance, field: 'inhalt', 'error')} required">
	<label for="inhalt">
		<g:message code="sms.inhalt.label" default="Inhalt" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="inhalt" required="" value="${smsInstance?.inhalt}" rows="2" cols="80"/>

</div>

<div class="fieldcontain ${hasErrors(bean: smsInstance, field: 'empfaenger', 'error')} required">
	<label for="empfaenger">
		<g:message code="sms.empfaenger.label" default="Empfaenger" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.mailTo}">
		<g:field type="text" name="empfaenger" required="" value="${flash.mailTo}"/>
	</g:if>
	<g:else>
		<g:field type="number" name="empfaenger" required="" value="${smsInstance?.empfaenger}"/>
	</g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: smsInstance, field: 'datum', 'error')} required">
	<label for="datum">
		<g:message code="sms.datum.label" default="Datum" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="datum" value="${smsInstance?.datum}" default="${new Date()}" />

</div>

