<%@ page import="org.strotmann.partner.RueckUri" %>



<div class="fieldcontain ${hasErrors(bean: rueckUriInstance, field: 'anwendung', 'error')} required">
	<label for="anwendung">
		<g:message code="rueckUri.anwendung.label" default="Anwendung" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="anwendung" required="" value="${rueckUriInstance?.anwendung}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rueckUriInstance, field: 'uri', 'error')} required">
	<label for="uri">
		<g:message code="rueckUri.uri.label" default="Uri" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="uri" required="" value="${rueckUriInstance?.uri}"/>

</div>

