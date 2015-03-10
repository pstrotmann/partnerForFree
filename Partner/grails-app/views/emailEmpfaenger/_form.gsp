<%@ page import="org.strotmann.mail.EmailEmpfaenger" %>



<div class="fieldcontain ${hasErrors(bean: emailEmpfaengerInstance, field: 'emailAdresse', 'error')} required">
	<label for="emailAdresse">
		<g:message code="emailEmpfaenger.emailAdresse.label" default="Email Adresse" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="emailAdresse" required="" value="${emailEmpfaengerInstance?.emailAdresse}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: emailEmpfaengerInstance, field: 'eMail', 'error')} required">
	<label for="eMail">
		<g:message code="emailEmpfaenger.eMail.label" default="E Mail" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="eMail" name="eMail.id" from="${org.strotmann.mail.Email.list()}" optionKey="id" required="" value="${emailEmpfaengerInstance?.eMail?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: emailEmpfaengerInstance, field: 'partner', 'error')} required">
	<label for="partner">
		<g:message code="emailEmpfaenger.partner.label" default="Partner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="partner" name="partner.id" from="${org.strotmann.partner.Partner.list()}" optionKey="id" required="" value="${emailEmpfaengerInstance?.partner?.id}" class="many-to-one"/>

</div>

