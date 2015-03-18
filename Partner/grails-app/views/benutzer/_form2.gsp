<%@ page import="org.strotmann.benutzer.Benutzer" %>



<div class="fieldcontain ${hasErrors(bean: benutzerInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="benutzer.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${benutzerInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: benutzerInstance, field: 'passwort', 'error')} required">
	<label for="passwort">
		<g:message code="benutzer.passwort.label" default="Passwort" />
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField name="passwort" required="" value="${benutzerInstance?.passwort}"/>

</div>


