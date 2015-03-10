<%@ page import="org.strotmann.mail.EmailEmpfaenger" %>

<div class="fieldcontain ${hasErrors(bean: emailEmpfaengerInstance, field: 'emailAdresse', 'error')} required">
	<label for="emailAdresse">
		<g:message code="emailEmpfaenger.emailAdresse.label" default="An" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.mailTo}">
		<g:field type="email" name="emailAdresse" required="" value="${flash.mailTo}"/>
	</g:if>
	<g:else>
		<g:field type="email" name="emailAdresse" required="" value="${emailEmpfaengerInstance?.emailAdresse}"/>
	</g:else>
	
	<g:if test="${flash.partner}">
		<g:select id="partner" name="partner.id" from="${flash.partner}" optionKey="id" required="" value="${emailEmpfaengerInstance?.partner?.id}" class="many-to-one"/>
	</g:if>
	<g:else>
		<g:select id="partner" name="partner.id" from="${org.strotmann.partner.Partner.list()}" optionKey="id" required="" value="${emailEmpfaengerInstance?.partner?.id}" class="many-to-one"/>
	</g:else>
</div>