<%@ page import="org.strotmann.partner.Matchcode" %>



<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'partnerart', 'error')} ">
	<label for="partnerart">
		<g:message code="matchcode.partnerart.label" default="Partnerart" />
		
	</label>
	<g:select name="partnerart"  value="${matchcodeInstance?.partnerart}" from="${['p', 'o']}" noSelection="['':' ']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="matchcode.name.label" default="Name" />
		
	</label>
	<g:textField name="name"  value="${matchcodeInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'geschlecht', 'error')} ">
	<label for="geschlecht">
		<g:message code="matchcode.geschlecht.label" default="Geschlecht" />
		
	</label>
	<g:select name="geschlecht"  value="${matchcodeInstance?.geschlecht}" from="${['m', 'f']}" noSelection="['':' ']" />

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'vorname', 'error')} ">
	<label for="vorname">
		<g:message code="matchcode.vorname.label" default="Vorname" />
		
	</label>
	<g:textField name="vorname"  value="${matchcodeInstance?.vorname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'strasse', 'error')} ">
	<label for="strasse">
		<g:message code="matchcode.strasse.label" default="Strasse" />
		
	</label>
	<g:textField name="strasse"  value="${matchcodeInstance?.strasse}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'postleitzahl', 'error')} ">
	<label for="postleitzahl">
		<g:message code="matchcode.postleitzahl.label" default="Postleitzahl" />
		
	</label>
	<g:field name="postleitzahl" type="number" value="${matchcodeInstance.postleitzahl}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'ort', 'error')} ">
	<label for="ort">
		<g:message code="matchcode.ort.label" default="Ort" />
		
	</label>
	<g:textField name="ort"  value="${matchcodeInstance?.ort}"/>

</div>

