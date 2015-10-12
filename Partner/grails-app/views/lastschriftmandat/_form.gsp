<%@ page import="org.strotmann.partner.Lastschriftmandat" %>



<div class="fieldcontain ${hasErrors(bean: lastschriftmandatInstance, field: 'glaeubiger', 'error')} required">
	<label for="glaeubiger">
		<g:message code="lastschriftmandat.glaeubiger.label" default="Glaeubiger" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="glaeubiger" name="glaeubiger.id" from="${org.strotmann.partner.Organisation.glaeubiger}" optionKey="id" required="" value="${lastschriftmandatInstance?.glaeubiger?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lastschriftmandatInstance, field: 'mandatTyp', 'error')} required">
	<label for="mandatTyp">
		<g:message code="lastschriftmandat.mandatTyp.label" default="Mandat Typ" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="mandatTyp" from="${lastschriftmandatInstance.constraints.mandatTyp.inList}" value="${lastschriftmandatInstance?.mandatTyp}" valueMessagePrefix="mandatTyp.category"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lastschriftmandatInstance, field: 'mandatsReferenz', 'error')} required">
	<label for="mandatsReferenz">
		<g:message code="lastschriftmandat.mandatsReferenz.label" default="Mandats Referenz" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="mandatsReferenz" required="" value="${lastschriftmandatInstance?.mandatsReferenz}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lastschriftmandatInstance, field: 'gueltigAb', 'error')} required">
	<label for="gueltigAb">
		<g:message code="lastschriftmandat.gueltigAb.label" default="Gueltig Ab" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="gueltigAb" precision="day"  value="${lastschriftmandatInstance?.gueltigAb}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: lastschriftmandatInstance, field: 'gueltigBis', 'error')} ">
	<label for="gueltigBis">
		<g:message code="lastschriftmandat.gueltigBis.label" default="Gueltig Bis" />
		
	</label>
	<g:datePicker name="gueltigBis" precision="day"  value="${lastschriftmandatInstance?.gueltigBis}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: lastschriftmandatInstance, field: 'abweichenderSchuldner', 'error')} ">
	<label for="abweichenderSchuldner">
		<g:message code="lastschriftmandat.abweichenderSchuldner.label" default="Abweichender Schuldner" />
		
	</label>
	<g:select id="abweichenderSchuldner" name="abweichenderSchuldner.id" from="${org.strotmann.partner.Partner.list()}" optionKey="id" value="${lastschriftmandatInstance?.abweichenderSchuldner?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lastschriftmandatInstance, field: 'bankverbindung', 'error')} required">
	<label for="bankverbindung">
		<g:message code="lastschriftmandat.bankverbindung.label" default="Bankverbindung" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="bankverbindung" name="bankverbindung.id" from="${org.strotmann.partner.Bankverbindung.list()}" optionKey="id" required="" value="${lastschriftmandatInstance?.bankverbindung?.id}" class="many-to-one"/>
</div>

