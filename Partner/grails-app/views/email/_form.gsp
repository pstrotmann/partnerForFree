<%@ page import="org.strotmann.mail.Email" %>



<div class="fieldcontain ${hasErrors(bean: emailInstance, field: 'sender', 'error')} required">
	<label for="sender">
		<g:message code="email.sender.label" default="Sender" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="sender" required="" value="${emailInstance?.sender}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: emailInstance, field: 'emailBetreff', 'error')} required">
	<label for="emailBetreff">
		<g:message code="email.emailBetreff.label" default="Email Betreff" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="emailBetreff" required="" value="${emailInstance?.emailBetreff}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: emailInstance, field: 'emailText', 'error')} required">
	<label for="emailText">
		<g:message code="email.emailText.label" default="Email Text" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="emailText" required="" value="${emailInstance?.emailText}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: emailInstance, field: 'anhaenge', 'error')} ">
	<label for="anhaenge">
		<g:message code="email.anhaenge.label" default="Anhaenge" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${emailInstance?.anhaenge?}" var="a">
    <li><g:link controller="emailAnhang" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="emailAnhang" action="create" params="['email.id': emailInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'emailAnhang.label', default: 'EmailAnhang')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: emailInstance, field: 'emailEmpfaengers', 'error')} ">
	<label for="emailEmpfaengers">
		<g:message code="email.emailEmpfaengers.label" default="Email Empfaengers" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${emailInstance?.emailEmpfaengers?}" var="e">
    <li><g:link controller="emailEmpfaenger" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="emailEmpfaenger" action="create" params="['email.id': emailInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'emailEmpfaenger.label', default: 'EmailEmpfaenger')])}</g:link>
</li>
</ul>


</div>

