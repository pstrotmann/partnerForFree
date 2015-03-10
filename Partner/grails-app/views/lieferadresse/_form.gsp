<%@ page import="org.strotmann.partner.Lieferadresse" %>



<div class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'strasse', 'error')} ">
	<label for="strasse">
		<g:message code="lieferadresse.strasse.label" default="Strasse" />
		
	</label>
	<g:textField name="strasse" value="${lieferadresseInstance?.strasse}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'hausnummer', 'error')} ">
	<label for="hausnummer">
		<g:message code="lieferadresse.hausnummer.label" default="Hausnummer" />
		
	</label>
	<g:field name="hausnummer" type="number" value="${lieferadresseInstance.hausnummer}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'zusatz', 'error')} ">
	<label for="zusatz">
		<g:message code="lieferadresse.zusatz.label" default="Zusatz" />
		
	</label>
	<g:textField name="zusatz" value="${lieferadresseInstance?.zusatz}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'postleitzahl', 'error')} required">
	<label for="postleitzahl">
		<g:message code="lieferadresse.postleitzahl.label" default="Postleitzahl" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="postleitzahl" type="number" value="${lieferadresseInstance.postleitzahl}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'ort', 'error')} required">
	<label for="ort">
		<g:message code="lieferadresse.ort.label" default="Ort" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="ort" required="" value="${lieferadresseInstance?.ort}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'land', 'error')} ">
	<label for="land">
		<g:message code="lieferadresse.land.label" default="Land" />
		
	</label>
	<g:select id="land" name="land.id" from="${org.strotmann.partner.Land.list()}" optionKey="id" value="${lieferadresseInstance?.land?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'anfahrt', 'error')} ">
	<label for="anfahrt">
		<g:message code="lieferadresse.anfahrt.label" default="Anfahrt" />
		
	</label>
	<g:textArea name="anfahrt" value="${lieferadresseInstance?.anfahrt}" rows="2" cols="80"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lieferadresseInstance, field: 'partner', 'error')} required">
	<label for="partner">
		<g:message code="lieferadresse.partner.label" default="Partner" />
		<span class="required-indicator">*</span>
	</label>
	<g:if test="${flash.partner}">
		<g:select id="partner" name="partner.id" from="${flash.partner}" optionKey="id" required="" value="${lieferadresseInstance?.partner?.id}" class="many-to-one"/>
	</g:if>
	<g:else>
		<g:select id="partner" name="partner.id" from="${org.strotmann.partner.Partner.list()}" optionKey="id" required="" value="${lieferadresseInstance?.partner?.id}" class="many-to-one"/>
	</g:else>

</div>


