<%@ page import="org.strotmann.mail.Email" %>

<div class="fieldcontain ${hasErrors(bean: emailInstance, field: 'sender', 'error')} required">
	<label for="sender">
		<g:message code="email.sender.label" default="Von" />
	</label>
	
	<g:field type="email" name="sender" required="" value="${flash.mailFrom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: emailInstance, field: 'emailBetreff', 'error')} required">
	<label for="emailBetreff">
		<g:message code="email.emailBetreff.label" default="Betreff" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="emailBetreff" required="" value="${emailInstance?.emailBetreff}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: emailInstance, field: 'emailText', 'error')} required">
	<label for="emailText">
		<g:message code="email.emailText.label" default="Text" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="emailText" required="" value="${emailInstance?.emailText}" rows="2" cols="80"/>

</div>

<div class="fieldcontain ${hasErrors(bean: emailInstance, field: 'gesendet', 'error')} required">
	<label for="gesendet">
		<g:message code="email.send.label" default="Senden" />
		<span class="required-indicator">*</span>
	</label>
	<g:checkBox name="gesendet" value="${false}" />

</div>
