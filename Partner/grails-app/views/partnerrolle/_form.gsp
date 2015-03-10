<%@ page import="org.strotmann.partner.Partnerrolle" %>



<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'rolle', 'error')} required">
	<label for="rolle">
		<g:message code="partnerrolle.rolle.label" default="Rolle" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="rolle" from="${[flash.rolle]}" required="" value="${partnerrolleInstance?.rolle}" valueMessagePrefix="partnerrolle.rolle"/>
</div>

<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'objektname', 'error')} required">
	<label for="objektname">
		<g:message code="partnerrolle.objektname.label" default="Objektname" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="objektname" from="${[flash.objektname]}" required="" value="${partnerrolleInstance?.objektname}" valueMessagePrefix="partnerrolle.objektname"/>

</div>

<g:if test="${flash.objektname == 'Organisation'}">
<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'organisation', 'error')} ">
	<label for="organisation">
		<g:message code="partnerrolle.organisation.label" default="Organisation" />
		
	</label>
	<g:select id="organisation" name="organisation.id" from="${org.strotmann.partner.Organisation.getMiniList()}" optionKey="id" value="${partnerrolleInstance?.objektId}" class="many-to-one" noSelection="['null': '']"/>
</div>
</g:if>

<g:if test="${flash.objektname == 'Person'}">
<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'person', 'error')} ">
	<label for="organisation">
		<g:message code="partnerrolle.person.label" default="Person" />
		
	</label>
	<g:select id="person" name="person.id" from="${org.strotmann.partner.Person.personList}" optionKey="id" value="${partnerrolleInstance?.objektId}" class="many-to-one" noSelection="['null': '']"/>
</div>
</g:if>

<div class="fieldcontain ${hasErrors(bean: partnerrolleInstance, field: 'partner', 'error')} required">
	<label for="partner">
		<g:message code="partnerrolle.partner.label" default="Partner" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="partner" name="partner.id" from="${flash.partner}" optionKey="id" required="" value="${partnerrolleInstance?.partner?.id}" class="many-to-one"/>

</div>

