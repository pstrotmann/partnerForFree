<%@ page import="org.strotmann.mail.EmailAnhang" %>



<div class="fieldcontain ${hasErrors(bean: emailAnhangInstance, field: 'datei', 'error')} required">
	<label for="datei">
		<g:message code="emailAnhang.datei.label" default="Datei" />
		<span class="required-indicator">*</span>
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: emailAnhangInstance, field: 'eMail', 'error')} required">
	<label for="eMail">
		<g:message code="emailAnhang.eMail.label" default="E Mail" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="eMail" name="eMail.id" from="${org.strotmann.mail.Email.list()}" optionKey="id" required="" value="${emailAnhangInstance?.eMail?.id}" class="many-to-one"/>

</div>