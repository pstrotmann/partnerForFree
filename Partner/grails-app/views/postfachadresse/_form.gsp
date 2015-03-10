<%@ page import="org.strotmann.partner.Postfachadresse" %>



<div class="fieldcontain ${hasErrors(bean: postfachadresseInstance, field: 'postfach', 'error')} required">
	<label for="postfach">
		<g:message code="postfachadresse.postfach.label" default="Postfach" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="postfach" type="number" value="${postfachadresseInstance.postfach}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: postfachadresseInstance, field: 'postleitzahl', 'error')} required">
	<label for="postleitzahl">
		<g:message code="postfachadresse.postleitzahl.label" default="Postleitzahl" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="postleitzahl" type="number" min="1000" max="99999" value="${postfachadresseInstance.postleitzahl}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: postfachadresseInstance, field: 'ort', 'error')} required">
	<label for="ort">
		<g:message code="postfachadresse.ort.label" default="Ort" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ort" required="" value="${postfachadresseInstance?.ort}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: postfachadresseInstance, field: 'partner', 'error')} required">
	<label for="partner">
		<g:message code="postfachadresse.partner.label" default="Partner" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.partner}">
		<g:select id="partner" name="partner.id" from="${flash.partner}" optionKey="id" required="" value="${postfachadresseInstance?.partner?.id}" class="many-to-one"/>
	</g:if>
	<g:else>
		<g:select id="partner" name="partner.id" from="${org.strotmann.partner.Partner.list()}" optionKey="id" required="" value="${postfachadresseInstance?.partner?.id}" class="many-to-one"/>
	</g:else>
</div>

