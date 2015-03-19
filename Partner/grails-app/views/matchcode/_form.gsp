<%@ page import="org.strotmann.partner.Matchcode" %>



<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'partnerart', 'error')} ">
	<label for="partnerart">
		<g:message code="partner.art.label"/>
		
	</label>
	<g:select name="partnerart"  value="${matchcodeInstance?.partnerart}" from="${['p', 'o']}" noSelection="['':' ']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="partner.name.label"/>
		
	</label>
	<g:textField name="name"  value="${matchcodeInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'geschlecht', 'error')} ">
	<label for="geschlecht">
		<g:message code="person.geschlecht.label"/>
		
	</label>
	<g:select name="geschlecht"  value="${matchcodeInstance?.geschlecht}" from="${['m', 'f']}" noSelection="['':' ']" />

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'vorname', 'error')} ">
	<label for="vorname">
		<g:message code="person.vorname.label"/>
		
	</label>
	<g:textField name="vorname"  value="${matchcodeInstance?.vorname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'strasse', 'error')} ">
	<label for="strasse">
		<g:message code="hausadresse.strasse.label"/>
		
	</label>
	<g:textField name="strasse"  value="${matchcodeInstance?.strasse}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'postleitzahl', 'error')} ">
	<label for="postleitzahl">
		<g:message code="hausadresse.postleitzahl.label"/>
		
	</label>
	<g:field name="postleitzahl" type="number" value="${matchcodeInstance.postleitzahl}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: matchcodeInstance, field: 'ort', 'error')} ">
	<label for="ort">
		<g:message code="hausadresse.ort.label"/>
		
	</label>
	<g:textField name="ort"  value="${matchcodeInstance?.ort}"/>

</div>

