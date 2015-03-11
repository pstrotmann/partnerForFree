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
	<g:if test="${flash.email}">
		<g:select id="eMail" name="eMail.id" from="${flash.email}" optionKey="id" required="" value="${emailEmpfaengerInstance?.eMail?.id}" class="many-to-one"/>
	</g:if>
	<g:else>
		<g:select id="eMail" name="eMail.id" from="${org.strotmann.mail.Email.list()}" optionKey="id" required="" value="${emailEmpfaengerInstance?.eMail?.id}" class="many-to-one"/>
	</g:else>
</div>


