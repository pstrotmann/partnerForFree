<%@ page import="org.strotmann.partner.Organisation" %>
<%@ page import="org.strotmann.partner.Branche" %>
<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="organisation.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="80" pattern="${organisationInstance.constraints.name.matches}" required="" value="${organisationInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'hausadresse', 'error')} ">
	<label for="hausadresse">
		<g:message code="organisation.hausadresse.label" default="Hausadresse" />
		
	</label>
	<g:select id="hausadresse" name="hausadresse.id" from="${org.strotmann.partner.Hausadresse.getMiniList()}" optionKey="id" value="${organisationInstance?.hausadresse?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'hausadresse', 'error')} ">

<label for="hausadresse">
		<g:message code="person.hausadresse.label" default=" " />
		
	</label>

<g:link controller="hausadresse" action="create" params="['partner.id': organisationInstance?.id]">${message(code: 'default.newSimple.label')}</g:link>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'nameZusatz', 'error')} ">
	<label for="nameZusatz">
		<g:message code="organisation.nameZusatz.label"/>
		
	</label>
	<g:textField name="nameZusatz" maxlength="50" pattern="${organisationInstance.constraints.nameZusatz.matches}" value="${organisationInstance?.nameZusatz}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'rechtsform', 'error')} ">
	<label for="rechtsform">
		<g:message code="organisation.rechtsform.label"/>
		
	</label>
	<g:select name="rechtsform" from="${organisationInstance.constraints.rechtsform.inList}" value="${organisationInstance?.rechtsform}" valueMessagePrefix="organisation.rechtsform" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'branche', 'error')} ">
	<label for="branche">
		<g:message code="organisation.branche.label"/>
		
	</label>
	<g:select id="branche" name="branche.id" from="${Branche.branchenKurz(65)}" optionKey="id" value="${organisationInstance?.branche?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'bankverbindung', 'error')} ">
	<label for="bankverbindungen">
		<g:message code="person.bankverbindungen.label"/>
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.bankverbindungen?}" var="b">
    <li><g:link controller="bankverbindung" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bankverbindung" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bankverbindung.label', default: 'Bankverbindung')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'kommunikation', 'error')} ">
	<label for="kommunikationen">
		<g:message code="person.kommunikationen.label"/>
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.kommunikationen?}" var="k">
    <li><g:link controller="kommunikation" action="show" id="${k.id}">${k?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="kommunikation" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'kommunikation.label', default: 'Kommunikation')])}</g:link>
</li>
</ul>

</div>


<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'partnerrolle', 'error')} ">
	<label for="partnerrollen">
		<g:message code="person.partnerrollen.label.ist"/>
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.partnerrollen?}" var="p">
	<g:if test="${p?.objektname in p?.objektnamen}">
    	<li><g:link controller="partnerrolle" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
    </g:if>
    <g:else>
    	<li><g:fieldValue bean="${p}" field="beschreibung"/></li>
    </g:else>
</g:each>

<li class="add">
<fieldset class="buttons">
	<g:select name="partnerrolleInstance.rolle" from="${flash.rollenZuObjektnameListe}" value="${partnerrolleInstance?.rolle}" valueMessagePrefix="partnerrolle.objektname" />
	<g:actionSubmit action="toRolle" value="${message(code: 'default.button.create.label', default: 'Create')}" />
</fieldset>
</li>
</ul>
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'postfachadresse', 'error')} ">
	<label for="postfachadresse">
		<g:message code="partner.postfachadresse.label"/>
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.postfachadressen?}" var="p">
    <li><g:link controller="postfachadresse" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="postfachadresse" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'postfachadresse.label', default: 'Postfachadresse')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'lieferadresse', 'error')} ">
	<label for="lieferadresse">
		<g:message code="organisation.lieferadresse.label"/>
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.lieferadressen?}" var="p">
    <li><g:link controller="lieferadresse" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="lieferadresse" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'lieferadresse.label', default: 'Lieferadresse')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'lastschriftmandat', 'error')} ">
	<label for="lastschriftmandate">
		<g:message code="person.lastschriftmandate.label"/>
		
	</label>
	
<ul class="one-to-many">
<g:each in="${organisationInstance?.lastschriftmandate?}" var="l">
    <li><g:link controller="lastschriftmandat" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="lastschriftmandat" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'lastschriftmandat.label', default: 'Lastschriftmandat')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'glaeubigerId', 'error')} ">
	<label for="glaeubigerId">
		<g:message code="organisation.glaeubigerId.label"/>
		
	</label>
	<g:select name="glaeubigerId" from="${organisationInstance.constraints.glaeubigerId.inList}" value="${organisationInstance?.glaeubigerId}" valueMessagePrefix="organisation.glaeubigerId" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: organisationInstance, field: 'notizen', 'error')} ">
	<label for="notizen">
		<g:message code="person.notizen.label"/>
		
	</label>
	
<ul class="one-to-many">
<g:each in="${org.strotmann.notiz.Notiz.getNotizen('Organisation',organisationInstance.id)}" var="n">
    <li><g:link controller="notiz" action="show" id="${n.id}">${n}</g:link></li>
</g:each>
<li class="add">
<g:link controller="notiz" action="create" params="['organisation.id': organisationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'notiz.label', default: 'Notiz')])}</g:link>
</li>
</ul>

</div>

