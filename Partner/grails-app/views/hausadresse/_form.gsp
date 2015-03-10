<%@ page import="org.strotmann.partner.Hausadresse" %>
<%@ page import="org.strotmann.partner.Land" %>
<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'strasse', 'error')} required">
	<label for="strasse">
		<g:message code="hausadresse.strasse.label"/>
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="strasse" maxlength="50" pattern="${hausadresseInstance.constraints.strasse.matches}" required="" value="${hausadresseInstance?.strasse}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'hausnummer', 'error')} required">
	<label for="hausnummer">
		<g:message code="hausadresse.hausnummer.label"/>
		<span class="required-indicator">*</span>
	</label>
	<g:field name="hausnummer" type="number" min="1" max="1000" value="${hausadresseInstance.hausnummer}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'zusatz', 'error')} ">
	<label for="zusatz">
		<g:message code="hausadresse.zusatz.label"/>
		
	</label>
	<g:textField name="zusatz" maxlength="10" value="${hausadresseInstance?.zusatz}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'postleitzahl', 'error')} ">
	<label for="postleitzahl">
		<g:message code="hausadresse.postleitzahl.label"/>
		<span class="required-indicator">*</span>
	</label>
	<g:field name="postleitzahl" type="number"  max="99999" value="${hausadresseInstance.postleitzahl}" />
</div>

<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'ort', 'error')} required">
	<label for="ort">
		<g:message code="hausadresse.ort.label"/>
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ort" maxlength="50" pattern="${hausadresseInstance.constraints.ort.matches}" required="" value="${hausadresseInstance?.ort}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'land', 'error')} ">
	<label for="land">
		<g:message code="hausadresse.land.label"/>
		
	</label>
	<g:select id="land" name="land.id" from="${org.strotmann.partner.Land.list()}" optionKey="id" value="${hausadresseInstance?.land?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: hausadresseInstance, field: 'partner', 'error')} required">
	<label for="partner">
		<g:message code="hausadresse.partner.label" default="Partner" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.partner}">
		<g:select id="partner" name="partner.id" from="${flash.partner}" optionKey="id" required=""  class="many-to-one"/>
	</g:if>
	<g:else>
		<g:select id="partner" name="partner.id" from="${org.strotmann.partner.Partner.list()}" optionKey="id" required=""  class="many-to-one" noSelection="['null': '']"/>
	</g:else>
</div>

