<%@ page import="org.strotmann.partner.Bankverbindung" %>

<div class="fieldcontain ${hasErrors(bean: bankverbindungInstance, field: 'iban', 'error')} ">
	<label for="iban">
		<g:message code="bankverbindung.iban.label" default="Iban" />
		
	</label>
	<g:textField name="iban" value="${bankverbindungInstance?.iban}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankverbindungInstance, field: 'bic', 'error')} ">
	<label for="bic">
		<g:message code="bankverbindung.bic.label" default="BIC" />
		
	</label>
	<g:textField name="bic" value="${bankverbindungInstance?.bic}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bankverbindungInstance, field: 'partner', 'error')} required">
	<label for="partner">
		<g:message code="bankverbindung.partner.label" default="Partner" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.partner}">
		<g:select id="partner" name="partner.id" from="${flash.partner}" optionKey="id" required="" value="${bankverbindungInstance?.partner?.id}" class="many-to-one"/>
	</g:if>
	<g:else>
		<g:select id="partner" name="partner.id" from="${org.strotmann.partner.Partner.list()}" optionKey="id" required="" value="${bankverbindungInstance?.partner?.id}" class="many-to-one"/>
	</g:else>
</div>

<div class="fieldcontain ${hasErrors(bean: bankverbindungInstance, field: 'lastschriftmandat', 'error')} ">
	<label for="lastschriftmandate">
		<g:message code="bankverbindung.lastschriftmandate.label"/>
		
	</label>
	
<ul class="one-to-many">
<g:each in="${bankverbindungInstance?.lastschriftmandate?}" var="l">
    <li><g:link controller="lastschriftmandat" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="lastschriftmandat" action="create" params="['bankverbindung.id': bankverbindungInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'lastschriftmandat.label', default: 'Lastschriftmandat')])}</g:link>
</li>
</ul>

</div>

