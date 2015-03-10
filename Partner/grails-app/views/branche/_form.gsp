<%@ page import="org.strotmann.partner.Branche" %>



<div class="fieldcontain ${hasErrors(bean: brancheInstance, field: 'kode', 'error')} required">
	<label for="kode">
		<g:message code="branche.kode.label" default="Kode" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="kode" required="" value="${brancheInstance?.kode}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: brancheInstance, field: 'bezeichnung', 'error')} required">
	<label for="bezeichnung">
		<g:message code="branche.bezeichnung.label" default="Bezeichnung" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="bezeichnung" required="" value="${brancheInstance?.bezeichnung}"/>

</div>

