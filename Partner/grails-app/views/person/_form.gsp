<%@ page import="org.strotmann.partner.Person" %>
<%@ page import="org.strotmann.partner.Branche" %>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="person.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="30" pattern="${personInstance.constraints.name.matches}" required="" value="${personInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'hausadresse', 'error')} ">
	<label for="hausadresse">
		<g:message code="person.hausadresse.label"/>
		
	</label>
	<g:select id="hausadresse" name="hausadresse.id" from="${org.strotmann.partner.Hausadresse.getMiniList()}" optionKey="id" value="${personInstance?.hausadresse?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'hausadresse', 'error')} ">

<label for="hausadresse">
		<g:message code="person.hausadresse.label" default=" " />
		
	</label>

<g:link controller="hausadresse" action="create" params="['partner.id': personInstance?.id]">${message(code: 'default.newSimple.label')}</g:link>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'titel', 'error')} ">
	<label for="titel">
		<g:message code="person.titel.label"/>
		
	</label>
	<g:textField name="titel" maxlength="20" pattern="${personInstance.constraints.titel.matches}" value="${personInstance?.titel}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'vorname', 'error')} ">
	<label for="vorname">
		<g:message code="person.vorname.label"/>
		
	</label>
	<g:textField name="vorname" maxlength="30" pattern="${personInstance.constraints.vorname.matches}" value="${personInstance?.vorname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'geschlecht', 'error')} required">
	<label for="geschlecht">
		<g:message code="person.geschlecht.label"/>
		<span class="required-indicator">*</span>
	</label>
	<g:select name="geschlecht" from="${personInstance.constraints.geschlecht.inList}" value="${personInstance?.geschlecht}" valueMessagePrefix="person.geschlecht" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'geburtsdatum', 'error')} ">
	<label for="geburtsdatum">
		<g:message code="person.geburtsdatum.label"/>
		
	</label>
	<g:datePicker name="geburtsdatum" precision="day" years="${1920..2040}" value="${personInstance?.geburtsdatum}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'persoenlicheAnrede', 'error')} ">
	<label for="persoenlicheAnrede">
		<g:message code="person.persoenlicheAnrede.label"/>
		
	</label>
	<g:checkBox name="persoenlicheAnrede" value="${personInstance?.persoenlicheAnrede}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'nationalitaet', 'error')} ">
	<label for="nationalitaet">
		<g:message code="person.nationalitaet.label"/>
		
	</label>
	<g:select id="nationalitaet" name="nationalitaet.id" from="${org.strotmann.partner.Land.list()}" optionKey="id" value="${personInstance?.nationalitaet?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>


<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'religion', 'error')} ">
	<label for="religion">
		<g:message code="person.religion.label"/>
		
	</label>
	<g:select name="religion" from="${personInstance.constraints.religion.inList}" value="${personInstance?.religion}" valueMessagePrefix="person.religion" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'beruf', 'error')} ">
	<label for="beruf">
		<g:message code="person.beruf.label"/>
		
	</label>
	<g:select id="beruf" name="beruf.id" from="${Branche.branchenKurz(65)}" optionKey="id" value="${personInstance?.beruf?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'taetigkeit', 'error')} ">
	<label for="taetigkeit">
		<g:message code="person.taetigkeit.label"/>
		
	</label>
	<g:select id="taetigkeit" name="taetigkeit.id" from="${Branche.branchenKurz(65)}" optionKey="id" value="${personInstance?.taetigkeit?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'bankverbindung', 'error')} ">
	<label for="bankverbindungen">
		<g:message code="person.bankverbindungen.label"/>
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.bankverbindungen?}" var="b">
    <li><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bankverbindung" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'kommunikation', 'error')} ">
	<label for="kommunikationen">
		<g:message code="person.kommunikationen.label"/>
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.kommunikationen?}" var="k">
    <li><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>

<li class="add">
<g:link controller="kommunikation" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')])}</g:link>
</li>

</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'partnerrolle', 'error')} ">
	<label for="partnerrollen">
		<g:message code="person.partnerrollen.label.ist"/>
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.partnerrollen?}" var="p">
    <li><g:link controller="partnerrolle" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<fieldset class="buttons">
	<g:select name="partnerrolleInstance.rolle" from="${flash.rollenZuObjektnameListe}" value="${partnerrolleInstance?.rolle}" valueMessagePrefix="partnerrolle.objektname" />
	<g:actionSubmit action="toRolle" value="${message(code: 'default.button.create.label', default: 'Create')}" />
</fieldset>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'lastschriftmandat', 'error')} ">
	<label for="lastschriftmandate">
		<g:message code="person.lastschriftmandate.label"/>
		
	</label>
	
<ul class="one-to-many">
<g:each in="${personInstance?.lastschriftmandate?}" var="l">
    <li><g:link controller="lastschriftmandat" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="lastschriftmandat" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'lastschriftmandat.label', default: 'Lastschriftmandat')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="person.notizen.label" default="Notizen" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.notiz.Notiz.getNotizen('Person',personInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['person.id': personInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>

